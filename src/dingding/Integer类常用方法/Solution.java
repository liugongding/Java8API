package dingding.Integer类常用方法;

import org.junit.Test;

/**
 * @author liudingding
 * @ClassName Solution
 * @description
 * @date 2020/6/14 6:23 下午
 */
public class Solution {

    //将字符串转化为int类型
    @Test
    public void test1(){
        String str = "123";
        int result = Integer.parseInt(str);
        System.out.println(result);
    }

    //将数字转化为字符串
    @Test
    public void test2(){
        int a = 123;
        String result = Integer.toString(a);
    }
}
