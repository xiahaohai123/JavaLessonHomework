package hw.practice2;

/**
 * @PackageName:hw.practice2
 * @ClassName:FlowerTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 13:59
 */
public class FlowerTest {
    public static void main(String[] args) {
        Flower flower = new Flower("白色", 10);
        flower.showInfo();
        Flower rose = new Rose("紫色", 30, "大理");
        rose.showInfo();

        // 判断是不是Rose防止报类型转换错误
        if (rose instanceof Rose) {
            ((Rose) rose).warn();
        }
    }
}
