package practice2;

/**
 * @PackageName:practice2
 * @ClassName:Person
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/26 14:13
 */
public class Person {
    int age;

    public Person(int age) {
        this.age = age;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age > 0 && age <= 100) {
            this.age = age;
        } else {
            throw new Exception("年龄必须在1到100之间！");
        }
    }
}
