package dingding.流操作.StreamDemo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author liudingding
 * @ClassName Test4
 * @description
 * @date 2020/6/9 7:19 下午
 */
public class Test4 {
    List<Student> slist = ImmutableList.of(
            new Student("a", 20),
            new Student("b", 21),
            new Student("c", 22)
    );


    /**
     * 将list转为map，key为姓名，value为年龄
     */
    @Test
    public void test1() {
        //写法1
        Map<String, Integer> map1 = slist.stream().collect(Collectors.toMap(
                s -> s.getName(), i -> i.getAge()
        ));
        System.out.println(map1);

        //写法2
        Map<String, Integer> map2 = slist.stream().collect(Collectors.toMap(
                Student::getName, Student::getAge
        ));
        System.out.println(map2);
    }

    /**
     * 将list转为map，key为姓名，value为学生对象
     */
    @Test
    public void test2() {
        //写法1
        Map<String, Student> map1 = slist.stream().collect(Collectors.toMap(
                s -> s.getName(), student -> student
        ));
        System.out.println(map1);

        //写法2
        Map<String, Student> map2 = slist.stream().collect(Collectors.toMap(
                // static <T> Function<T, T> identity() {
                //        return t -> t;
                //    }
                //通过源码我们知道，只是为了看起来更美观
                Student::getName, Function.identity()
        ));
        System.out.println(map2);
    }

    /**
     * 将list转为map，key为字符，value为字符的长度
     */
    @Test
    public void test3() {
        List<String> slist = Lists.newArrayList("hello", "world", "HelloWorld");

        Map<String, Integer> map1 = slist.stream().collect(Collectors.toMap(
                Function.identity(), i -> i.length()
        ));
        System.out.println(map1);

        Map<String, Integer> map2 = slist.stream().collect(Collectors.toMap(
                Function.identity(), String::length
        ));
        System.out.println(map2);
    }

    /**
     * 将list转化为数组,然后遍历
     */
    @Test
    public void test4() {
        List<Integer> integerList = Ints.asList(1, 2, 3, 4);

        //将list转化为数组
        int[] reslut = integerList.stream().mapToInt(Integer::intValue).toArray();
        //数组流化
        IntStream intStream = Arrays.stream(reslut);
        //没有中间操作
        //遍历
        intStream.forEach(System.out::println);


        //上面是一步步完整些法、下面是简写
        //1、数据源：Arrays.stream(result)
        //2、0个中间操作
        //3、终止操作：forEach
        Arrays.stream(reslut).forEach(System.out::println);
    }

    @Test
    public void test5() {
        String[] words = new String[]{"hello", "world"};
        List<String> stringList = Arrays.stream(words)
                //split处理完之后右是一个数组、所以结果是二维数组
                //[["h","e","l","l","o"],["w","o","r","l","d"]]
                .map(word -> word.split(""))
                //扁平化处理
                .flatMap(word -> Arrays.stream(word))
                //去重
                .distinct()
                //添加进list
                .collect(Collectors.toList());
        System.out.println(stringList.size());
        stringList.forEach(System.out::println);
    }

    @Test
    public void test6(){
        List<Integer> integerList = ImmutableList.of(1,2,3,4,1,2);
        integerList.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

        List<String> stringList = ImmutableList.of("a","b","a","c");
        stringList.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

    }

    /**
     * 没有重写equals的情况下 == 和 equals 的效果是一样的
     * 重写了equals的情况下 == 比较的是地址，equals比较的是内容
     */
    @Test
    public void test7(){
        List<Student> studentList = ImmutableList.of(
                new Student("a",20),
                new Student("a",20),
                new Student("c",20),
                new Student("b",20)
        );
        //方法1
        List<Student> removeDuplicate = new ArrayList<>();
        studentList.forEach(item -> {
            if (!removeDuplicate.contains(item)) {
                removeDuplicate.add(item);
            }
        });
        removeDuplicate.forEach(System.out::println);

        //方法2
        studentList.stream().distinct().forEach(System.out::println);

        //方法3
        System.out.println("===========");
        List<Student> unique1 = studentList.stream().
                collect(collectingAndThen(
                        toCollection(() ->
                                new TreeSet<>(comparing(Student::getName))), ArrayList::new));
        unique1.forEach(System.out::println);
    }
}
