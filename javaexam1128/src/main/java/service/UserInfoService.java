package service;

import entity.UserInfo;

/**
 * 负责userinfo表的业务处理
 */
public interface UserInfoService {
    // 登录
    boolean login(UserInfo userInfo);

    // 注册
    boolean register(UserInfo userInfo);
}
