package see_the_doctor;

/**
 * @PackageName:see_the_doctor
 * @ClassName:SeeTheDoctorTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 14:39
 */
public class SeeTheDoctorTest {
    public static void main(String[] args) {
        CallNumberSysThread callNumberSysThread = new CallNumberSysThread(Type.普通号);
        CallNumberSysThread callNumberSysThread2 = new CallNumberSysThread(Type.特需号);

        // 设置优先局修改概率
        callNumberSysThread.setPriority(Thread.MIN_PRIORITY);
        callNumberSysThread2.setPriority(Thread.MAX_PRIORITY);

        callNumberSysThread.start();
        callNumberSysThread2.start();
    }
}
