package top.summersea.xml.service;


import top.summersea.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {

    /**
     * 根据username的有无可以进行模糊查询
     *
     * @param username
     * @return
     */
    List<Map<String, Object>> getUserInfoList(String... username);

    UserInfo getUserInfoByUserId(String userId);

    UserInfo getUserInfoByUsername(String username);

    int addUserInfo(UserInfo userInfo);

    int updateUserInfo(UserInfo userInfo);

    int deleteUserInfo(String userId);

    int updateUserInfoError(UserInfo userInfo);
}
