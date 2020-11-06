package practice1;

/**
 * @PackageName:practice1
 * @ClassName:Level
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 12:22
 */
public enum Level {
    L1("大数据开发工程师"), L2("大数据挖掘工程师"), L3("大数据架构师");

    private String target;

    Level(String target) {
        this.target = target;
    }


    @Override
    public String toString() {
        return super.toString() + ":" + target;
    }
}
