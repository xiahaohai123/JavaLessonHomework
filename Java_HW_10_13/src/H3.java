import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:H3
 * @Description: 某班级有10个学员，学员姓名存储在数组中，现在在数组中查找此班级是否有用户输入的学员姓名，如果找到了，输出“该学员在此班”，否则输出“没有找到” （”dd”.equals()）
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/13 13:48
 */
public class H3 {
    public static void main(String[] args) {
        //初始化数据
        String[] names = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要查找的学生姓名：");

        //输入
        String input = sc.next();
        sc.close();

        //是否找到的标志
        boolean isFound = false;
        for (String name : names) {
            //遍历判断
            if (name.equals(input)) {
                //找到设置标志为true后跳出
                System.out.println("该学员在此班");
                isFound = true;
                break;
            }
        }
        //如果没找到就需要输出没有找到
        if (!isFound) {
            System.out.println("没有找到");
        }
    }
}
