package ppt.practice3;

/**
 * @PackageName:practice3
 * @ClassName:BombBird
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:34
 */
public class BombBird extends Bird implements BirdShout {
    private static final String TYPE = "炸弹鸟";

    @Override
    public void attack() {
        System.out.println(TYPE + "爆炸攻击");
    }

    @Override
    public void shout() {
        System.out.println(TYPE + "喳喳");
    }
}
