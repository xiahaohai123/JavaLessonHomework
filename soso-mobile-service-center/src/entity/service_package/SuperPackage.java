package entity.service_package;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:entity
 * @ClassName:SuperPackage
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 10:47
 */
public class SuperPackage extends ServicePackage {
    // 通话时间(分)
    private int talkTime;
    // 可用信息条数(条)
    private int smsCount;
    // 可用流量(MB)
    private int flow;

    public SuperPackage(double price, double beyondTalkTimePrice, double beyondSMSCountPrice, double beyondFlowPrice, int talkTime, int smsCount, int flow) {
        super(price, beyondTalkTimePrice, beyondSMSCountPrice, beyondFlowPrice);
        this.talkTime = talkTime;
        this.smsCount = smsCount;
        this.flow = flow;
    }

    @Override
    public String showInfo() {
        return "----------话唠套餐----------" +
                "\n***通话时间：" + talkTime + "分" +
                "\n***可用信息：" + smsCount + "条" +
                "\n***可用流量：" + flow + "(MB)" +
                "\n***资费：" + getPrice() +
                "\n----------********----------\n";
    }

    @Override
    public String getSelectString() {
        return "超人套餐";
    }

    @Override
    public Map<String, Integer> getAllowanceMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("flow", flow);
        map.put("smsCount", smsCount);
        map.put("talkTime", talkTime);
        return map;
    }
}
