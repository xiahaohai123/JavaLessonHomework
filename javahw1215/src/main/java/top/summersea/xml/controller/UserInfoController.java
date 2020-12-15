package top.summersea.xml.controller;


import top.summersea.entity.UserInfo;
import top.summersea.xml.service.UserInfoService;

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

    public void printUserInfo(String userId) {
        System.out.println(userInfoService.getUserInfoByUserId(userId));
    }

    public void printUserInfoByUsername(String username) {
        System.out.println(userInfoService.getUserInfoByUsername(username));
    }

    public void addUserInfo(UserInfo userInfo) {
        System.out.println(userInfoService.addUserInfo(userInfo));
    }

    public void updateUserInfo(UserInfo userInfo) {
        System.out.println(userInfoService.updateUserInfo(userInfo));
    }

    public void deleteUserInfo(String userId) {
        System.out.println(userInfoService.deleteUserInfo(userId));
    }

    public void updateUserInfoError(UserInfo userInfo) {
        System.out.println(userInfoService.updateUserInfoError(userInfo));
    }
}
