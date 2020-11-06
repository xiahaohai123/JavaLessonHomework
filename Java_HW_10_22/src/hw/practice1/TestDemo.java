package hw.practice1;

/**
 * @PackageName:hw
 * @ClassName:practice1
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 13:19
 */
public class TestDemo {
    public static void main(String[] args) {
        // 声明父类指向子类
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.play();
        dog.play();
    }
}
