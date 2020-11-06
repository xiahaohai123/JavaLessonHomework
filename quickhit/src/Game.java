import java.util.Random;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Game
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 11:11
 */
public class Game {
    private static final int CLEARANCE = 2;// 通关
    private static final int LEVEL_UP = 1;// 升级
    private static final int NOT_LEVEL_UP = 0;// 未升级

    // 游戏是否在运行
    private boolean isRunning;
    // 随机数
    private Random random;
    // 玩家
    private Player player;
    // 最后一个输出的问题
    private String lastQuestion;
    // 所有级别数组
    private Level[] levels;
    // 当前级别正确输入次数
    private int correctlyInputTime;
    // 累计分数
    private int accumulateScore;

    public Game(Player player) {
        this.player = player;
        // 重置player的数据
        resetData();
        random = new Random();
        isRunning = true;
        levels = Level.values();
        correctlyInputTime = 0;
        accumulateScore = 0;
    }

    /**
     * 给出题目
     *
     * @return
     */
    public String printStr() {
        if (isRunning) {
            // 单线程
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < player.getLevel().getStrLength(); i++) {
                // 获取随机数
                char randChar = (char) (random.nextInt(26) + 'a');
                stringBuilder.append(randChar);
            }
            lastQuestion = stringBuilder.toString();
            return lastQuestion;
        } else {
            return "游戏已结束。";
        }
    }


    public String getResult(String input) {

        if (isRunning) {
            if ((System.currentTimeMillis() - player.getStartTime()) / 1000 < player.getLevel().getTimeLimit()) {
                if (lastQuestion.equals(input)) {
                    return operateCorrect();
                } else {
                    // 游戏结束
                    isRunning = false;
                    // 最终结算积分
                    settleScore();
                    return "打错字了，闯关失败，退出，您的积分为：" + accumulateScore + "分";
                }
            } else {
                // 游戏结束
                isRunning = false;
                // 最终结算积分
                settleScore();
                return "超时了，游戏结束，您的积分为：" + accumulateScore + "分";
            }
        } else {
            return "游戏已结束。";
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    /**
     * 判断正确后的操作
     *
     * @return
     */
    private String operateCorrect() {
        // 已用时间
        long usedTime = (System.currentTimeMillis() - player.getStartTime()) / 1000;
        String result;
        // 给分
        player.addCurrScore(player.getLevel().getPerScore());
        // 正确输入次数增加
        correctlyInputTime++;
        int levelUpState = levelUp();
        if (levelUpState == NOT_LEVEL_UP) {
            result = "输入正确，您的积分" + player.getCurrScore() +
                    "，您的级别" + player.getLevel().getLevelNo() +
                    "，已用时间" + usedTime + "秒";
        } else if (levelUpState == LEVEL_UP) {
            result = "输入正确，您的积分" + player.getCurrScore() +
                    "，已用时间" + usedTime + "秒。" +
                    "\n升级！，您的级别" + player.getLevel().getLevelNo();
        } else {
            result = "恭喜您通关了！您的积分是" + accumulateScore + "分";
            isRunning = false;
        }
        return result;
    }

    /**
     * 升级方法
     *
     * @return 1: 升级 2: 通关 0:不足以升级
     */
    private int levelUp() {
        Level playLevel = player.getLevel();
        // 如果正确次数到了则升级
        if (correctlyInputTime >= playLevel.getStrTimes()) {
            if (playLevel.isMaxLevel()) {
                // 积分
                settleScore();
                return CLEARANCE;
            } else {
                // 升级
                player.setLevel(levels[playLevel.getLevelNo()]);
                // 累加积分
                settleScore();
                // 重置数据
                resetData();
                return LEVEL_UP;
            }
        } else {
            return NOT_LEVEL_UP;
        }
    }

    /**
     * 重置数据
     */
    private void resetData() {
        correctlyInputTime = 0;
        player.setCurrScore(0);
        player.setStartTime(System.currentTimeMillis());
    }

    /**
     * 结算总积分
     */
    private void settleScore() {
        accumulateScore += player.getCurrScore();
    }

}
