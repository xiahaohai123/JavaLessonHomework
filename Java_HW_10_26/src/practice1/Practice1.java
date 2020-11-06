package practice1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @PackageName:practice1
 * @ClassName:Practice1
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/26 13:58
 */
public class Practice1 {
    public static void main(String[] args) {
        String[] classes = {"面向对象程序设计", "计算机操作系统", "计算机组成原理"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入课程代号（1~3之间的数字）：");
        try {
            int num = scanner.nextInt();
            if (num > 0 && num <= 3) {
                System.out.println(classes[num - 1]);
            } else {
                System.out.println("范围外的输出");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.toString());
            System.out.println("输入的连数字都不是");
        } finally {
            System.out.println("欢迎提出建议！");
        }
    }
}
