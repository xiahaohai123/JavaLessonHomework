package hw;

/**
 * @PackageName:hw
 * @ClassName:MyAppellation
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:34
 */
public class MyAppellation implements Appellation {
    private String appellation;

    public MyAppellation(String appellation) {
        this.appellation = appellation;
    }

    @Override
    public String getAppellation() {
        return appellation;
    }
}
