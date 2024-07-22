package example.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class z_arraylist {
    public static void main(String[] args) {
        ArrayList<String> list_1 = new ArrayList<>();
        list_1.add("A");
        list_1.add("B");
        list_1.remove(0);
        try {
            System.out.println(list_1.get(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(arrayList3);

        int[] intArray1 = { 1, 2, 3, 4, 5 };
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.stream(intArray1).boxed().collect(Collectors.toList()));
        System.out.println(arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int[] intArray2 = arrayList2.stream().mapToInt(Integer::intValue).toArray();
        for (int i : intArray2)
            System.out.print(i + " ");
        System.out.println();

        List<String> list_2 = new ArrayList<>();
        list_2.add("a");
        list_2.add("b");
        list_2.add("c");

        // 创建顺序流
        Stream<String> stream = list_2.stream();
        stream.forEach(System.out::println);

        // 创建并行流
        Stream<String> parallelStream = list_2.parallelStream();
        parallelStream.forEach(System.out::println);

    }

}

