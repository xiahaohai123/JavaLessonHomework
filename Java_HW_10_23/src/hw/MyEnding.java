package hw;

/**
 * @PackageName:hw
 * @ClassName:MyEnding
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:35
 */
public class MyEnding implements Ending {
    private String ending;

    public MyEnding(String ending) {
        this.ending = ending;
    }

    @Override
    public String getEnding() {
        return ending;
    }
}
