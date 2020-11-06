import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:H1
 * @Description: 1、从控制台输入8个整数，使用整型数组接收，分别统计并显示其中奇数和偶数的个数。运行结果如下图所示。
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/13 13:35
 */
public class H1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //数组声明
        int[] nums = new int[8];

        //偶数数量
        int evenNum = 0;

        //输入数据
        for (int i = 0; i < 8; i++) {
            System.out.print("请输入第" + (i + 1) + "个整数：");
            nums[i] = sc.nextInt();
            //如果是偶数则偶数数量自增
            if (nums[i] % 2 == 0) {
                evenNum++;
            }
        }
        sc.close();
        System.out.println("奇数的个数是：" + (8 - evenNum));
        System.out.println("偶数的个数是：" + evenNum);
    }
}
