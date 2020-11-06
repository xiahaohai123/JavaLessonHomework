package practice2;

/**
 * @PackageName:practice2
 * @ClassName:PersonTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/26 14:15
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        try {
            person.setAge(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
