import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:OneArray3ArrayImpl
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/15 13:56
 */
public class OneArray3ArrayImpl {
    private static final int DEFAULT_CAPACITY = 16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入多个正整数（输入-1表示结束）：");

        //实际有效长度
        int myLength = 0;
        //扩容倍率
        int magnification = 2;
        //维护数组
        int[] array = new int[DEFAULT_CAPACITY];

        do {
            int input = scanner.nextInt();
            //非-1
            if (input != -1) {
                /*如果当前有效长度已经等于数组长度了
                需要对数组进行扩容
                 */
                if (myLength == array.length) {
                    //指数增长，减少扩容操作
                    //创建一个新的拥有更高容量的数组，并将内容复制
                    array = Arrays.copyOf(array, array.length * magnification);
                }
                //增加内容
                array[myLength] = input;
                //有效数组长度增加
                myLength++;

            } else {
                break;
            }
        } while (true);
        //关闭输入流
        scanner.close();

        //输出拼接
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("你输入的数组为：").append('[');
        for (int i = 0; i < myLength; i++) {
            stringBuilder.append(array[i]).append(", ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "]").append('\n');

        stringBuilder.append("数组逆序输出为：\n").append('[');
        for (int i = myLength - 1; i >= 0; i--) {
            stringBuilder.append(array[i]).append(", ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "]");
        System.out.println(stringBuilder);

    }
}
