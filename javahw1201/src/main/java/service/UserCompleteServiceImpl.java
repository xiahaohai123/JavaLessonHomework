package service;

import dao.UserCompleteDao;
import dao.UserCompleteDaoImpl;
import entity.UserComplete;

/**
 * @PackageName: service
 * @ClassName: UserCompleteServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/1 15:40
 */
public class UserCompleteServiceImpl implements UserCompleteService {
    private UserCompleteDao userCompleteDao;

    public UserCompleteServiceImpl() {
        userCompleteDao = new UserCompleteDaoImpl();
    }

    @Override
    public boolean isEmailExist(String email) {
        return userCompleteDao.selectEmailCount(email) > 0;
    }

    @Override
    public boolean login(UserComplete userComplete) {
        return userCompleteDao.selectCount(userComplete) > 0;
    }
}
