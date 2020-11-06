/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice6
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 15:10
 */
public class Practice6 {
    public static void main(String[] args) {
        String s = "let there be light";
        // 分成字符数组
        char[] cs = s.toCharArray();
        // 首字母大写
        cs[0] -= 'a' - 'A';
        for (int i = 2; i < cs.length; i++) {
            // 如果前面的字符是空格则该字符大写
            if (cs[i - 1] == ' ') {
                cs[i] -= 32;
            }
        }
        // 获取目标字符串
        String target = String.valueOf(cs);
        System.out.println(target);
    }
}
