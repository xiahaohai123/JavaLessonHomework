package top.summersea.hw3.util;

/**
 * @PackageName: top.summersea.util
 * @ClassName: NameMapperUtil
 * @Description: description 命名转换工具
 * 支持下划线字符串转换成小驼峰
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/3 12:05
 */
public class NameMapperUtil {

    /**
     * 下划线字符串转小驼峰
     * 忽视所有头部下划线
     *
     * @param param
     * @return
     */
    public static String underlineToSmallCamel(String param) {
        if (param == null || "".equals(param)) {
            return param;
        }


        int len = param.length();
        // 忽视所有头部下划线
        int i = 0;
        for (; i < len; i++) {
            if (param.charAt(i) != '_') {
                break;
            }
        }

        // 开始转换
        boolean isUnderlineBefore = false;
        StringBuilder sb = new StringBuilder();
        for (; i < len; i++) {
            char c = param.charAt(i);
            if (c == '_') {
                isUnderlineBefore = true;
                continue;
            }
            // 如果之前是下划线
            if (isUnderlineBefore) {
                sb.append(Character.toUpperCase(c));
                isUnderlineBefore = false;
            } else {
                // 不是
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
