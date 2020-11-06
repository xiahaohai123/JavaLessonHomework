package hw;

/**
 * @PackageName:hw
 * @ClassName:MyWriteDay
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:36
 */
public class MyWriteDay implements WriteDay {
    private String writeDay;

    public MyWriteDay(String writeDay) {
        this.writeDay = writeDay;
    }

    @Override
    public String getWriteDay() {
        return writeDay;
    }
}
