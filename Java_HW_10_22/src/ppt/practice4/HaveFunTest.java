package ppt.practice4;

/**
 * @PackageName:ppt.practice4
 * @ClassName:HaveFunTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 14:52
 */
public class HaveFunTest {
    public static void main(String[] args) {
        // 声明父类指向子类
        Pet dog = new Dog();
        Pet penguin = new Penguin();

        if (dog instanceof Dog) {
            // 向下转型
            ((Dog) dog).receiveFrisbee();
        }

        if (penguin instanceof Penguin) {
            ((Penguin) penguin).swimInSouthPole();
        }
    }
}
