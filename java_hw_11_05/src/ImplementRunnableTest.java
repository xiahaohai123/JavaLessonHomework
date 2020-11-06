/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ImplementRunnableTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 13:52
 */
public class ImplementRunnableTest {
    public static void main(String[] args) {
        ImplementRunnable implementRunnable = new ImplementRunnable();
        Thread t1 = new Thread(implementRunnable);
        Thread t2 = new Thread(implementRunnable);

        t1.start();
        t2.start();
    }
}

class ImplementRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + ".你好，来自线程" + Thread.currentThread().getName());
        }
    }
}
