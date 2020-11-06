/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Dolphin
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/24 16:50
 */
public class Dolphin extends Animal {
    public Dolphin(String name) {
        super(name);
    }

    @Override
    public void shout() {
        System.out.println("海豚叫");
    }
}
