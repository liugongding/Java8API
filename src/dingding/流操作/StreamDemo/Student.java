package dingding.流操作.StreamDemo;

import lombok.Data;

import java.util.Objects;

/**
 * @author liudingding
 * @ClassName Student
 * @description
 * @date 2020/6/9 7:18 下午
 */
@Data
public class Student {
    public String name;
    public Integer age;
    public String className;


    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(String className, String name){
        this.className = className;
        this.name = name;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
