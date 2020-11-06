package practice2;

import java.util.Scanner;

/**
 * @PackageName:practice2
 * @ClassName:GuessNumber
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 13:54
 */
public class GuessNumber {
    public static void main(String[] args) {
        // 产生1-100之间的随机数
        int targetNum = (int) (Math.random() * 100 + 1);
        // 记录猜的次数
        int count = 0;

        System.out.print("猜数字游戏，请猜一个数字(1-100)：");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        count++;

        // 猜不中的循环
        while (input != targetNum) {
            if (input > targetNum) {
                System.out.print("大了，\n请继续猜：");
            } else {
                System.out.print("小了，\n请继续猜：");
            }

            input = scanner.nextInt();
            count++;
        }
        scanner.close();

        // 猜中后跳出来
        System.out.println("恭喜你猜中了,一共猜了" + count + "次");
    }
}
