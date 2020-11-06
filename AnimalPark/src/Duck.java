/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Duc
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 17:04
 */
public class Duck extends Animal implements Terrestrial {


    // 腿的数量
    private int legNum;

    public Duck(String name, int legNum) {
        super(name);
        this.legNum = legNum;
    }

    @Override
    public void shout() {
        System.out.println("嘎~");
    }

    @Override
    public int getLegNum() {
        return legNum;
    }

    @Override
    public void setLegNum(int legNum) throws OutOfObjectiveConditionException {
        if (legNum != 2) {
            throw new OutOfObjectiveConditionException();
        } else {
            this.legNum = legNum;
        }
    }

    public class OutOfObjectiveConditionException extends Exception {

        @Override
        public String getMessage() {
            return "鸭子只能有2条腿";
        }
    }
}
