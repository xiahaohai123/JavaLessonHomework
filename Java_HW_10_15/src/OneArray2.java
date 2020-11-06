/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:OneArray2
 * @Description: 在一个有8个整数（18,25,7,36,13,2,89,63）的数组中找出其中最大的数及其下标。
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/15 13:42
 */
public class OneArray2 {
    public static void main(String[] args) {
        int[] nums = {18, 25, 7, 36, 13, 2, 89, 63};
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        System.out.println("最大值为：" + max + "\t最大值下标为：" + index);
    }
}
