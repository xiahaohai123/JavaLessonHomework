package top.summersea.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PackageName: top.summersea.util
 * @ClassName: TimeUtil
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/4 11:58
 */
public class TimeUtil {
    public static Date dateStringToDate(String dateString) throws ParseException {
        if (dateString == null || "".equals(dateString)) return null;
        if (!dateString.contains(":")) {
            dateString = dateString + " 00:00:00";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(dateString);
    }

    public static String dateToYyyyMMdd(Date date) {
        if (date == null) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return simpleDateFormat.format(date);
    }

    public static String dateToDateString(Date date) {
        if (date == null) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
