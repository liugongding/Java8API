package dingding.流操作.StreamDemo;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liudingding
 * @ClassName Test2
 * @description
 * @date 2020/6/9 7:18 下午
 */
public class Test2 {
    List<Student> slist = ImmutableList.of(
            new Student("a",20),
            new Student("b",21),
            new Student("c",22)
    );

    /**
     * 将slist的数据复制到新的list
     */
    @Test
    public void test1(){
        List<People> peopleList = slist.stream().map(student ->
                new People(student.getName(),student.getAge())
        ).collect(Collectors.toList());
        peopleList.forEach(System.out::println);
    }

    /**
     * 使用map方法获取list数据中的name
     *
     * 个人推荐写法1
     */
    @Test
    public void test2(){
        //写法1
        List<String> stringList1 = slist.stream().map(student ->
                student.name
        ).collect(Collectors.toList());
        stringList1.forEach(System.out::println);

        //写法2
        List<String> stringList2 = slist.stream().map(
                Student::getName
        ).collect(Collectors.toList());
        stringList2.forEach(System.out::println);
    }

    /**
     * 获取name的长度
     */
    @Test
    public void test3(){
        //写法1
        List<Integer> stringList1 = slist.stream().map(student ->
                student.name.length()
        ).collect(Collectors.toList());
        stringList1.forEach(System.out::println);

        //写法2
        List<Integer> stringList2 = slist.stream()
                //先获取他的name
                .map(Student::getName)
                //在获取name的长度
                .map(String::length)
                .collect(Collectors.toList());
        stringList2.forEach(System.out::println);
    }

    /**
     * 将每个人的年龄 -10
     */
    @Test
    public void test4(){
        //写法1
        List<Integer> stringList1 = slist.stream().map(student ->
                student.age - 10
        ).collect(Collectors.toList());
        stringList1.forEach(System.out::println);

        //写法2
        List<Integer> stringList2 = slist.stream()
                .map(Student::getAge)
                .map(item -> item - 10)
                .collect(Collectors.toList());
        stringList2.forEach(System.out::println);
    }

    /**
     * 计算学生的总年龄
     */
    @Test
    public void test5(){
        //写法1
        Integer totalAge1 = slist.stream().mapToInt(student ->
                student.getAge()
        ).sum();
        System.out.println(totalAge1);

        //写法2
        Integer totalAge2 = slist.stream().mapToInt(Student::getAge).sum();
        System.out.println(totalAge2);

    }

    /**
     * 计算学生的总年龄
     */
    @Test
    public void test6(){
        //写法1
        Integer totalAge1 = slist.stream()
                .map(student -> student.getAge())
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalAge1);

        //写法2
        Integer totalAge2 = slist.stream()
                .map(Student::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalAge2);

    }

    /**
     * 计算平均值、求和
     */
    @Test
    public void test7(){
        double avg = slist.stream().collect(Collectors.averagingDouble(Student::getAge));
        System.out.println(avg);

        double sum = slist.stream().collect(Collectors.summingDouble(Student::getAge));
        System.out.println(sum);
    }

    /**
     * 全部大于2，才返回true
     */
    @Test
    public void test8(){
        //写法1
        boolean all1 = slist.stream().allMatch(student -> student.getAge() > 2);
        System.out.println(all1);

        //写法2
        boolean all2 = slist.stream().map(Student::getAge).allMatch(item -> item > 2);
        System.out.println(all2);
    }

    /**
     * 任意一个小于20,才返回true
     */
    @Test
    public void test9(){
        //写法1
        boolean any1 = slist.stream().anyMatch(student -> student.getAge() < 20);
        System.out.println(any1);

        //写法2
        boolean any2 = slist.stream().map(Student::getAge).anyMatch(item -> item < 20);
        System.out.println(any2);
    }

    /**
     * 没有一个大于2，才返回true
     */
    @Test
    public void test10(){
        //写法1
        boolean any1 = slist.stream().noneMatch(student -> student.getAge() > 2);
        System.out.println(any1);

        //写法2
        boolean any2 = slist.stream().map(Student::getAge).noneMatch(item -> item > 2);
        System.out.println(any2);
    }
}
