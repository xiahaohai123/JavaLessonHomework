package service;

import dao.UserInfoDao;
import dao.UserInfoDaoImpl;
import entity.UserInfo;

/**
 * @PackageName: service
 * @ClassName: UserInfoServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/28 9:28
 */
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao;

    public UserInfoServiceImpl() {
        userInfoDao = new UserInfoDaoImpl();
    }

    @Override
    public boolean login(UserInfo userInfo) {
        return userInfoDao.selectCount(userInfo) > 0;
    }

    @Override
    public boolean register(UserInfo userInfo) {
        return userInfoDao.insert(userInfo) > 0;
    }
}
