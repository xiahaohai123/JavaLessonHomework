package dao;

import entity.UserInfo;

/**
 * @PackageName: dao
 * @ClassName: UserInfoDao
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/28 9:36
 */
public interface UserInfoDao {
    public Integer insert(UserInfo userInfo);

    Integer selectCount(UserInfo userInfo);
}
