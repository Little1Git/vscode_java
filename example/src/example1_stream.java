package example.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Stream流以一种更加简洁、可读性更强的方式来处理数据。
public class example1_stream {
        public static void main(String[] args) {
                List<String> list = Arrays.asList("apple", "banana", "cherry");
                List<String> result = list.stream()
                                .filter(s -> s.length() > 5) // 过滤流中的元素，只保留符合条件的元素
                                                             // 只有当lambda表达式返回true时，元素才会保留在流中。如果返回false，该元素会被排除。
                                .map(String::toUpperCase) // 将流中的每个元素按照指定的方式映射为另一个元素。返回一个新的流
                                .collect(Collectors.toList()); // collect()方法会将处理后的流结果收集起来，形成一个新的集合。
                // Collectors.toList()方法默认返回的是一个ArrayList对象。因为ArrayList是List接口的一个常见实现
                System.out.println(result); // 输出 [BANANA, CHERRY]
                System.out.println(result.getClass().getName());
                // Stream 的操作是通过管道（pipeline）方式处理的，
                // 这意味着每个元素会依次通过所有操作，而不是整个集合先经过一个操作再经过下一个操作。

                List<String> list2 = Arrays.asList("apple", "banana", "cherry");
                List<String> result2 = list2.parallelStream()
                                .filter(s -> s.length() > 5)
                                .map(String::toUpperCase)
                                .collect(Collectors.toList());
                System.out.println(result2);
                // parallelStream()
                // 并行流（parallelStream）本身是线程安全的：Java的并行流通过内部使用ForkJoinPool来管理并行任务，并且能够保证流操作的线程安全性。
                // 中间操作是无状态的：例如，filter、map等中间操作在每个元素上独立执行，不会引起线程安全问题。

                // ForkJoinPool是Java 7引入的并行处理框架, 将大任务分割成更小的子任务，然后并行处理这些子任务，最后将结果合并。
                // 不适合I/O密集型任务。

                // Collections.synchronizedList 会在内部使用同步锁，以确保线程安全。
                // 锁竞争：在高并发环境中，如果多个线程频繁访问或修改同步集合，会导致锁竞争，从而降低性能。

                // 如果在流操作中使用了共享的可变状态，可能会引发线程安全问题。
                // 使用线程安全的集合
                List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
                List<Integer> result3 = Collections.synchronizedList(new ArrayList<>());// List<T>
                list3.parallelStream().forEach(result3::add); 
        }

}
