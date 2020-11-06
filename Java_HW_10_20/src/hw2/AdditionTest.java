package hw2;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:AdditionTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 15:15
 */
public class AdditionTest {

    public static void main(String[] args) {
        System.out.println(Addition.add(16, 14));
        System.out.println(Addition.add(13300L, 45L));
        System.out.println(Addition.add(34F, 0.1F));
        System.out.println(Addition.add(147, 0.254));
        System.out.println(Addition.add("888000", "123"));
    }
}
