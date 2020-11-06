/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:PriorityTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 14:07
 */
public class PriorityTest {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("**********显示默认优先级**********");
        System.out.println("主线程名：" + Thread.currentThread().getName() + ",优先级：" + Thread.currentThread().getPriority());
        System.out.println("主线程名：" + thread.getName() + ",优先级：" + thread.getPriority());
        /*
        修改优先级
         */
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);

        System.out.println("**********修改优先级后**********");
        System.out.println("主线程名：" + Thread.currentThread().getName() + ",优先级：" + Thread.currentThread().getPriority());
        System.out.println("主线程名：" + thread.getName() + ",优先级：" + thread.getPriority());

    }
}
