package top.summersea.xml.service;


import top.summersea.entity.UserInfo;
import top.summersea.util.TimeUtil;
import top.summersea.xml.dao.UserInfoDao;

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

//    public UserInfoServiceImpl() {
//        userInfoDao = new UserInfoDaoImpl();
//    }
//
//    public void setUserInfoDao(UserInfoDao userInfoDao) {
//        this.userInfoDao = userInfoDao;
//    }


    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public List<Map<String, Object>> getUserInfoList(String... username) {
        List<Map<String, Object>> list = userInfoDao.selectAllUserInfoWithUserType(username);
        for (Map<String, Object> map : list) {
            // 性别显示转换
            if (map.get("sex").equals(true)) {
                map.put("sex", "男");
            } else {
                map.put("sex", "女");
            }

            map.put("bornDate", TimeUtil.dateToDateString((Date) map.get("bornDate")));

        }
        return list;
    }

    @Override
    public UserInfo getUserInfoByUsername(String username) {
        return userInfoDao.selectUserInfoByUsername(username);
    }

    @Override
    public UserInfo getUserInfoByUserId(String userId) {
        return userInfoDao.selectUserInfoById(userId);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfo(String userId) {
        return userInfoDao.deleteUserInfo(userId);
    }

    @Override
    public int updateUserInfoError(UserInfo userInfo) {
        int insertRow =userInfoDao.insertUserInfo(userInfo);
//        int i = userInfoDao.updateUserInfo(userInfo);
        int error = 1 / 0;
        return insertRow;
    }
}
