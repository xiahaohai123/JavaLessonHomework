package service;

import dao.HomeworkDao;
import dao.IHomeworkDao;
import entity.User;

import java.util.List;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: service.UserServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/26 18:00
 */
public class UserServiceImpl implements UserService {
    private IHomeworkDao homeworkDao;

    public UserServiceImpl() {
        homeworkDao = new HomeworkDao();
    }

    @Override
    public boolean login(User user) {
        return homeworkDao.selectCount(user) == 1;
    }

    @Override
    public boolean register(User user) {
        return homeworkDao.insert(user) > 0;
    }

    @Override
    public List<User> listAllUser() {
        return homeworkDao.selectUserList();
    }

    @Override
    public boolean updateUserInfo(User user) {
        return homeworkDao.updateUser(user) > 0;
    }

    @Override
    public boolean deleteUser(int id) {
        return homeworkDao.deleteUser(id) > 0;
    }
}
