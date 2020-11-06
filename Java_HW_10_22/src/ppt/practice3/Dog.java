package ppt.practice3;

/**
 * @PackageName:ppt.practice3
 * @ClassName:Dog
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 14:30
 */
public class Dog extends Pet {
    public Dog(int health) {
        super(health);
    }

    @Override
    public boolean feed() {
        int health = super.getHealth();
        if (health == 100) {
            System.out.println("狗狗健康值已满，不能继续喂食");
            return false;
        } else if (health < 97) {
            super.setHealth(health + 3);
            System.out.println("狗狗吃肉吃完啦，健康值+3，当前健康值：" + super.getHealth());
        } else {
            super.setHealth(100);
            System.out.println("狗狗吃肉吃饱啦，健康值加满");
        }

        return true;
    }
}
