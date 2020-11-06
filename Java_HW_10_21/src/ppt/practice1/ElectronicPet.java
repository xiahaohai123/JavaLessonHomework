package ppt.practice1;

/**
 * @PackageName:ppt
 * @ClassName:ElectronicPet
 * @Description:　PPT作业1 电子宠物
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 13:57
 */
public class ElectronicPet {
    private int health;
    private int intimacy;
    private String name;
    // 宠物性别
    private Sex sex;
    // 宠物类型 枚举类型
    private Type type;

    public ElectronicPet() {
        health = 60;
        intimacy = 0;
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

    public int getIntimacy() {
        return intimacy;
    }

    public String getName() {
        return name;
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

    public String getType() {
        return type.getType();
    }

    /**
     * 要求输入的值必须是枚举类中number的值
     * 如果是则成功设置type并返回true
     * 如果不是则返回false
     *
     * @param number
     * @return
     */
    public boolean setType(int number) {
        if (number == Type.DOG.number) {
            this.type = Type.DOG;
            return true;
        } else if (number == Type.PENGUIN.number) {
            this.type = Type.PENGUIN;
            return true;
        }
        return false;
    }

    /**
     * 支持输入String类型的重载
     *
     * @param number
     * @return
     */
    public boolean setType(String number) {
        try {
            // 尝试转换类型
            int num = Integer.valueOf(number);
            // 成功则使用重载的方法
            return setType(num);
        } catch (NumberFormatException e) {
            // 失败直接返回false
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("我的名字叫").append(getName())
                .append(",健康值是").append(getHealth())
                .append("，和主人的亲密度是").append(getIntimacy())
                .append("，我的性别是").append(getSex());
        return stringBuilder.toString();
    }

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

    private enum Type {
        DOG(1, "狗狗"),
        PENGUIN(2, "企鹅");

        // 编号，对应输入值
        private final int number;
        // 类型的字符串解释
        private final String type;

        Type(int number, String type) {
            this.number = number;
            this.type = type;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return type;
        }
    }
}
