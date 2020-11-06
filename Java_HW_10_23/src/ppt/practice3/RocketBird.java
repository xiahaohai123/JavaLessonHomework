package ppt.practice3;

/**
 * @PackageName:practice3
 * @ClassName:RocketBird
 * @Description: 火箭鸟
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:32
 */
public class RocketBird extends Bird {
    private static final String TYPE = "火箭鸟";

    @Override
    public void attack() {
        System.out.println(TYPE + "加速冲撞");
    }
}
