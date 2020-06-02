public class PrintCommonClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = PrintCommonClassLoaderTest.class.getClassLoader();

        System.out.println(loader.toString());
        System.out.println(loader.getParent().toString());

        //返回时null的话,就默认使用启动类加载器作为父加载器.
        System.out.println(loader.getParent().getParent());


        //ExtClassLoader默认的加载路径
        System.out.println(System.getProperty("java.ext.dirs"));
        //AppClassLoader默认的加载路径
        System.out.println(System.getProperty("java.class.path"));

    }

}
