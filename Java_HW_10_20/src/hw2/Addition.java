package hw2;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Addition
 * @Description: 工具类 没有配置信息 使用静态方法 重载
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 15:01
 */
public class Addition {

    public static String add(int x, int y) {
        return "int=>" + (x + y);
    }

    public static String add(long x, long y) {
        return "long=>" + (x + y);
    }

    public static String add(float x, float y) {
        return "float=>" + (x + y);
    }

    public static String add(double x, double y) {
        return "double=>" + (x + y);
    }

    public static String add(String x, String y) {
        return "String=>" + (Double.valueOf(x) + Double.valueOf(y));
    }
}
