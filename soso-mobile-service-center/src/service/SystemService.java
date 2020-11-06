package service;

import entity.MobileCard;

/**
 * 负责处理大厅业务
 */
public interface SystemService {
    /**
     * 注册卡
     *
     * @param card card对象
     * @return
     */
    boolean registerMobileCard(MobileCard card);

    /**
     * 卡是否已注册
     *
     * @param cardNum 卡号
     * @return
     */
    boolean isExist(String cardNum);

    /**
     * 登录
     * 登录成功返回卡对象
     * 登录失败返回null
     *
     * @param cardNum  卡号
     * @param password 密码
     * @return
     */
    MobileCard login(String cardNum, String password);

    String lookupBillCurMonth(MobileCard card);
}
