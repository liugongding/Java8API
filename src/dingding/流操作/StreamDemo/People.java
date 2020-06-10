package dingding.流操作.StreamDemo;


import java.util.Objects;

/**
 * @author liudingding
 * @ClassName People
 * @description
 * @date 2020/6/9 7:18 下午
 */

public class People {
    String name;
    Integer age;

    public static void main(String[] args) {
        People people1 = new People("liu",2);
        People people2 = new People("liu",2);
        System.out.println(people1 == people2);
        System.out.println(people1.equals(people2));
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) &&
                Objects.equals(age, people.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
