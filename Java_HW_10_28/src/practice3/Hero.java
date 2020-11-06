package practice3;

/**
 * @PackageName:practice3
 * @ClassName:Hero
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 14:35
 */
public class Hero {
    // 编号
    private int name;

    public Hero(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    @Override
    public String toString() {
        return "hero " + name;
    }
}
