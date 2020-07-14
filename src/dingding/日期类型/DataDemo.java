package dingding.日期类型;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author liudingding
 * @ClassName DataDemo
 * @description
 * Java8新的日期类api
 * @date 2020/6/10 12:57 下午
 */
public class DataDemo {


    //获取今天的日期
    @Test
    public void test1(){
        LocalDate today = LocalDate.now();
        System.out.println("今天日期："+today);
    }

    //获取年月日
    @Test
    public void test2(){
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int mouth = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        System.out.println(year);
        System.out.println(mouth);
        System.out.println(day);
    }

    //获取当前时间，不含日期
    @Test
    public void test3(){
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间："+localTime);
    }

    //计算一周后的日期
    @Test
    public void test4(){
        LocalDate localDate = LocalDate.now();
        System.out.println("今天日期："+localDate);
        //第一个参数表示传入数字几,第二个参数代表是年，月，日
        //1表示1周，ChronoUnit.WEEKS表示周，也可以是ChronoUnit.YEARS年
        LocalDate nextWeek = localDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期："+nextWeek);
    }

    //Clock时钟类，System.currentTimeInMillis和TimeZone.getDefault都可以用Clock代替
    @Test
    public void test5(){
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
    }

    //用java判断日期是否早于还是晚于一个时期
    @Test
    public void test6(){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(today.getYear(),today.getMonthValue(),today.getDayOfMonth()+1);
        LocalDate yesterday = LocalDate.of(today.getYear(),today.getMonthValue(),today.getDayOfMonth()-1);

        if (tomorrow.isAfter(today)){
            System.out.println("明天在今天之后");
        }

        if (yesterday.isBefore(today)){
            System.out.println("昨天在今天之前");
        }
    }

    @Test
    public void test7(){
        YearMonth currentYearMouth = YearMonth.now();
        System.out.println(currentYearMouth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2020, Month.DECEMBER);
        System.out.println(creditCardExpiry);
    }

    //计算两个日期之间的天数
    @Test
    public void test8(){
        LocalDate today = LocalDate.now();
        LocalDate release = LocalDate.of(2021,7,10);
        long years = today.until(release, ChronoUnit.YEARS);
        long month = today.until(release, ChronoUnit.MONTHS);
        long days = today.until(release, ChronoUnit.DAYS);
        System.out.println("相差"+years+"年");
        System.out.println("相差"+month+"月");
        System.out.println("相差"+days+"日");
    }

    //获取今天的日期及时间
    @Test
    public void test9(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    //日期格式化
    @Test
    public void test10(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(localDateTime.format(dateTimeFormatter));

    }




    public static void main(String[]args){
        int[]x={0,1,2,3};
        for (int i = 0; i < 3; i+=2) {
            try {
                System.out.println(x[i+2]/x[i]+x[i+1]);
            } catch (ArithmeticException e){
                System.out.println("error1");
            }catch (Exception e){
                System.out.println("error2");
            }
        }
    }
}
