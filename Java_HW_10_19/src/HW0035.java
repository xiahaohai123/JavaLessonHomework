/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:HW0035
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 14:15
 */
public class HW0035 {
    public static void main(String[] args) {
        int[] array = new int[5];
        // 填充数组
        for (int i = 0; i < 5; i++) {
            /*
            [0,1)*21->[0,21)
            [0,21)+10->[10,31)
             */
            array[i] = (int) (Math.random() * 21 + 10);
        }
        HomeWork homeWork = new HomeWork(array);
        System.out.println(homeWork.getMin());
    }
}
