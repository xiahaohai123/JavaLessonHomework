/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ClimbTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 13:56
 */
public class ClimbTest {
    public static void main(String[] args) {
        ClimbPersonThread youngCpr = new ClimbPersonThread("年轻人", 1);
        ClimbPersonThread oldCpr = new ClimbPersonThread("老年人", 2);

        oldCpr.start();
        youngCpr.start();

    }
}

class ClimbPersonThread extends Thread {

    // 名字
    private String name;
    // 几秒每一百米
    private int secondPerHundredMeter;

    public ClimbPersonThread(String name, int secondPerHundredMeter) {
        this.name = name;
        this.secondPerHundredMeter = secondPerHundredMeter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // 休眠 指代爬100米需要的时间
                Thread.sleep(secondPerHundredMeter * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + "爬完100米！");
        }
        System.out.println(name + "到达终点！");
    }
}
