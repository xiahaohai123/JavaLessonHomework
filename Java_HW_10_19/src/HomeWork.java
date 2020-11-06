import java.util.Arrays;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:HomeWork
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 13:54
 */
public class HomeWork {
    // 一维数组
    private int[] array;

    public HomeWork(int[] array) {
        this.array = array;
    }

    public static void method31(int x) {
        if (x < 60) {
            System.out.println(0);
        } else if (x < 70) {
            System.out.println(1);
        } else if (x < 80) {
            System.out.println(2);
        } else if (x < 90) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }

    /**
     * 找到对象成员array中的最大值并打印
     */
    public void showMax() {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }

        System.out.println("最大值是：" + max);
    }


    /**
     * 找到平均值
     *
     * @return
     */
    public double getAvg() {
        int sum = 0;
        // 累加和
        for (int i : array) {
            sum += i;
        }

        // 平均值
        return ((double) sum) / array.length;
    }

    /**
     * 升序存放并显示
     */
    public void ascendingOrder() {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 返回数组中最小的值
     *
     * @return
     */
    public int getMin() {
        int min = Integer.MAX_VALUE;

        // 遍历所有数据找到最小值
        for (int i : array) {
            min = Math.min(min, i);
        }
        return min;
    }
}
