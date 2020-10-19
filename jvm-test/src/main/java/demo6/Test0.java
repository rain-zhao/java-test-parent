package demo6;

import java.lang.reflect.Method;

public class Test0 {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("demo6.Test0");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}