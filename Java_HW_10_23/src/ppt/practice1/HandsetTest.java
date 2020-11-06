package ppt.practice1;

/**
 * @PackageName:practice1
 * @ClassName:HandsetTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 14:23
 */
public class HandsetTest {
    public static void main(String[] args) {
        AptitudeHandset aptitudeHandset = new AptitudeHandset("9100", "HTC");
        CommanHandset commonHandset = new CommanHandset("索尼爱立信", "G520c");

        commonHandset.info();
        commonHandset.play("热雪");
        commonHandset.sendInfo();
        commonHandset.call();
        System.out.println();

        aptitudeHandset.info();
        aptitudeHandset.networkConn();
        aptitudeHandset.play("小时代");
        aptitudeHandset.takePicture();
        aptitudeHandset.sendInfo();
        aptitudeHandset.call();
    }
}
