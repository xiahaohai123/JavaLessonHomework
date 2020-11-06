import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Player
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 11:11
 */
public class Player {
    // 当前级别
    private Level level;
    // 积分
    private int currScore;
    // 当前级别开始时间
    private long startTime;
    // 当前级别已用时间
    private int clapsedTime;


    /**
     * 构造器初始化数据
     */
    public Player() {
        level = Level.L1;
        currScore = 0;
    }

    public void play() {
        // 输入流
        Scanner sc = new Scanner(System.in);
        System.out.println("打字游戏启动！");
        // 游戏
        Game game = new Game(this);

        while (game.isRunning()) {
            // 输出问题
            String question = game.printStr();
            System.out.println(question);

            // 获取答案
            String input = sc.next();
            System.out.println(game.getResult(input));
        }
        sc.close();


    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getClapsedTime() {
        return clapsedTime;
    }

    public void addCurrScore(int addScore) {
        this.currScore += addScore;
    }
}
