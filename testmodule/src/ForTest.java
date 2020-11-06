import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ForTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/2 16:54
 */
public class ForTest {
    int[] arr;
    List<Integer> list;

    public ForTest() {
        this.arr = new int[1000000];
        list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arr[i] = i;
            list.add(i);
        }
    }

    public static void main(String[] args) {
        ForTest forTest = new ForTest();
        forTest.arrTest1();
        forTest.arrTest2();
        forTest.listTest1();
        forTest.listTest2();
    }

    public void arrTest1() {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {

        }
        long time2 = System.currentTimeMillis();

        System.out.println("arrTest1：" + (time2 - time1) + "毫秒");
    }

    public void arrTest2() {
        long time1 = System.currentTimeMillis();
        int length = arr.length;
        for (int i = 0; i < length; i++) {

        }
        long time2 = System.currentTimeMillis();

        System.out.println("arrTest2：" + (time2 - time1) + "毫秒");
    }

    public void listTest1() {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {

        }
        long time2 = System.currentTimeMillis();

        System.out.println("listTest1：" + (time2 - time1) + "毫秒");
    }

    public void listTest2() {
        long time1 = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {

        }
        long time2 = System.currentTimeMillis();

        System.out.println("listTest2：" + (time2 - time1) + "毫秒");
    }
}
