package thread_test;

import java.util.ArrayList;

/**
 * @PackageName:thread_test
 * @ClassName:ThreadTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 15:44
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadSafeObject object = new ThreadSafeObject();
        ExtentThread extentThread = new ExtentThread(object, true);
        ExtentThread extentThread2 = new ExtentThread(object, false);

        extentThread.start();
        extentThread2.start();

        while (extentThread.isAlive() || extentThread2.isAlive()) ;

        System.out.println(object);
    }
}

class ExtentThread extends Thread {

    private ThreadSafeObject object;
    private boolean module;

    public ExtentThread(ThreadSafeObject object, boolean module) {
        this.object = object;
        this.module = module;
    }

    @Override
    public void run() {
        // 可以同步一个对象
        if (module) {
            for (int i = 0; i < 10; i++) {
                try {
                    object.add1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                object.add2();
            }
        }
    }
}

class ThreadSafeObject {
    private final ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public void add1() throws InterruptedException {
        synchronized (arrayList) {
            arrayList.add(1);
            System.out.println("add1");
            Thread.sleep(1000);
        }
        Thread.sleep(10);
    }

    public void add2() {
        // 这里没上同步锁，结果别的线程可以在add1方法已上锁的情况下继续添加
//        synchronized (arrayList) {
        arrayList.add(2);
        System.out.println("add2");
//        }
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }
}
