package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:utils
 * @ClassName:CardUtil
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 15:23
 */
public class CardUtil {

    /**
     * 产生一个随机的号码列表
     *
     * @param startNum 号码开头
     * @param capacity 要求号码数量
     * @return
     */
    public static String[] getCardNumList(String startNum, int capacity) {
        int length = startNum.length();
        if (length >= 11) {
            return null;
        }
        String[] numArray;
        // 理论上可以产生的号码数量
        int illegalCount = (int) (Math.pow(10, 11 - length));
        // 如果要求的号码数量大于理论上可以产生的号码数量
        if (illegalCount <= capacity) {
            numArray = new String[illegalCount];
            for (int i = 0; i < illegalCount; i++) {
                numArray[i] = getElevenNumber(startNum, i);
            }
        } else {
            Set<String> set = new HashSet<>();
            while (set.size() < capacity) {
                set.add(getRandomElevenNumber(startNum));
            }
            // 试试流操作转
            numArray = set.stream().toArray(String[]::new);
        }

        return numArray;
    }

    /**
     * 获取11位的String 号码
     *
     * @param startNum 开头
     * @param num
     * @return
     */
    private static String getElevenNumber(String startNum, int num) {
        return startNum + String.format("%0" + (11 - startNum.length()) + "d", num);
    }

    /**
     * 获取随机的11位String号码
     *
     * @param startNum
     * @return
     */
    private static String getRandomElevenNumber(String startNum) {
        int leftLength = 11 - startNum.length();
        return startNum + String.format("%0" + leftLength + "d", (int) (Math.random() * Math.pow(10, leftLength)));
    }
}
