import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:OneArray3
 * @Description: 从键盘输入正整数存入一个数组中，当输入-1时，就结束输入。并显示当前数组的数据，而且再显示数组的元素逆序存放。
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/15 13:45
 */
public class OneArray3ListImpl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入多个正整数（输入-1表示结束）：");
        //列表转数组法
        List<Integer> list = new ArrayList<>();
        do {
            int input = scanner.nextInt();
            //不为1则加入列表
            if (input != -1) {
                list.add(input);
            } else {
                break;
            }
        } while (true);
        //关闭输入流
        scanner.close();

        //输出拼接
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("你输入的数组为：");
        for (Integer integer : list) {
            stringBuilder.append(integer).append('\t');
        }
        stringBuilder.append('\n');
        stringBuilder.append("数组逆序输出为：\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i)).append('\t');
        }
        System.out.println(stringBuilder);

    }
}
