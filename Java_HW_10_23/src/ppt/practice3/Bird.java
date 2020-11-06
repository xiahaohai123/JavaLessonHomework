package ppt.practice3;

/**
 * @PackageName:practice3
 * @ClassName:Bird
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:25
 */
public abstract class Bird {
    public void fly() {
        System.out.println("弹射起步——起飞！");
    }

    public void shout() {
        System.out.println("嗷——！");
    }

    public abstract void attack();
}
