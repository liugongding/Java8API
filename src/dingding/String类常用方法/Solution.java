package dingding.String类常用方法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liudingding
 * @ClassName Solution
 * @description
 * @date 2020/6/14 2:58 下午
 */
public class Solution {



    //1、字符与字符串
    //charAt：获取指定下标位置的字符
    @Test
    public void test1(){
        String str = "hello";
        char c = str.charAt(0);
        System.out.println(c);
    }

    //字符数组与字符串的转换
    @Test
    public void test2(){
        String str = "hello";
        char[] data = str.toCharArray();
        for (int i = 0; i <data.length; i++) {
            System.out.println(data[i]);
        }
    }

    //equals：字符串是否相同
    @Test
    public void test3(){
        String str1 = "hello";
        String str2 = "world";
        if (str1.equals(str2)){
            System.out.println("相同");
        } else {
            System.out.println("不相同");
        }
    }

    //equalsIgnoreCase：忽略大小写后字符串是否相同
    @Test
    public void test4(){
        String str1 = "hello";
        String str2 = "heLLo";
        if (str1.equalsIgnoreCase(str2)){
            System.out.println("相同");
        } else {
            System.out.println("不相同");
        }
    }

    //indexOf：目标字符或字符串在源字符串中位置下标
    @Test
    public void test5(){
        String str1 = "hello";
        //如果目标字符没有出现则返回-1
        System.out.println(str1.indexOf("h"));
    }

    //lastIndexOf：目标字符或字符串在源字符串中最后一次出现的位置下标
    @Test
    public void test6(){
        String str = "helloworld";
        System.out.println(str.lastIndexOf("o"));
    }

    //valueOf：其他类型转字符串
    @Test
    public void test7(){
        String str = "123";
        System.out.println(Integer.valueOf(str));
        System.out.println(Integer.valueOf(str).getClass());
    }

    //isEmpty：字符串长度是否为0
    @Test
    public void test8(){
        String str = "hello";
        if (str.isEmpty()){
            System.out.println("为空");
        }else {
            System.out.println("不为空");
        }
    }

    //contains：是否包含目标字符串
    @Test
    public void test9(){
        String str = "helloworld";
        if (str.contains("hello")){
            System.out.println("包含");
        } else{
            System.out.println("不包含");
        }
    }

    //startsWith：是否以目标字符串开头
    @Test
    public void test10(){
        String str = "hello";
        if (str.startsWith("he")){
            System.out.println("是");
        } else {
            System.out.println("否");
        }
    }

    //endsWith：是否以目标字符串结束
    @Test
    public void test11(){
        String str = "hello";
        if (str.endsWith("h")){
            System.out.println("是");
        } else {
            System.out.println("否");
        }
    }

    //format：格式化字符串
    @Test
    public void test12(){
        String str1 = "hello";
        String str = String.format("%sworld",str1);
        System.out.println(str);
    }

    //replace：字符串替换
    @Test
    public void test13(){
        String str = "hello.world";
        String str1 = str.replace(".", ",");
        System.out.println(str1);
    }

    //split：以某正则表达式分割字符串
    @Test
    public void test14(){
        String str = "hello.world";
        String[] strings = str.split("\\.");
        Arrays.stream(strings)
                .forEach(System.out::println);
    }

    //substring：截取字符串,区间为[),左闭右开
    @Test
    public void test15(){
        String str = "www.google.com";
        System.out.println(str.substring(4));
        System.out.println(str.substring(4,10));
    }

    //toUpperCase：字符串转大写
    @Test
    public void test16(){
        String str = "hello";
        System.out.println(str.toUpperCase());
    }

    //trim：去字符串首尾空格
    @Test
    public void test17(){
        String str = " hello    ";
        String newStr = str.trim();
        System.out.println(newStr);
        System.out.println(newStr.length());
    }
}
