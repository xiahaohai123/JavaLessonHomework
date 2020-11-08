package entity.service_package;

import java.util.Map;

/**
 * @PackageName:entity
 * @ClassName:ServicePackage
 * @Description: 套餐抽象父类
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 10:14
 */
public abstract class ServicePackage {
    private double price;

    // 超出通话时长单价（元/分钟）
    private double beyondTalkTimePrice;
    // 超出短信单价（元/条）
    private double beyondSMSCountPrice;
    // 流量超出单价（元/MB）
    private double beyondFlowPrice;

    public ServicePackage(double price, double beyondTalkTimePrice, double beyondSMSCountPrice, double beyondFlowPrice) {
        this.price = price;
        this.beyondTalkTimePrice = beyondTalkTimePrice;
        this.beyondSMSCountPrice = beyondSMSCountPrice;
        this.beyondFlowPrice = beyondFlowPrice;
    }

    public double getPrice() {
        return price;
    }

    public double getBeyondTalkTimePrice() {
        return beyondTalkTimePrice;
    }

    public double getBeyondSMSCountPrice() {
        return beyondSMSCountPrice;
    }

    public double getBeyondFlowPrice() {
        return beyondFlowPrice;
    }

    public abstract String showInfo();

    /**
     * 获取工厂类选取字符串
     *
     * @return String
     */
    public abstract String getSelectString();

    /**
     * 获取可用资源值
     *
     * @return map，包含所有资源的可用量
     * 比如 flow:5(MB)
     * 如果可用量为0可以用null表示
     */
    public abstract Map<String, Integer> getAllowanceMap();
}
