import java.util.Random;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:H4
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/13 13:57
 */
public class H4 {
    public static void main(String[] args) {
        //声明数组
        int[] nums = new int[5];
        int max = Integer.MIN_VALUE;
        //随机数类
        Random random = new Random();
        //赋值
        for (int i = 0; i < 5; i++) {
            //生成0~100的随机整数
            nums[i] = random.nextInt(101);

        }

        for (int num : nums) {
            //输出随机的数据
            System.out.print(num + "\t");
            //判断最大
            max = Math.max(max, num);
        }
        System.out.println("\n最大值 = " + max);

    }
}
