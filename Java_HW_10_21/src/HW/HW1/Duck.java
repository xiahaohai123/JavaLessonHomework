package HW.HW1;

/**
 * @PackageName:HW.HW1
 * @ClassName:Duck
 * @Description: 鸭 继承自 禽类Bird
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:07
 */
public class Duck extends Bird {
    public Duck(String name) {
        super();
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("我喜欢吃小鱼虾！");
    }

    public void swim() {
        System.out.println("我会游泳！");
    }
}
