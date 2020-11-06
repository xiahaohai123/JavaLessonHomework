/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:MultiplicationTable
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/14 16:44
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            //控制形状为倒三角
            for (int j = i; j <= 9; j++) {
                //拼接
                stringBuilder.append(i).append('*').append(j).append('=').append(i * j).append('\t');
            }
            stringBuilder.append('\n');
        }

        System.out.println(stringBuilder);
    }
}
