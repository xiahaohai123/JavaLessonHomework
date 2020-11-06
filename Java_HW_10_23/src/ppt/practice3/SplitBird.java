package ppt.practice3;

/**
 * @PackageName:practice3
 * @ClassName:SplitBird
 * @Description: 分裂鸟
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:28
 */
public class SplitBird extends Bird {
    private static final String TYPE = "分裂鸟";

    @Override
    public void attack() {
        System.out.println(TYPE + "分裂攻击");
    }
}
