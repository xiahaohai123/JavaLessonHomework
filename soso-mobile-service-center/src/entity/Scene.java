package entity;

/**
 * @PackageName:entity
 * @ClassName:Scene
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 14:03
 */
public class Scene {
    // 通话时间
    private int talkTime;
    // 短信
    private int smsCount;
    // 流量
    private int flow;
    // 描述
    private String description;

    public Scene(int talkTime, int smsCount, int flow, String description) {
        this.talkTime = talkTime;
        this.smsCount = smsCount;
        this.flow = flow;
        this.description = description;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public int getFlow() {
        return flow;
    }

    public String getDescription() {
        return description;
    }
}
