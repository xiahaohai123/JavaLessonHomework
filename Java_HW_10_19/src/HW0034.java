import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:HW0034
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 14:13
 */
public class HW0034 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("请输入第" + (i + 1) + "个数：");
            array[i] = scanner.nextInt();
        }

        HomeWork homeWork = new HomeWork(array);
        // 升序并输出
        homeWork.ascendingOrder();
        scanner.close();
    }
}
