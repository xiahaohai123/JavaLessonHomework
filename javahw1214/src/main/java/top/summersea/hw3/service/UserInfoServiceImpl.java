package top.summersea.hw3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.summersea.hw3.dao.UserInfoDao;
import top.summersea.hw3.util.TimeUtil;

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
    @Autowired
    private UserInfoDao userInfoDao;

//    public UserInfoServiceImpl() {
//        userInfoDao = new UserInfoDaoImpl();
//    }
//
//    public void setUserInfoDao(UserInfoDao userInfoDao) {
//        this.userInfoDao = userInfoDao;
//    }


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

}
