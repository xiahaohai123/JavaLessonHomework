/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ExtendThread
 * @Description: 练习一
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 13:47
 */
public class ExtendThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new ExtendThread();
        Thread thread2 = new ExtendThread();

        thread1.start();
        thread2.start();
    }
}

class ExtendThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + ".你好，来自线程" + this.getName());
        }
    }
}
