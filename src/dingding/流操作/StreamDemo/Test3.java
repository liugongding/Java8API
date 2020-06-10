package dingding.流操作.StreamDemo;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liudingding
 * @ClassName Test3
 * @description
 * @date 2020/6/9 7:19 下午
 */
public class Test3 {
    List<String> sList = ImmutableList.of("red", "green", "black", "white");
    List<Integer> integerList = ImmutableList.of(1,2,3,4,5,6);
    /**
     * 将字符全部转换为大写
     */
    @Test
    public void test1(){
        //写法1
        List<String> newSList1 = sList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        newSList1.forEach(System.out::println);

        //写法2
        List<String> newSList2 = sList.stream().map(String::toUpperCase).collect(Collectors.toList());
        newSList2.forEach(System.out::println);
    }

    /**
     * 将字符全部转换为大写,并把每个单词用逗号连接起来
     */
    @Test
    public void test2(){
        //写法1
        String strings1 = sList.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.joining(","));
        System.out.println(strings1);

        //写法2
        String strings2 = sList.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(strings2);
    }

    /**
     * 将字符全部转换为大写,并把每个单词用逗号连接起来,并添加到集合中
     */
    @Test
    public void test3(){
        List<String> strings1 = sList.stream()
                .map(s -> s.toUpperCase())
                .map(s -> s.concat(","))
                .collect(Collectors.toList());
        strings1.forEach(System.out::println);
    }

    /**
     * 将每个数乘以2
     */
    @Test
    public void test4(){
        List<Integer> integersList = integerList.stream().map(integer ->
                integer*2
        ).collect(Collectors.toList());
        integersList.forEach(System.out::println);
    }

    /**
     * 将每个偶数数乘以2
     *
     * filter过滤
     * map方法传入的是一个函数式的实例，所以必须有一个返回值
     *
     * 个人推荐写法1
     */
    @Test
    public void test5(){
        //写法1
        List<Integer> integersList = integerList.stream()
                //将偶数筛选出来
                .filter(integer -> integer%2 == 0)
                //将筛选的偶数乘以2
                .map(integer -> integer*2)
                .collect(Collectors.toList());
        integersList.forEach(System.out::println);

        //写法2
        List<Integer> newList = new ArrayList<>();
        integerList.forEach(item -> {
            if (item%2 == 0){
                newList.add(item*2);
            }
        });
        newList.forEach(System.out::println);
    }

    /**
     * 将奇数选出来添加到list
     */
    @Test
    public void test6(){
        List<Integer> iList = integerList.stream().filter(
                integer -> integer%2 != 0
        ).collect(Collectors.toList());
        iList.forEach(System.out::println);
    }


    /**
     * 输出小于0的任意一个数，如果没有就输出100
     *
     * parallelStream采用的是多线程处理的
     * findAny返回的是最快处理完的那个线程的数据
     */
    @Test
    public void test7(){
        Integer any = integerList.parallelStream()
                .filter(integer -> integer > 0)
                .findAny()
                //看源码可知，流处理的结果不为null，返回处理的结果
                //如果为空，返回入参
                //    orElse(T other) {
                //        return value != null ? value : other;
                //    }
                .orElse(100);
        System.out.println(any);
    }

    /**
     * 计算总数
     */
    @Test
    public void test8(){
        Long l = integerList.stream().count();
        System.out.println(l);
    }
}
