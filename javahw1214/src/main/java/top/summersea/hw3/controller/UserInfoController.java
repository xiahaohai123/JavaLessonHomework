package top.summersea.hw3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import top.summersea.hw3.service.UserInfoService;

/**
 * @PackageName: top.summersea.hw3.controller
 * @ClassName: UserInfoController
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/11 18:00
 */
@Controller
public class UserInfoController {
    @Autowired
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
