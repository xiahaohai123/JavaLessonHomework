import java.util.Arrays;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:HOneArray1
 * @Description: 一、	首先准备两个数组，他两个的长度是5-10之间的随机数，并使用随机数0-100初始化这两个数组,然后准备第三个数组，第三个数组的长度是前两个的和；可以通过System.arraycopy 把前两个数组合并到第三个数组中
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/15 13:28
 */
public class OneArray1 {
    public static void main(String[] args) {
        //声明数组
        //[0, 1) * 6 = [0, 6)
        //[0, 6) + 5 = [5, 11)
        int[] arr1 = new int[(int) (Math.random() * 6 + 5)];
        int[] arr2 = new int[(int) (Math.random() * 6 + 5)];

        //填充数组
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 101);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 101);
        }

        //新建数组
        int[] arr3 = new int[arr1.length + arr2.length];
        //copy数组
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);

        //输出
        System.out.println("数组arr1为：" + Arrays.toString(arr1));
        System.out.println("数组arr2为：" + Arrays.toString(arr2));
        System.out.println("数组arr3为：" + Arrays.toString(arr3));

    }
}
