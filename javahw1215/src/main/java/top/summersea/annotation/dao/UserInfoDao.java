package top.summersea.annotation.dao;


import top.summersea.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {

    List<Map<String, Object>> selectAllUserInfoWithUserType(String... username);

    UserInfo selectUserInfoById(String userId);

    UserInfo selectUserInfoByUsername(String username);

    int insertUserInfo(UserInfo userInfo);

    int updateUserInfo(UserInfo userInfo);

    int deleteUserInfo(String userId);

}
