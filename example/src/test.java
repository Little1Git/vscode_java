package example.src;

import java.util.ArrayList;
import java.util.Arrays;

public class test { // 只能有一个public class
    public static void main(String[] args) {
        int a = 10;
        func_(a);
        System.out.println(a);

        Integer b = 10;
        func_(b);
        System.out.println(b);

        int[] array = { 1, 2, 3 };
        func_(array);
        System.out.println(Arrays.toString(array));

        Data data = new Data(10);
        func_(data);
        System.out.println(data.num);

        Integer c = 10;
        Integer d = 10;
        System.out.println(d == c);
        d += 9999;
        c += 9999;
        System.out.println(d == c);
        System.out.println(d.equals(c));

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.remove(0);
        try {
            System.out.println(list.get(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void func_(int i) {
        i = 20;
    }

    public static void func_(Integer i) {
        i = 20;
    }

    public static void func_(Data data) {
        data.num = 20;
    }

    public static void func_(int[] i) {
        i[0] = 20;
    }
}

class Data {
    int num;

    public Data(int num) {
        this.num = num;
    }
}
