import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:H5
 * @Description: 一个数组{36, 89, 57, 76, 99, 28, 104},现在要删除数组中一个数值。运行如下所示：
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/13 14:07
 */
public class H5 {
    //初始数据
    private int[] nums = {36, 89, 57, 76, 99, 28, 104};

    public static void main(String[] args) {
        H5 h5 = new H5();
        //打印原始数组
        h5.printArray();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入删除的值：");
        int input = sc.nextInt();
        sc.close();
        //判断是否存在
        if (h5.isExist(input)) {
            //删除
            h5.deleteEle(input);
            h5.printArray();
        } else {
            System.out.println("该值不存在");
        }

    }

    private boolean isExist(int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    private void printArray() {
        //字符串拼接器
        StringBuilder stringBuilder = new StringBuilder();
        //head
        stringBuilder.append('[');
        for (int num : nums) {
            stringBuilder.append(num).append(", ");
        }
        System.out.println(stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "]"));
    }

    /**
     * 新建数组实现删除
     *
     * @param target
     */
    private void deleteEle(int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (target == nums[i]) {
                break;
            }
        }
        //新数组
        int[] dest = new int[nums.length - 1];
        //复制
        System.arraycopy(nums, 0, dest, 0, i);
        System.arraycopy(nums, i + 1, dest, i, nums.length - i - 1);
        nums = dest;

    }
}
