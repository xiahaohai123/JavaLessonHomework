package ppt.practice3;

/**
 * @PackageName:practice3
 * @ClassName:RedBird
 * @Description: 红色鸟
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:33
 */
public class RedBird extends Bird implements BirdShout {
    private static final String TYPE = "红色鸟";

    @Override
    public void attack() {
        System.out.println(TYPE + "普通攻击");
    }

    @Override
    public void shout() {
        System.out.println(TYPE + "喳喳");
    }
}
