package service;

import entity.User;

public interface UserService {


    // 登录
    boolean login(User user);

    // 注册
    boolean register(User user);
}
