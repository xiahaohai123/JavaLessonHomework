/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Level
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 11:11
 */
public enum Level {
    L1(1, 2, 2, 30, 1),
    L2(2, 3, 2, 12, 2),
    L3(3, 4, 3, 12, 3),
    L4(4, 5, 4, 16, 4),
    L5(5, 6, 6, 20, 5);
    // 各级别号
    private int levelNo;
    // 各级别一次输出字符串的长度
    private int strLength;
    // 各级别输出字符串的次数
    private int strTimes;
    // 各级别的闯关时间
    private int timeLimit;
    // 各级别正确输入一次的得分
    private int perScore;

    Level(int levelNo, int strLength, int strTimes, int timeLimit, int perScore) {
        this.levelNo = levelNo;
        this.strLength = strLength;
        this.strTimes = strTimes;
        this.timeLimit = timeLimit;
        this.perScore = perScore;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public int getStrLength() {
        return strLength;
    }

    public int getStrTimes() {
        return strTimes;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getPerScore() {
        return perScore;
    }

    public boolean isMaxLevel() {
        return this == L5;
    }
}
