package ppt.day22;

/**
 * @PackageName:ppt.practice2
 * @ClassName:equalsTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 14:17
 */
public class equalsTest {
    public static void main(String[] args) {
        Student student1 = new Student("16a10001", "甲", 16);
        Student student2 = new Student("16a10001", "甲", 16);
        Student student3 = new Student("16a10001", "甲", 15);
        Student student4 = new Student("16a10002", "乙", 14);

        System.out.println("stu1 equals stu1:" + student1.equals(student1));
        System.out.println("stu1 equals stu2:" + student1.equals(student2));
        System.out.println("stu1 equals stu3:" + student1.equals(student3));
        System.out.println("stu1 equals stu4:" + student1.equals(student4));
    }
}
