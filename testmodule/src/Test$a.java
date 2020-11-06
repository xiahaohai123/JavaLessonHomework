/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Test$a
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 15:38
 */
public class Test$a {
    static int a = 10;
    static int b = 10;

    private int c;

    public static void main(String[] args) {
        System.out.println(a);
        Test$a test$a = new Test$a();
        test$a.c = 12;
        System.out.println(test$a.c);

    }

    public static void add() {

    }

    public void instanMethod() {

        add();
    }

    class User {
    }
}
