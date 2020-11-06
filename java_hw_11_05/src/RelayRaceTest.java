/**
 * @PackageName:relay_race
 * @ClassName:RelayRaceTest
 * @Description: 接力赛
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 15:16
 */
public class RelayRaceTest {
    public static void main(String[] args) {
        RelayRace relayRace = new RelayRace();
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(relayRace, i + "号选手");
            thread.start();
        }
    }
}

class RelayRace implements Runnable {

    @Override
    public void run() {
        // 对象同步锁
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "拿到了接力棒");
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "跑了" + i * 10 + "米");
            }
        }
    }
}
