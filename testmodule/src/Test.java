//import com.util.TestUtil;

import java.util.Objects;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Test
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/14 17:26
 */
public class Test {
    private static final int flag = 1;
    int a;

    public Test(int a) {
        this.a = a;
    }

    public Test() {
    }

    private static void smethod1() {
    }

    protected static void smethod2() {
    }

    public static void smethod3() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        for (test.test('a'); test.test('c'); ) {

        }
//       flag++;
    }

    public void Test() {

    }

    public boolean test(char c) {
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return a == test.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}

class TestChild extends Test {
    

    private static void smethod4() {
    }


    private void instanceMethod() {
        smethod4();
        smethod2();
        smethod3();

    }
}
