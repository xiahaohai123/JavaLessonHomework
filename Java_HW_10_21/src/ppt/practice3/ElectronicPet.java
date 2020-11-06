package ppt.practice3;

/**
 * @PackageName:ppt.practice3
 * @ClassName:ElectronicPet
 * @Description: 继承实现
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:58
 */
public abstract class ElectronicPet {
    private String name;
    private Sex sex;
    private int health;
    private int intimacy;

    public ElectronicPet() {
        health = 60;
        intimacy = 60;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex.getSexInString();
    }

    public boolean setSex(int number) {
        if (number == Sex.MALE.number) {
            this.sex = Sex.MALE;
            return true;
        } else if (number == Sex.FEMALE.number) {
            this.sex = Sex.FEMALE;
            return true;
        }
        return false;
    }

    public boolean setSex(String number) {
        try {
            // 尝试转换类型
            int num = Integer.valueOf(number);
            // 成功则使用重载的方法
            return setSex(num);
        } catch (NumberFormatException e) {
            // 失败直接返回false
            return false;
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean setHealth(int health) {
        if (health > 0 && health <= 100) {
            this.health = health;
            return true;
        }
        return false;
    }

    public boolean setHealth(String number) {
        try {
            // 尝试转换类型
            int num = Integer.valueOf(number);
            // 成功则使用重载的方法
            return setHealth(num);
        } catch (NumberFormatException e) {
            // 失败直接返回false
            return false;
        }
    }

    public void setIntimacy(int intimacy) {
        this.intimacy = intimacy;
    }

    /**
     * 自白
     */
    public abstract String confession();

    public abstract String getType();

    private enum Sex {
        // 男
        MALE(1, "Q仔"),
        // 女
        FEMALE(2, "Q妹");

        private final int number;
        private final String sexInString;

        Sex(int number, String sexInString) {
            this.number = number;
            this.sexInString = sexInString;
        }

        public String getSexInString() {
            return sexInString;
        }
    }

    public String getName() {
        return name;
    }

    public int getIntimacy() {
        return intimacy;
    }
}
