package pptHW;

/**
 * @PackageName:pptHW
 * @ClassName:Teacher
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 13:40
 */
public class Teacher {
    private String name;
    private String major;
    private String teachClass;
    private int teachingAge = 10;

    public Teacher(String name, String major, String teachClass, int teachingAge) {
        this.name = name;
        this.major = major;
        this.teachClass = teachClass;
        this.teachingAge = teachingAge;
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher("王老师", "计算机", "使用Java语言理解程序逻辑", 5);
        System.out.println(teacher);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("name='").append(name).append('\'');
        sb.append(", major='").append(major).append('\'');
        sb.append(", teachClass='").append(teachClass).append('\'');
        sb.append(", teachingAge=").append(teachingAge);
        sb.append('}');
        return sb.toString();
    }
}
