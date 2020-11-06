package hw1;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:NoodlesTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 13:57
 */
public class NoodlesTest {
    public static void main(String[] args) {
        NoodlesManagerSingleton noodlesManagerSingleton = NoodlesManagerSingleton.getInstance();

        noodlesManagerSingleton.order();
    }
}
