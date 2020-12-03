package service;

import entity.User;

import java.util.List;

public interface UserService {


    // 登录
    boolean login(User user);

    // 注册
    boolean register(User user);

    // 列出所有
    List<User> listAllUser();

    boolean updateUserInfo(User user);

    boolean deleteUser(int id);

    boolean isUsernameExist(String username);
}
