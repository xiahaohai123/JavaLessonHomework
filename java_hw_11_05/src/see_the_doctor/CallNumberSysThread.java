package see_the_doctor;

enum Type {
    特需号(15, 1000), 普通号(50, 500);
    // 最高号码
    private int max;
    // 看病时间(ms)
    private int time;

    Type(int max, int time) {
        this.max = max;
        this.time = time;
    }

    public int getMax() {
        return max;
    }

    public int getTime() {
        return time;
    }
}

/**
 * @PackageName:see_the_doctor
 * @ClassName:CallNumberSys
 * @Description: 叫号看病
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 14:23
 */
public class CallNumberSysThread extends Thread {
    private static MedicalDepartment medicalDepartment;
    private static boolean specialLeft;

    static {
        medicalDepartment = new MedicalDepartment();
        specialLeft = true;
    }

    // 病号类型
    private Type type;

    public CallNumberSysThread(Type type) {
        this.type = type;
    }

    @Override
    public void run() {
        for (int i = 1; i <= type.getMax(); i++) {
            // 如果普通号大于10则让特需号看病
            while (type == Type.普通号 && i > 10 && specialLeft) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                // 看病
                medicalDepartment.treat(type, i);
                /*
                treat方法使用了synchronized关键字进行了同步操作，
                这将导致：
                1、某个叫号线程（假设是特需号）进入此方法看病，
                2、方法调用了Thread.sleep方法导致特需号线程进入了阻塞状态，
                3、CPU将资源给另一个线程即普通号。
                4、普通号线程想要进入treat方法，但是由于synchronized关键字的存在导致进入不了方法，被阻塞。
                5、直到特需号线程释放了对象锁
                6、由于synchronized是非公平锁，所以此时还是两个线程抢锁。
                7、所以加上下面这行代码，给另一个线程留出抢锁时间
                8、可以尝试注释这个代码，来查看调用的过程区别
                 */
//                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 没有特需号了就放开标识符让普通号看病
        if (Type.特需号 == type) {
            specialLeft = false;
        }
    }
}
