package oac3;

/**
 * @PackageName: oac3
 * @ClassName: AnnotationTest
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/23 19:22
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person person = new Person(19);
        System.out.println(person.checkAge() ? "具备选举权" : "未成年");
    }
}
