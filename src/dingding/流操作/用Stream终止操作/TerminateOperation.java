package dingding.流操作.用Stream终止操作;

import dingding.流操作.StreamDemo.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liudingding
 * @ClassName TerminateOperation
 * @description
 * @date 2020/6/9 10:11 下午
 */
public class TerminateOperation {

    List<Student> students = Arrays.asList(
            new Student("na", 40),
            new Student("liu", 10),
            new Student("gong", 20),
            new Student("ding", 30),
            new Student("xin", 50),
            new Student("xin", 50)
    );

    //1、allMatch检查是否匹配所有元素,anyMatch检查至少匹配一个元素，noneMatch所有元素都没匹配到
    @Test
    public void test1(){
        boolean allResult = students.stream()
                .allMatch(item -> item.getAge() > 1);
        System.out.println(allResult);

        boolean anyResult = students.stream()
                .allMatch(item -> item.getAge() > 20);
        System.out.println(anyResult);

        boolean noneResult = students.stream()
                .allMatch(item -> item.getAge() > 1);
        System.out.println(noneResult);
    }

    //2、返回流中元素的总个数count
    @Test
    public void test2(){
        long count = students.stream().count();
        System.out.println(count);
        System.out.println(students.size());
    }

    //3、max返回流中的最大值，max是从小到大计算最大值，min是从大到小计算最小值
    @Test
    public void test3(){
        //根据年龄大小正排序找出最大值
        Optional<Student> max = students.parallelStream()
                .max((a,b) -> Integer.compare(a.getAge(),b.getAge()));
        System.out.println(max);

        //先将每个学生的年龄映射出来，在对每个年龄比较产生最大值
        Optional<Integer> maxAge = students.parallelStream()
                .map(item -> item.getAge())
                .max((a,b) -> Integer.compare(a,b));
        System.out.println(maxAge);
    }

    //4、reduce将流中的元素反复结合，得到一个值
    @Test
    public void test4(){
        Optional<Integer> ageSum = students.stream()
                .map(item -> item.getAge())
                .reduce(Integer :: sum);
        System.out.println(ageSum);
    }

    //5、collect将流转化为其他形式:接受一个Collector接口的实现
    @Test
    public void test5(){
        List<String> nameList = students.stream()
                .map(item -> item.getName())
                .distinct()
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);
    }

    //6、下面是Collectors类的常用方法
    //6、count统计元素个数
    @Test
    public void test6(){
        long  count = students.stream().collect(Collectors.counting());
        System.out.println(count);
    }

    //7、summingDouble,summingInt,summingLong求年龄之和并转化为相应的类型
    @Test
    public void test7(){
        int ageSum = students.stream()
                .collect(Collectors.summingInt(item -> item.getAge()));
        System.out.println(ageSum);

        int ageSums = students.stream()
                .mapToInt(Student::getAge)
                .sum();
    }

    //8、maxBy根据函数条件求最大值
    @Test
    public void test8(){
        Optional<Student> studentOptional = students.stream()
                .collect(Collectors.maxBy((a,b)->Integer.compare(a.getAge(),b.getAge())));
        System.out.println(studentOptional.get());

        Optional<Student> studentOptionals = students.stream().max(Comparator.comparingInt(Student::getAge));
    }

    //9、groupingBy分组
    @Test
    public void test9(){
        //根据年龄分组
        Map<Integer, List<Student>> ageGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));
        ageGroup.forEach((key, value) -> {
            System.out.println(key +":"+value);
        });

        //现根据name分组，在根据年龄分组
        Map<String, Map<String, List<Student>>> groupMap = students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(item -> {
                    if (item.getAge() <= 20){
                        return "年轻人";
                    } else if(item.getAge() <= 50) {
                        return "中年人";
                    } else {
                        return "老年人";
                    }
                })));
        groupMap.forEach((key,value)->{
            System.out.println(key+":"+ value);
//            value.forEach((key1,value1)->{
//                System.out.println(key1+":"+value1);
//            });
        });
    }

    //10、joining连接字符串
    @Test
    public void test10(){
        String allName = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
        System.out.println(allName);
    }
}
