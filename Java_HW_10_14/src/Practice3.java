import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice3
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/14 16:32
 */
public class Practice3 {
    static String[] weekDay = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        //do while 避免代码冗余
        do {
            System.out.print("请输入一个1-7之间的数字，输入0退出程序：");
            input = sc.nextInt();
            if (input < 0 || input > 7) {
                System.out.println("您输入的数字无效，只能输入范围1-7的数字！");
            } else if (input != 0) {
                System.out.println(weekDay[input - 1]);
            }
        } while (input != 0);
        //当输入的值为0的时候退出

        sc.close();
        System.out.println("程序结束");
    }
}
