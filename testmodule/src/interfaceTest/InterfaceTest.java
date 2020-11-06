package interfaceTest;

/**
 * @PackageName:interfaceTest
 * @ClassName:InterfaceTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/5 19:42
 */
public class InterfaceTest {
    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        InterfaceImplement interfaceImplement = new InterfaceImplement();
        interfaceTest.test((Interface1) interfaceImplement);
        interfaceTest.test((Interface2) interfaceImplement);
    }

    public void test(Interface1 interface1) {

    }

    public void test(Interface3 interface3) {

    }
}
