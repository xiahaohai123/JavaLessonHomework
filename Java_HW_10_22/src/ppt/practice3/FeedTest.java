package ppt.practice3;

/**
 * @PackageName:ppt.practice3
 * @ClassName:FeedTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 14:35
 */
public class FeedTest {
    public static void main(String[] args) {
        Pet dog = new Dog(75);
        Pet penguin = new Penguin(69);

        // 喂饱！
        while (dog.feed()) ;
        while (penguin.feed()) ;
    }
}
