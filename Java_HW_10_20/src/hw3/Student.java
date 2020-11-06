package hw3;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Student
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 15:19
 */
public class Student {
    // 学号
    private String no;
    // 姓名
    private String name;
    // 成绩
    private double score;

    // 构造器
    public Student(String no, String name, double score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }

    // 返回学生信息
    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(no).append("\t\t\t").append(name).append("\t\t\t").append(score);
        System.out.println(stringBuilder.toString());
    }

    public double getScore() {
        return score;
    }
}
