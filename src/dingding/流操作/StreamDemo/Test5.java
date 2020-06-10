package dingding.流操作.StreamDemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liudingding
 * @ClassName Test5
 * @description
 * @date 2020/6/9 7:19 下午
 */
public class Test5 {

    /**
     * 将int类型的数组转化为string类型的数组
     *
     * 在java8的api中是没有直接转化的api的
     * 我们可以先将数组转化为list，然后list在转化为数组
     */
    @Test
    public void test1(){
        int[] array = {3,32,321};
        Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList())
                .toArray(new String[]{});
    }

    /**
     * 将int数组转化为String类型，并将每个字符拼接在一起
     */
    @Test
    public void test2(){
        int[] array = {3,32,321};
        Stream<Object> a = Arrays.stream(array)
                .mapToObj(String::valueOf);
        System.out.println(a.getClass());
    }


    /**
     * 找出数组或集合中最大最小的值
     */
    @Test
    public void test3(){
        int[] array = {1,3,53,23};
        List<Integer> list = Arrays.asList(1,32,445,43);
        int aMax = Arrays.stream(array).max().getAsInt();
        int aMin = Arrays.stream(array).min().getAsInt();
        int lMax = Collections.max(list);
        int lMin = list.stream().min(Comparator.naturalOrder()).orElse(null);
    }
}
