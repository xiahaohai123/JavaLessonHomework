import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Main
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 13:57
 */
public class HW0031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入x：");
        int x = scanner.nextInt();
        HomeWork.method31(x);


        scanner.close();
    }
}
