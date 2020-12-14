package top.summersea.hw3.controller;

import top.summersea.hw3.service.UserInfoService;

/**
 * @PackageName: top.summersea.hw3.controller
 * @ClassName: UserInfoController
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/11 18:00
 */
public class UserInfoController {
    private UserInfoService userInfoService;

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    public void printAllUserInfo() {
        for (Object o : userInfoService.getUserInfoList()) {
            System.out.println(o);
        }
    }
}
