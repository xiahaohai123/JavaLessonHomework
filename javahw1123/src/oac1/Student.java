package oac1;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: oac1.Student
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/23 18:26
 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("oac1.Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public void operator1() {
    }

    public int operator2(String a) {
        return 0;
    }

    public double operator2(String a, int b) {
        return 0.0;
    }
}
