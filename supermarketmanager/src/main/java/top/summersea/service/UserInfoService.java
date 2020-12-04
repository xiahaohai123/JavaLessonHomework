package top.summersea.service;

import top.summersea.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    /**
     * 登录 返回用户唯一编码
     *
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);

    boolean updatePassword(UserInfo userInfo, String newPassword);

    /**
     * 根据username的有无可以进行模糊查询
     *
     * @param username
     * @return
     */
    List<Object> getUserInfoList(String... username);

    boolean isUserIdExist(String userId);

    boolean registerUserInfo(UserInfo userInfo, String userTypeName);

    Map<String, Object> getUserInfoByUserId(String userId);

    boolean updateUserInfo(UserInfo userInfo, String userTypeName);

    boolean deleteUserInfoByUserId(String userId);
}
