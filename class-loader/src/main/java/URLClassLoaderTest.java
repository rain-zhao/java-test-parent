import java.net.URL;
import java.net.URLClassLoader;

/**
 * 测试使用URLClassLoader
 */
public class URLClassLoaderTest {
    public static void main(String[] args) throws Exception {
        String path = "file:///Users/zhaozhenrong/Codes/workspace/my-test-project/target/classes/";
        URLClassLoader cl1 = new URLClassLoader(new URL[]{new URL(path)});
        URLClassLoader cl2 = new URLClassLoader(new URL[]{new URL(path)});
//        Class<?> depv1Class = cl1.loadClass("CommomClass");
        Class<?> c1 = cl1.loadClass("CommomClass1");
        Class<?> c2 = cl2.loadClass("CommomClass1");

        //就算不同的classLoader加载也是同一个类，因为双亲委派模型，实际上调用的类加载器是appClassLoader
        System.out.println(c1.equals(c2));

        Object depv1 = c1.getConstructor().newInstance();
        c1.getMethod("print").invoke(depv1);

        Object depv2 = c2.getConstructor().newInstance();
        c2.getMethod("print").invoke(depv2);

        String path2 = "file:///Users/zhaozhenrong/Desktop/";
        URLClassLoader cl3 = new URLClassLoader(new URL[]{new URL(path2)});
        URLClassLoader cl4 = new URLClassLoader(new URL[]{new URL(path2)});

        Class<?> c3 = cl3.loadClass("CommomClass");
        Class<?> c4 = cl4.loadClass("CommomClass");

        System.out.println(c3.equals(c4));
    }
}
