import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:OneArray4SetImpl
 * @Description: 将一个数组中的重复元素保留一个其他的清零
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/15 14:11
 */
public class OneArray4SetImpl {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 4, 5, 6, 4, 7, 2, 10};
        //输出原数组
        System.out.println("原数组：" + Arrays.toString(nums));
        //set特性，内容不可重复，可以通过contains方法判断是否已存在相同的内容
        //这里使用HashSet 利用hash映射
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果元素已存在
            if (set.contains(nums[i])) {
                //清空当前元素
                nums[i] = 0;
            } else {
                //不存在则将当前元素加入set
                set.add(nums[i]);
            }
        }

        //输出当前数组
        System.out.println("改数组：" + Arrays.toString(nums));
    }
}
