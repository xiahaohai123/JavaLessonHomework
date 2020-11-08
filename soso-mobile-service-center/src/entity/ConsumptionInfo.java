package entity;

/**
 * @PackageName:entity
 * @ClassName:ConsumInfo
 * @Description: 消费信息
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 14:01
 */
public class ConsumptionInfo {
    // 电话号码
    private String cardNumber;
    // 流量数据消费（MB）
    private Integer consumedFlow;
    // 通话时间消费（分钟）
    private Integer consumedTalkTime;
    // 短信消费（条数）
    private Integer consumedSMSCount;
    // 年月
    private long yyyyMMMills;

    /**
     * 初始化用
     *
     * @param cardNumber 卡号
     */
    public ConsumptionInfo(String cardNumber) {
        this.cardNumber = cardNumber;
        consumedFlow = 0;
        consumedTalkTime = 0;
        consumedSMSCount = 0;
        yyyyMMMills = System.currentTimeMillis();
    }

    /**
     * 类加载的时候用
     *
     * @param cardNumber       卡号
     * @param consumedFlow     已用流量
     * @param consumedTalkTime 通话时间消费（分钟）
     * @param consumedSMSCount 短信消费（条数）
     * @param yyyyMMMills      年月
     */
    public ConsumptionInfo(String cardNumber, Integer consumedFlow, Integer consumedTalkTime, Integer consumedSMSCount, long yyyyMMMills) {
        this.cardNumber = cardNumber;
        this.consumedFlow = consumedFlow;
        this.consumedTalkTime = consumedTalkTime;
        this.consumedSMSCount = consumedSMSCount;
        this.yyyyMMMills = yyyyMMMills;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Integer getConsumedFlow() {
        return consumedFlow;
    }

    public Integer getConsumedTalkTime() {
        return consumedTalkTime;
    }

    public Integer getConsumedSMSCount() {
        return consumedSMSCount;
    }

    public void addConsumedflow(int added) {
        this.consumedFlow += added;
    }

    public void addConsumedTalkTime(int added) {
        this.consumedTalkTime += added;
    }

    public void addConsumedSMSCount(int added) {
        this.consumedSMSCount += added;
    }

    public long getYyyyMMMills() {
        return yyyyMMMills;
    }
}
