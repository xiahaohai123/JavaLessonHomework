package oac2;

/**
 * @PackageName: oac2
 * @ClassName: AnnotationTest
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/23 18:57
 */

public class AnnotationTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Person student = new Student();
        Student student1 = new Student();
        Person person = new Person();
        System.out.println(person.getName());
    }
}
