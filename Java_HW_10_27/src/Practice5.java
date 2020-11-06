/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice5
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 15:03
 */
public class Practice5 {
    public static void main(String[] args) {
        String s = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";

        // 获取最后一个two的index
        int lastIndex = s.lastIndexOf("two");

        // 将目标字符拆出来后大写拼接
        System.out.println(s.substring(0, lastIndex) + s.substring(lastIndex, lastIndex + 1).toUpperCase() + s.substring(lastIndex + 1));

    }
}
