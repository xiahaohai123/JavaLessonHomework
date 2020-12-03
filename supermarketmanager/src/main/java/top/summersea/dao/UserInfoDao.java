package top.summersea.dao;

import top.summersea.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    UserInfo selectUserCodeByUsernameAndPassword(UserInfo userInfo);

    Integer updatePasswordByUserCode(UserInfo userInfo, String newPassword);

    List<Object> selectAllUserInfoWithUserType(String... username);
}
