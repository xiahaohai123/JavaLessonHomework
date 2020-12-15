package top.summersea.annotation.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.summersea.annotation.dao.UserInfoDao;
import top.summersea.entity.UserInfo;
import top.summersea.util.TimeUtil;

import javax.annotation.Resource;
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
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public UserInfo getUserInfoByUsername(String username) {
        return userInfoDao.selectUserInfoByUsername(username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public UserInfo getUserInfoByUserId(String userId) {
        return userInfoDao.selectUserInfoById(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteUserInfo(String userId) {
        return userInfoDao.deleteUserInfo(userId);
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = {ArithmeticException.class})
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateUserInfoError(UserInfo userInfo) {
//        int insertRow = userInfoDao.insertUserInfo(userInfo);
        int i = userInfoDao.updateUserInfo(userInfo);
        int error = 1 / 0;
        return i;
    }
}
