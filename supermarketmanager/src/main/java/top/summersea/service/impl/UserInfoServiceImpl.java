package top.summersea.service.impl;

import top.summersea.dao.UserInfoDao;
import top.summersea.dao.impl.UserInfoDaoImpl;
import top.summersea.entity.UserInfo;
import top.summersea.service.UserInfoService;

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
            }
        }
        return objects;
    }
}
