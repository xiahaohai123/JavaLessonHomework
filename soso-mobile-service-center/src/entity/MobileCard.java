package entity;

import entity.service_package.ServicePackage;

/**
 * @PackageName:entity
 * @ClassName:MobileCard
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 9:53
 */
public class MobileCard {
    // 卡号
    private String cardNumber;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 使用的套餐 加载的时候用工厂模式
    private ServicePackage servicePackage;
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
     * @param cardNumber     卡号
     * @param username       名字
     * @param password       密码
     * @param servicePackage 套餐
     * @param consumAmount   月度消费金额
     * @param money          余额
     * @param realTalkTime   已用通话时间
     * @param realSMSCount   已用短信条数
     * @param realFlow       已用流量
     * @param registerTime   注册时间 long
     */
    public MobileCard(String cardNumber, String username, String password, ServicePackage servicePackage, Double consumAmount, Double money, Integer realTalkTime, Integer realSMSCount, Integer realFlow, Long registerTime) {
        this.cardNumber = cardNumber;
        this.username = username;
        this.password = password;
        this.servicePackage = servicePackage;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ServicePackage getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(ServicePackage servicePackage) {
        this.servicePackage = servicePackage;
    }

    public double getConsumAmount() {
        return consumAmount;
    }

    public void setConsumAmount(double consumAmount) {
        this.consumAmount = consumAmount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(int realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }

    public long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(long registerTime) {
        this.registerTime = registerTime;
    }
}
