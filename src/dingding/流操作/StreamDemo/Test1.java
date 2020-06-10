package dingding.流操作.StreamDemo;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liudingding
 * @ClassName Test1
 * @description
 *  * Java8中，所有的流操作会被组合到一个 stream pinpeline 中(将多个操作连接到一起组成一个功能强大操作)
 *  * 一个stream pinpeline首先会有一个数据源，这个数据源可能是数组，集合，IO通道，流操作并不会改变
 *  * 数据源的内容。然后会零个或多个中间操作，每个中间操作会将接受到的流转化成另一个流；最后又一个终止
 *  * 操作，会生成一个最终结果(如Collection.toList)
 *  *
 *  * 总结：
 *  * 1、数据源(数组，集合，IO通道)
 *  * 2、零个或多个中间操作(操作过程用lambda语法表示)
 *  * 3、终止操作(sum,collection.toList)
 *  *
 *  * 我们的流处理是有返回结果的.比如我们处理集合，我们就返回一个流的集合
 *  * 计算年龄，我们就返回一个Integer的结果
 *  *
 *  * Lambda表达式 (Student s) -> (s.getName)
 *  * 我们为了简写，可采用  s -> s.getName
 * @date 2020/6/9 7:18 下午
 */
public class Test1 {

    /**
     * 1、创建流的几种方式
     * 2、将流中的字符全部转换成大写字母并返回一个新的集合
     *
     * 方法介绍：
     * 创建流： Stream.of(T... values), Arrays.stream(T[] array), Collection.stream
     * Stream的map方法： map方法接受一个函数式接口的实例（即可以是对象或者说类的实例），对每个元素进行映射处理
     * Stream的collect方法： collect方法接受一个函数式接口
     */
    @Test
    public void createStream(){

        //第一种，通过Stream接口的of静态方法创建一个流
        Stream<String> stream1 = Stream.of("hello","world");

        //第二种，通过Array类的stream方法，第一种of方法底层也是调用的
        //Arrays.stream(T... values)
        String[] array = new String[]{"hello","world"};
        Stream<String> stream2 = Arrays.stream(array);

        //第三种，通过Collection接口的默认方法，所有集合都继承了该方法
        //即任意一个集合都能调用stream方法创建流
        List<String> slist = ImmutableList.of(
                "hello","world"
        );
        Stream<String> stream3 = slist.stream();

        //将流中的字符全部转换成大写字母并返回一个新的集合
        //这里我们使用了Stream的map方法，map方法接受一个Function函数式接口的实例，方法参数对每一个
        //元素进行映射。然后传入lambda表达式将每个元素转换大写，通过collect方法处理的结果收集到list中
        List<String> newList = stream3.map(item ->
                item.toUpperCase()
        ).collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

    @Test
    public void test(){
        Stream<List<Integer>> listStream =
                Stream.of(Arrays.asList(1),Arrays.asList(1,2),Arrays.asList(1,2,3));

        List<Integer> list = listStream
                //我们把多个容器映射到一个容器
                .flatMap(item -> item.stream())
                //将容器中的每一个元素映射成每一个元素的平方
                .map(item -> item*item)
                //将结果流收集到List中
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    /**
     * 遍历二维数组
     */
    @Test
    public void test2(){
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        Arrays.stream(matrix)
                .map(item -> Arrays.toString(item))
                .forEach(System.out::println);
    }
}
