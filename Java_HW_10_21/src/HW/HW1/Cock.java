package HW.HW1;

/**
 * @PackageName:HW.HW1
 * @ClassName:Cock
 * @Description: 鸡 继承自 禽类Bird
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:01
 */
public class Cock extends Bird {
    public Cock(String name) {
        super();
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("我喜欢吃虫子！");
    }

    public void crow() {
        System.out.println("我会打鸣！");
    }

}
