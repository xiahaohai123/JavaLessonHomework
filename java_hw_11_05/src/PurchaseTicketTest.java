/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:PurchaseTicket
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 15:30
 */
public class PurchaseTicketTest {
    public static void main(String[] args) {
        PurchaserRunnable purchaserRunnable = new PurchaserRunnable();
        Thread t1 = new Thread(purchaserRunnable, "携程");
        Thread t2 = new Thread(purchaserRunnable, "黄牛");
        Thread t3 = new Thread(purchaserRunnable, "脚本怪");

        t1.start();
        t2.start();
        t3.start();
    }
}

class PurchaserRunnable implements Runnable {
    // 第几张票
    private int counter;
    // 余票
    private int left;

    public PurchaserRunnable() {
        counter = 0;
        left = 10;
    }

    @Override
    public void run() {
        while (left > 0) {
            synchronized (this) {
                // 有点类似双检锁
                if (left <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() +
                        "抢到了第" + (++counter) + "张票，剩余" +
                        --left + "张票");
            }

            // 给别的线程一点机会
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
