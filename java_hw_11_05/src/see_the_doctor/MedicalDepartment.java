package see_the_doctor;

/**
 * @PackageName:see_the_doctor
 * @ClassName:MedicalDepartment
 * @Description: 科室 加锁
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 14:19
 */
public class MedicalDepartment {
    /**
     * 看病
     * 线程锁，同时只能有一个人在看病
     *
     * @param type 号码类型
     * @param num  号码
     */
    public synchronized void treat(Type type, int num) throws InterruptedException {
        System.out.println(type + "：" + num + "号病人正在看病");
        // 看病消耗时间
        Thread.sleep(type.getTime());
    }
}
