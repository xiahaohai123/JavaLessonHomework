package pptHW;

/**
 * @PackageName:pptHW
 * @ClassName:Student
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 13:33
 */
public class Student {

    private String name;
    private int age;
    // 在读班级
    private String studyClass;
    private String hobby;

    public Student(String name, int age, String studyClass, String hobby) {
        this.name = name;
        this.age = age;
        this.studyClass = studyClass;
        this.hobby = hobby;
    }

    public static void main(String[] args) {
        // 利用构造器初始化参数
        Student student = new Student("张浩", 10, "S1", "篮球");
        // 自动调用toString
        System.out.println(student);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", studyClass='").append(studyClass).append('\'');
        sb.append(", hobby='").append(hobby).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
