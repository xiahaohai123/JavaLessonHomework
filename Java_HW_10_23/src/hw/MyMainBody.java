package hw;

/**
 * @PackageName:hw
 * @ClassName:MyMainBody
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:35
 */
public class MyMainBody implements MainBody {
    private String mainBody;

    public MyMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    @Override
    public String getMainBody() {
        return mainBody;
    }
}
