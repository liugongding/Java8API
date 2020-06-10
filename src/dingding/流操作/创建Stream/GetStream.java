package dingding.流操作.创建Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author liudingding
 * @ClassName GetStream
 * @description
 * @date 2020/6/9 7:33 下午
 */
public class GetStream {

    //通过Collection系列西河提供的穿行流Stream，并行流paralleStream
    List<String> list = new ArrayList<>();
    Stream<String> stringStream1 = list.stream();
    Stream<String> stringStream2 = list.parallelStream();

    //通过Arrays中的静态方法stream获取数组流
    String[] strs = new String[10];
    Stream<String> stream = Arrays.stream(strs);

    //通过Stream类的静态方法of()
    Stream<String> stringStream = Stream.of("liu","gong","ding");
}
