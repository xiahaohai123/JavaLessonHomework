package hw3;

/**
 * @PackageName:hw3
 * @ClassName:StudentTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 15:26
 */
public class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new Student("2016001", "lily", 89.0);
        students[1] = new Student("2016002", "linlin", 90.0);
        students[2] = new Student("2016003", "sunner", 78.0);
        students[3] = new Student("2016004", "jams", 67.0);
        students[4] = new Student("2016005", "dandan", 95.0);
        System.out.println("学号\t\t\t姓名\t\t\t成绩");
        for (Student student : students) {
            student.show();
        }

        System.out.println("平均分：" + StudentStatisticTool.avg(students));

    }
}
