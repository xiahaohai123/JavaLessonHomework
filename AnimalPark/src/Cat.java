/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Cat
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 17:02
 */
public class Cat extends Animal implements Terrestrial {

    // 腿的数量
    private int legNum;

    public Cat(String name, int legNum) {
        super(name);
        this.legNum = legNum;
    }

    @Override
    public void shout() {
        System.out.println("喵~ ＞▽＜");
    }

    @Override
    public int getLegNum() {
        return legNum;
    }

    @Override
    public void setLegNum(int legNum) throws OutOfObjectiveConditionException {
        if (legNum != 4) {
            throw new OutOfObjectiveConditionException();
        } else {
            this.legNum = legNum;
        }
    }

    public class OutOfObjectiveConditionException extends Exception {

        @Override
        public String getMessage() {
            return "猫只能有4条腿";
        }
    }
}
