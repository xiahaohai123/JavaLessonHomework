package HW.HW1;

/**
 * @PackageName:HW.HW1
 * @ClassName:BirdTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:11
 */
public class BirdTest {
    public static void main(String[] args) {
        Cock cock = new Cock("小鸡1号");
        Duck duck = new Duck("小鸭1号");

        // 吃
        cock.eat();
        // 打鸣
        cock.crow();
        // 分隔符
        System.out.println("*******************");
        // 吃
        duck.eat();
        // 游泳
        duck.swim();
    }
}
