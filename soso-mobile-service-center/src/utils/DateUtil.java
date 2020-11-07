package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PackageName: utils
 * @ClassName: DateUtil
 * @Description: 字符串和时间戳互转工具
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/6 21:53
 */
public class DateUtil {

    /**
     * 时间戳转字符串
     *
     * @param mills 时间戳
     * @return String 字符串
     */
    public static String millsToString(long mills) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(mills));
    }

    public static Date StringToDate(String timeString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(timeString);

    }

    /**
     * 字符串转时间戳
     *
     * @param timeString 时间字符串 yyyy-mm-dd
     * @return long mills 时间戳
     * @throws ParseException 如果输入有问题导致parse失败会抛出异常
     */
    public static long StringToMills(String timeString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(timeString).getTime();
    }

    public static String millsToYyyyMM(long mills) {
        return new SimpleDateFormat("yyyy-MM").format(mills);
    }

    public static long yyyyMMToMills(String timeString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM").parse(timeString).getTime();
    }
}
