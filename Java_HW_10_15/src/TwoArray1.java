import java.util.Arrays;
import java.util.Random;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:TwoArray1
 * @Description: 一、	首先定义一个5X8的二维数组，然后使用随机数填充满。
 * 借助Arrays的方法对二维数组进行排序。
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/15 14:18
 */
public class TwoArray1 {
    public static void main(String[] args) {
        //声明数组
        int[][] matrix = new int[5][8];
        //填充数组
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(101);
            }
        }

        //拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("未排序前的二维数组：\n");
        for (int[] ints : matrix) {
            stringBuilder.append(Arrays.toString(ints)).append('\n');
        }

        //将排序和输出整合在一个循环内
        //减少一次循环的时间
        stringBuilder.append("排序后的二维数组\n");
        for (int[] ints : matrix) {
            Arrays.sort(ints);
            stringBuilder.append(Arrays.toString(ints)).append('\n');
        }


        //输出
        System.out.println(stringBuilder);
    }
}
