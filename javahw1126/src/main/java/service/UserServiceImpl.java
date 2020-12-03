package service;

import dao.HomeworkDao;
import dao.IHomeworkDao;
import entity.User;

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
}
