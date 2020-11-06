import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice4
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 14:47
 */
public class Practice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个字符串：");
        String original = scanner.next();

        // 目标字符
        System.out.print("请输入要查找的字符：");
        String targetString = scanner.next();
        // 目标是字符，所以长度不能不等于1
        while (targetString.length() != 1) {
            System.out.println("查找的字符长度为1");
            targetString = scanner.next();
        }
        // 获取到目标字符
        char target = targetString.charAt(0);
        // 原始字符串长度
        int length = original.length();
        // 出现次数l
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == target) {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('"').append(original).append("\"中包含").append(count).append("个\"")
                .append(target).append('"');
        System.out.println(sb);
    }
}
