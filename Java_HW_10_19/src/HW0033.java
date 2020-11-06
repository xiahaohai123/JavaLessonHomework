import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:HW0033
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 14:05
 */
public class HW0033 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);
        // 键盘输入填充数组
        for (int i = 0; i < 10; i++) {
            System.out.print("请输入第" + (i + 1) + "个数：");
            array[i] = scanner.nextInt();
        }

        // 构造器
        HomeWork homeWork = new HomeWork(array);
        // 求平均
        System.out.println(homeWork.getAvg());
        scanner.close();
    }
}
