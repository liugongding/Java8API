package dingding.流操作.map相关处理;

import dingding.流操作.StreamDemo.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liudingding
 * @ClassName Test6
 * @description
 * @date 2020/7/14 7:10 下午
 */
public class Test6 {

    @Test
    public void test1() {
        List<Student> studentList = Arrays.asList(
                new Student("3年1班", "周杰伦"),
                new Student("3年1班", "古天乐"),
                new Student("3年1班", "黄渤"),
                new Student("3年2班", "嘿嘿嘿"),
                new Student("3年2班", "哈哈哈")
        );

        Map<String, List<Student>> collect = studentList.stream()
                .collect(Collectors.groupingBy(Student::getClassName));


//        Map<String, List<String>> stringListMap = studentList.stream()
//                .collect(Collectors.toMap((Student::getClassName), item -> {
//                            List<String> nameList = new ArrayList<>();
//                            nameList.add(item.getName());
//                            return nameList;
//                        },
//                        (List<String> v1, List<String> v2) -> {
//                            v1.addAll(v2);
//                            return v1;
//                        }));
        Map<String, List<Student>> listMap = new HashMap<>();
        for (Student student : studentList) {
            listMap.computeIfAbsent(student.getClassName(), k -> new ArrayList<>()).add(student);
        }




        listMap.forEach((k,v) -> {
            System.out.println(k+":"+v);
        });
    }

    @Test
    public void test2(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("dicId", "aaa");
        map.put("dicName", "钢材");
        map.put("dicDes", "钢材1号");
        list.add(map);

        map = new HashMap<>();
        map.put("dicId", "bbb");
        map.put("dicName", "钢筋");
        map.put("dicDes", "钢筋1号");
        list.add(map);
        map = new HashMap<>();
        map.put("dicId", "111");
        map.put("dicName", "钢筋");
        map.put("dicDes", "钢筋2号");
        list.add(map);

        map = new HashMap<>();
        map.put("dicId", "bbb");
        map.put("dicName", "河沙");
        map.put("dicDes", "河沙1号");
        list.add(map);

        //比如以dicId分组成为Map<String, List<Map<String,Object>>>
        Map<String, List<Map<String, Object>>> glist = list.stream().collect(Collectors.groupingBy(e -> e.get("dicId").toString()));
        System.out.println(glist);
    }
}
