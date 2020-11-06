/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:StringTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/29 14:12
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "asdsadasdasd";
        System.out.println("startsWith");
        System.out.println(HWTools.startsWith(s, "sd", 1));
        System.out.println("endsWith");
        System.out.println(HWTools.endsWith(s, "sd"));
        System.out.println(HWTools.endsWith(s, "sda"));
        System.out.println("replace");
        System.out.println(HWTools.replace(s, 'a', 'c'));
        System.out.println("getBytes");
        for (byte aByte : HWTools.getBytes(s)) {
            System.out.println(aByte);
        }
    }
}
