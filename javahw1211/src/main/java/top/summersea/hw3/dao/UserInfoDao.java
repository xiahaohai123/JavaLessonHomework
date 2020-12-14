package top.summersea.hw3.dao;


import top.summersea.hw3.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {
    UserInfo selectUserCodeByUsernameAndPassword(UserInfo userInfo);

    Integer updatePasswordByUserCode(UserInfo userInfo, String newPassword);

    List<Object> selectAllUserInfoWithUserType(String... username);

    Integer selectCountByUserId(String userId);

    Integer insertUserInfo(UserInfo userInfo, String typeName);

    Map<String, Object> selectUserInfoByUserId(String userId);

    Integer updateUserInfo(UserInfo userInfo, String typeName);

    Integer deleteUserInfoByUserId(String userId);
}
