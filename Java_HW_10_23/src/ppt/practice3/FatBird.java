package ppt.practice3;

/**
 * @PackageName:practice3
 * @ClassName:FatBird
 * @Description: 胖子鸟
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:35
 */
public class FatBird extends Bird implements BirdShout {
    private static final String TYPE = "胖子鸟";

    @Override
    public void attack() {
        System.out.println(TYPE + "扔蛋攻击");
    }

    @Override
    public void shout() {
        System.out.println(TYPE + "不叫");
    }
}
