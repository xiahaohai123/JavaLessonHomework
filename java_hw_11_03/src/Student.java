import java.io.Serializable;

enum Gender {
    男, 女;
}

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Student
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 14:37
 */
public class Student implements Serializable {
    // 性别
    private Gender gender;
    // 名字
    private String name;
    // 年龄
    private int age;

    public Student(Gender gender, String name, int age) {
        this.gender = gender;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("gender=").append(gender);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
