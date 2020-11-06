package ppt.practice3;

/**
 * @PackageName:ppt.practice3
 * @ClassName:Pet
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 14:20
 */
public abstract class Pet {
    private int health;

    public Pet() {
        this.health = 60;
    }

    public Pet(int health) {
        // 先赋上默认值
        super();
        // 失败则还是默认值，不然就是成功赋值
        setHealth(health);
    }

    public abstract boolean feed();

    public int getHealth() {
        return health;
    }

    public boolean setHealth(int health) {
        if (health > 0 && health <= 100) {
            this.health = health;
            return true;
        }

        // 不符合要求的输入
        return false;
    }
}
