package top.summersea.service.impl;

import top.summersea.dao.UserInfoDao;
import top.summersea.dao.impl.UserInfoDaoImpl;
import top.summersea.entity.UserInfo;
import top.summersea.service.UserInfoService;
import top.summersea.util.TimeUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: service
 * @ClassName: UserInfoServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 16:50
 */
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao;

    public UserInfoServiceImpl() {
        userInfoDao = new UserInfoDaoImpl();
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoDao.selectUserCodeByUsernameAndPassword(userInfo);
    }

    @Override
    public boolean updatePassword(UserInfo userInfo, String newPassword) {
        return userInfoDao.updatePasswordByUserCode(userInfo, newPassword) > 0;
    }

    @Override
    public List<Object> getUserInfoList(String... username) {
        List<Object> objects = userInfoDao.selectAllUserInfoWithUserType(username);
        for (Object object : objects) {
            if (object instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) object;
                // 性别显示转换
                if (map.get("sex").equals(true)) {
                    map.put("sex", "男");
                } else {
                    map.put("sex", "女");
                }

                map.put("bornDate", TimeUtil.dateToDateString((Date) map.get("bornDate")));
            }
        }
        return objects;
    }

    @Override
    public boolean isUserIdExist(String userId) {
        return userInfoDao.selectCountByUserId(userId) > 0;
    }

    @Override
    public boolean registerUserInfo(UserInfo userInfo, String userTypeName) {
        return userInfoDao.insertUserInfo(userInfo, userTypeName) > 0;
    }

    @Override
    public Map<String, Object> getUserInfoByUserId(String userId) {
        Map<String, Object> map = userInfoDao.selectUserInfoByUserId(userId);
        if ((Boolean) map.get("sex")) {
            map.put("sex", "男");
        } else {
            map.put("sex", "女");
        }
        map.put("bornDate", TimeUtil.dateToYyyyMMdd((Date) map.get("bornDate")));
        return map;
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo, String userTypeName) {
        return userInfoDao.updateUserInfo(userInfo, userTypeName) > 0;
    }

    @Override
    public boolean deleteUserInfoByUserId(String userId) {
        return userInfoDao.deleteUserInfoByUserId(userId) > 0;
    }
}
