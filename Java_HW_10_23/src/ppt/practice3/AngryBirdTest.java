package ppt.practice3;

/**
 * @PackageName:practice3
 * @ClassName:AngryBirdTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:37
 */
public class AngryBirdTest {
    public static void main(String[] args) {
        Bird splitBird = new SplitBird();
        splitBird.fly();
        splitBird.shout();
        splitBird.attack();
        System.out.println();

        Bird rocketBird = new RocketBird();
        rocketBird.fly();
        rocketBird.shout();
        rocketBird.attack();
        System.out.println();

        Bird redBird = new RedBird();
        redBird.fly();
        redBird.shout();
        redBird.attack();
        System.out.println();

        Bird bombBird = new BombBird();
        bombBird.fly();
        bombBird.shout();
        bombBird.attack();
        System.out.println();

        Bird fatBird = new FatBird();
        fatBird.fly();
        fatBird.shout();
        fatBird.attack();
    }
}
