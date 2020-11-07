package entity.service_package;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:entity
 * @ClassName:TalkPackage
 * @Description: 话唠套餐实体类
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 10:16
 */
public class TalkPackage extends ServicePackage {
    // 通话时间(分)
    private int talkTime;
    // 可用信息条数(条)
    private int smsCount;

    public TalkPackage(double price, int talkTime, int smsCount) {
        super(price);
        this.talkTime = talkTime;
        this.smsCount = smsCount;
    }

    @Override
    public String showInfo() {
        /*
        在这种场景下直接返回字符串拼接和StringBuilder等价
        详见反编译机器码
         */
        return "----------话唠套餐----------" +
                "\n***通话时间：" + talkTime + "分" +
                "\n***可用信息：" + smsCount + "条" +
                "\n***资费：" + getPrice() +
                "\n----------********----------\n";
    }

    @Override
    public String getSelectString() {
        return "话唠套餐";
    }

    @Override
    public Map<String, Integer> getAllowanceMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("talkTime", talkTime);
        map.put("smsCount", smsCount);
        return map;
    }
}
