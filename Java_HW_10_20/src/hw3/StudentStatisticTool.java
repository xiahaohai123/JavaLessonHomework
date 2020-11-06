package hw3;

/**
 * @PackageName:hw3
 * @ClassName:StudentStatisticTool
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 15:27
 */
public class StudentStatisticTool {
    public static double avg(Student[] students) {
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getScore();
        }

        return sum / students.length;
    }
}
