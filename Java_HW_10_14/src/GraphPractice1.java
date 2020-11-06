/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:H1
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/14 15:56
 */
public class GraphPractice1 {
    public static void main(String[] args) {
        //字符串拼接
        StringBuilder stringBuilder = new StringBuilder();

        //打印#
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append("####..#\n");
        }

        stringBuilder.append("\n\n");

        //打印$$ 从负数开始，到相反数结束
        for (int i = -4; i <= 4; i++) {
            for (int j = 0; j < 4 - Math.abs(i); j++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append("$$....$\n");
        }

        stringBuilder.append("\n\n");

        //原理同上
        for (int i = -4; i <= 4; i++) {
            for (int j = Math.abs(i); j >= 0; j--) {
                stringBuilder.append(' ');
            }
            stringBuilder.append("*");
            boolean hasNextSpace = false;
            //中间空格数 简单的数学计算
            for (int j = 0; j < 7 - 2 * Math.abs(i); j++) {
                stringBuilder.append(' ');
                hasNextSpace = true;
            }
            if (hasNextSpace) {
                //非头尾
                stringBuilder.append("*\n");
            } else {
                //头尾
                stringBuilder.append("\n");
            }

        }

        System.out.println(stringBuilder);
        
    }
}
