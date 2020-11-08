package service;

import entity.MobileCard;
import entity.service_package.ServicePackage;

/**
 * 负责处理大厅业务
 */
public interface SystemService {
    /**
     * 注册卡
     *
     * @param card card对象
     * @return boolean 成功true
     */
    boolean registerMobileCard(MobileCard card);

    /**
     * 卡是否已注册
     *
     * @param cardNum 卡号
     * @return boolean true 说明已注册
     */
    boolean isExist(String cardNum);

    /**
     * 登录
     * 登录成功返回卡对象
     * 登录失败返回null
     *
     * @param cardNum  卡号
     * @param password 密码
     * @return MobileCard 登录成功后返回的对象，失败返回null
     */
    MobileCard login(String cardNum, String password);

    /**
     * 查看本月账单
     *
     * @param card card
     * @return 字符串
     */
    String lookupBillCurMonth(MobileCard card);

    /**
     * 查看本月套餐余量
     *
     * @param card card
     * @return 字符串
     */
    String lookupMealAllowance(MobileCard card);

    /**
     * 查看消费详单
     *
     * @param card card
     * @return string
     */
    String getConsumptionInfoList(MobileCard card);

    /**
     * 更换套餐
     *
     * @param card           card
     * @param servicePackage service
     * @return boolean 更换是否成功
     */
    boolean changeNextMenu(MobileCard card, ServicePackage servicePackage);

    /**
     * 获取资费说明
     *
     * @return String 资费说明
     */
    String getExpensesDescription();

    /**
     * 退网
     *
     * @param card card
     * @return 是否成功
     */
    boolean withdrawFromTheNet(MobileCard card);

    /**
     * 话费充值
     *
     * @param card card
     * @param fee  充值费用
     * @return boolean 成功与否
     */
    boolean chargeCard(MobileCard card, double fee);

    /**
     * 使用搜搜消费
     *
     * @param card card
     * @return string 事项描述
     */
    String useSoSo(MobileCard card);
}
