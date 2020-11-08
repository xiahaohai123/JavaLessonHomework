package entity;

import entity.service_package.ServicePackage;
import service.CallService;
import service.NetService;
import service.SendService;

import java.math.BigDecimal;

/**
 * @PackageName:entity
 * @ClassName:MobileCard
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 9:53
 */
public class MobileCard implements CallService, NetService, SendService {
    // 卡号
    private String cardNumber;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 使用的套餐 加载的时候用工厂模式
    private ServicePackage servicePackage;
    // 次月生效的套餐
    private ServicePackage nextServicePackage;
    // 消费的钱
    private Double consumAmount;
    // 余额
    private Double money;
    // 已使用通话时间
    private Integer realTalkTime;
    // 已经使用的信息数量
    private Integer realSMSCount;
    // 已使用的流量(MB)
    private Integer realFlow;
    // 注册时间
    private Long registerTime;

    /**
     * 注册卡用构造器
     *
     * @param cardNumber 卡号
     * @param username   用户名
     * @param password   密码
     */
    public MobileCard(String cardNumber, String username, String password) {
        this.cardNumber = cardNumber;
        this.username = username;
        this.password = password;
        // 为什么不默认初始化？ 因为声明的是包装类，默认初始化会初始化成null
        this.servicePackage = null;
        this.nextServicePackage = null;
        this.consumAmount = 0.0;
        this.money = 0.0;
        this.realTalkTime = 0;
        this.realSMSCount = 0;
        this.realFlow = 0;
        this.registerTime = System.currentTimeMillis();

    }

    /**
     * 从文件加载对象用的构造器
     *
     * @param cardNumber         卡号
     * @param username           名字
     * @param password           密码
     * @param servicePackage     套餐
     * @param nextServicePackage 次月套餐
     * @param consumAmount       月度消费金额
     * @param money              余额
     * @param realTalkTime       已用通话时间
     * @param realSMSCount       已用短信条数
     * @param realFlow           已用流量
     * @param registerTime       注册时间 long
     */
    public MobileCard(String cardNumber, String username, String password, ServicePackage servicePackage, ServicePackage nextServicePackage, Double consumAmount, Double money, Integer realTalkTime, Integer realSMSCount, Integer realFlow, Long registerTime) {
        this.cardNumber = cardNumber;
        this.username = username;
        this.password = password;
        this.servicePackage = servicePackage;
        this.nextServicePackage = nextServicePackage;
        this.consumAmount = consumAmount;
        this.money = money;
        this.realTalkTime = realTalkTime;
        this.realSMSCount = realSMSCount;
        this.realFlow = realFlow;
        this.registerTime = registerTime;
    }


    public String getCardNumber() {
        return cardNumber;
    }


    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }


    public ServicePackage getServicePackage() {
        return servicePackage;
    }

    public void changeServicePackage() {
        this.servicePackage = nextServicePackage;
    }

    public ServicePackage getNextServicePackage() {
        return nextServicePackage;
    }

    public void setNextServicePackage(ServicePackage nextServicePackage) {
        this.nextServicePackage = nextServicePackage;
    }

    public double getConsumAmount() {
        return consumAmount;
    }


    public double getMoney() {
        return money;
    }

    public void chargeMoney(double money) {
        this.money += money;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }


    public int getRealSMSCount() {
        return realSMSCount;
    }


    public int getRealFlow() {
        return realFlow;
    }


    public long getRegisterTime() {
        return registerTime;
    }

    /**
     * 打电话
     * 1、判断打电话前时间是否超时
     * **1）、如果已超时，则直接按超时加算
     * **2）、未超时
     * ****a、若此次电话时间+已用时间未超时，则按套餐内算
     * ****b、若综合超时，则超出部分加算
     * 2、生成新的消费单
     *
     * @param talkTime
     */
    @Override
    public void call(int talkTime) {
        int maxTalkTime = servicePackage.getAllowanceMap().getOrDefault("talkTime", 0);
        // 如果已超时
        if (realTalkTime >= maxTalkTime) {
            // 因为精度问题使用decimal
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(servicePackage.getBeyondTalkTimePrice()));
            bigDecimal = bigDecimal.multiply(new BigDecimal(talkTime));
            consumAmount += bigDecimal.doubleValue();
        } else {
            if (realTalkTime + talkTime > maxTalkTime) {
                // 套餐外超时加算
                consumAmount += new BigDecimal(String.valueOf(servicePackage.getBeyondTalkTimePrice())).multiply(new BigDecimal(realTalkTime + talkTime - maxTalkTime)).doubleValue();
            }
        }
        realTalkTime += talkTime;

    }

    /**
     * 上网
     * 计算策略同打电话
     *
     * @param flow 流量（MB）
     */
    @Override
    public void netPlay(int flow) {
        int maxFlow = servicePackage.getAllowanceMap().getOrDefault("flow", 0);
        if (realFlow >= maxFlow) {
            consumAmount += new BigDecimal(String.valueOf(servicePackage.getBeyondFlowPrice())).multiply(new BigDecimal(flow)).doubleValue();
        } else {
            if (realFlow + flow > maxFlow) {
                consumAmount += new BigDecimal(String.valueOf(servicePackage.getBeyondFlowPrice())).multiply(new BigDecimal(realFlow + flow - maxFlow)).doubleValue();
            }
        }
        realFlow += flow;
    }

    /**
     * 发短信
     * 如果已发短信条数大于套餐数量就按超量加算
     */
    @Override
    public void send() {
        if (realSMSCount >= servicePackage.getAllowanceMap().getOrDefault("smsCount", 0)) {
            // 超量加算
            consumAmount += new BigDecimal(String.valueOf(servicePackage.getBeyondSMSCountPrice())).doubleValue();
        }
        realSMSCount++;
    }
}
