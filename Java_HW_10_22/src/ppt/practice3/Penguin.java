package ppt.practice3;

/**
 * @PackageName:ppt.practice3
 * @ClassName:Penguin
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 14:34
 */
public class Penguin extends Pet {
    public Penguin(int health) {
        super(health);
    }

    @Override
    public boolean feed() {
        int health = super.getHealth();
        if (health == 100) {
            System.out.println("企鹅健康值已满，不能继续喂食");
            return false;
        } else if (health < 95) {
            super.setHealth(health + 5);
            System.out.println("企鹅吃鱼吃完啦，健康值+5，当前健康值：" + super.getHealth());
        } else {
            super.setHealth(100);
            System.out.println("企鹅吃鱼吃饱啦，健康值加满");
        }
        return true;
    }
}
