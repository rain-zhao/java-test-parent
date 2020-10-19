package demo12;


import java.util.ArrayList;

public class demo {
    public void foo() {
        var value = 1;
        var list = new ArrayList<Integer>();
        list.add(value);
        //list.add("1"); //这一句能够编译吗？
    }

    public static void main(String[] args) {

    }
}
