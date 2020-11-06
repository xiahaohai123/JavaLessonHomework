/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:GraphPractice2
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/14 16:18
 */
public class GraphPractice2 {
    public static void main(String[] args) {
        //字符串拼接
        StringBuilder stringBuilder = new StringBuilder();

        //回旋镖
        for (int i = -4; i <= 4; i++) {
            //计算单行空格数
            int spaceCount = 4 - Math.abs(i);
            //拼接空格
            for (int j = 0; j < spaceCount; j++) {
                stringBuilder.append(' ');
            }
            //计算单行*符号数
            int symbolCount = (4 - Math.abs(i)) * 2 + 1;
            //拼上*
            for (int j = 0; j < symbolCount; j++) {
                stringBuilder.append('*');
            }
            //补上换行
            stringBuilder.append('\n');

        }

        stringBuilder.append("\n\n");


        //菱形数字阵 原理同上
        for (int i = -4; i <= 4; i++) {
            //计算前面空格数
            int spaceCount = Math.abs(i);
            for (int j = 0; j < spaceCount; j++) {
                stringBuilder.append(' ');
            }
            int contentCount = (4 - Math.abs(i)) * 2 + 1;

            for (int j = 0; j < contentCount; j++) {
                //spaceCount刚好是需要输入的内容
                stringBuilder.append(spaceCount);
            }
            //补上换行
            stringBuilder.append('\n');
        }

        stringBuilder.append("\n\n");


        //沙漏
        for (int i = -4; i <= 4; i++) {
            int spaceCount = 4 - Math.abs(i);
            for (int j = 0; j < spaceCount; j++) {
                stringBuilder.append(' ');
            }

            //计算单行*符号数
            int symbolCount = Math.abs(i) * 2 + 1;

            //拼上*
            for (int j = 0; j < symbolCount; j++) {
                stringBuilder.append('*');
            }
            //补上换行
            stringBuilder.append('\n');
        }
        stringBuilder.append("\n\n");


        System.out.println(stringBuilder);
    }
}
