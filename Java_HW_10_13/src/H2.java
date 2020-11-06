import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:H2
 * @Description: 2、获取最低价手机价格:求出4家店的最低手机价格2、获取最低价手机价格:求出4家店的最低手机价格
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/13 13:41
 */
public class H2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入4家电的价格");
        //价格数组
        int[] prices = new int[4];
        //最大值
        int min = Integer.MAX_VALUE;
        //输入数据
        for (int i = 0; i < 4; i++) {
            System.out.print("第" + (i + 1) + "店的价格：");
            prices[i] = sc.nextInt();
            min = Math.min(prices[i], min);
        }
        sc.close();

        System.out.println("最低价格是：" + min);
    }
}
