import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:H6
 * @Description: 6、	数组存储5笔购物金额，在控制台输出并计算总金额
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/13 14:29
 */
public class H6 {
    public static void main(String[] args) {
        //数据存储
        double[] amountOfConsumption = new double[5];
        System.out.println("请输入会员本月的消费记录");
        Scanner sc = new Scanner(System.in);
        //输入
        for (int i = 0; i < 5; i++) {
            System.out.print("请输入第" + (i + 1) + "笔购物金额：");
            amountOfConsumption[i] = sc.nextDouble();
        }
        sc.close();

        //总额
        double sum = 0.0;
        //拼接结果
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("序号\t\t\t\t金额（元）\n");
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(i + 1).
                    append("\t\t\t\t\t").
                    append(amountOfConsumption[i]).
                    append('\n');
            sum += amountOfConsumption[i];
        }
        stringBuilder.append("总金额\t\t\t\t").append(sum);
        System.out.println(stringBuilder);

    }
}
