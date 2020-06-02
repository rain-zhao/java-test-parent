import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试自定义
 */
public class UserClassLoaderTest {

    /**
     * 重写findClass方法
     */
    static class UClassLoader1 extends ClassLoader {

        String path = "/Users/zhaozhenrong/Codes/workspace/my-test-project/";

        /**
         * 重写findClass
         *
         * @param name
         * @return
         * @throws ClassNotFoundException
         */
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            File file = new File( path+name+".class");
            if (!file.exists()) {
                throw new ClassNotFoundException(name);
            }
            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                fis.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return defineClass(name, bytes, 0, bytes.length);

        }

    }

    /**
     * 重写loadClass
     */
    static class UClassLoader2 extends ClassLoader {
        String path = "/Users/zhaozhenrong/Codes/workspace/my-test-project/";
        /**
         * 重写loadClass，破坏双亲委派模型
         *
         * @param name
         * @return
         * @throws ClassNotFoundException
         */
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            try {
                File file = new File(path + name + ".class");
                if (!file.exists()) {
                    throw new ClassNotFoundException(name);
                }
                byte[] bytes = new byte[(int) file.length()];
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    fis.read(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return defineClass(name, bytes, 0, bytes.length);
            }catch (ClassNotFoundException ex){
                //如果加载不成功才调用父加载器
                return super.loadClass(name);
            }

        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
        UClassLoader1 cl1 = new UClassLoader1();
        UClassLoader1 cl2 = new UClassLoader1();

        UClassLoader2 cl3 = new UClassLoader2();
        UClassLoader2 cl4 = new UClassLoader2();
        //1，重写defineClass，classpath中有对应classname
        Class<?> c1 = cl1.loadClass("CommomClass1");
        Class<?> c2 = cl2.loadClass("CommomClass1");

        //classpath有对应的classname，所以是由父classloader加载
        System.out.println(c1.equals(c2));

        //2，重写defineClass，classpath中没有对应classname
        Class<?> c3 = cl1.loadClass("CommomClass");
        Class<?> c4 = cl2.loadClass("CommomClass");

        //classpath没有对应的classname，所以最终由UClassLoader1加载
        //虽然加载同一个类，但是不同的加载起加载，也不相同
        System.out.println(c3.equals(c4));

        //3，重写loadclass
        Class<?> c5 = cl3.loadClass("CommomClass1");
        Class<?> c6 = cl4.loadClass("CommomClass1");

        //classpath有对应的classname，但重写loadclass破坏了双亲委派模型
        //所以由UClassLoader2加载
        System.out.println(c5.equals(c6));





    }
}
