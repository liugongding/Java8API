package dingding.流操作.用Stream中间操作;

import dingding.流操作.StreamDemo.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author liudingding
 * @ClassName IntermediateOperation
 * @description
 * @date 2020/6/9 7:57 下午
 */
public class IntermediateOperation {

    List<Student> students = Arrays.asList(
            new Student("na", 40),
            new Student("liu", 10),
            new Student("gong", 20),
            new Student("ding", 30),
            new Student("xin", 50),
            new Student("xin", 50)
    );


    //1、filter过滤实现
    @Test
    public void test1() {
        Stream<Student> studentStream = students.stream()
                .filter(item -> item.getAge() > 10);
        studentStream.forEach(System.out::println);
    }


    //2、limit限制元素数量
    @Test
    public void test2() {
        //先通过filter过滤，在根据limit截断流，让后续擦啊哦做不在进行
        students.stream()
                .filter(item -> item.getAge() > 20)
                .limit(2)
                .forEach(System.out::println);
    }

    //3、skip跳过元素
    @Test
    public void test3() {
        //返回跳过前n个元素，若流中的元素不足n个，则返回一个空流
        students.stream()
                .filter(item -> item.getAge() > 20)
                .skip(2)
                .forEach(System.out::println);
    }

    //4、distinct去重
    @Test
    public void test4() {
        //根据流产生的hashode和equals来去重的
        students.stream()
                .distinct()
                .forEach(System.out::println);
    }

    //5、map映射，该方法里面接受一个lambda作为参数，将每一个元素映射成一个新的元素
    @Test
    public void test5() {
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream()
                .map(item -> item.toUpperCase())
                .forEach(System.out::println);

        students.stream()
                .map(item -> item.getName())
                .limit(3)
                .forEach(System.out::println);
    }

    //6、自然排序sorted，实现compare to方法
    @Test
    public void test6() {
        List<String> strings = Arrays.asList("啊", "哈哈");
        strings.stream()
                .sorted()
                .forEach(System.out::println);
    }

    //7、指定排序sorted，实现comparator接口
    @Test
    public void test7() {
        students.stream()
                .sorted((a, b) -> {
                    if(a.getAge().equals(b.getAge())){
                        return a.getName().compareTo(b.getName());
                    } else {
                        return a.getAge().compareTo(b.getAge());
                    }
                })
                .forEach(System.out::println);
    }
}
