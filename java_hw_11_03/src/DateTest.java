import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:DateTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 15:06
 */
public class DateTest {
    public static void main(String[] args) {
        /**
         * 字符串转换成Date
         */
        // 字符串时间
        String time = "2018-10-12 21:26:54";

        // 格式化器
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        // 字符串转换成Date
        try {
            Date date = sdf.parse(time);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * 日期转换成字符串
         */
        Date date = new Date();
        sdf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
        System.out.println(sdf.format(date));

    }
}
