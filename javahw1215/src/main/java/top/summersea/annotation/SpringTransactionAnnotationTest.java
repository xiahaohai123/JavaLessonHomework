package top.summersea.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.summersea.annotation.controller.UserInfoController;
import top.summersea.entity.UserInfo;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @PackageName: top.summersea.xml
 * @ClassName: SpringTransactionAnnotationTest
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/15 14:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-aop-transaction-annotation.xml")
public class SpringTransactionAnnotationTest {

    @Resource
    private UserInfoController userInfoController;


    @Test
    public void showAllUserInfo() {
        userInfoController.printAllUserInfo();
    }

    @Test
    public void showUserInfoById() {
        userInfoController.printUserInfo("M0001");
    }

    @Test
    public void showUserInfoByUsername() {
        userInfoController.printUserInfoByUsername("孙主管");
    }

    @Test
    public void addUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("Test01");
        userInfo.setUsername("testName");
        userInfo.setPassword("123456");
        userInfo.setSex(true);
        userInfo.setBornDate(new Date());
        userInfo.setUserTel("1245484413");
        userInfo.setUserAddress("testAddress");
        userInfo.setTypeId("1");
        userInfoController.addUserInfo(userInfo);
    }

    @Test
    public void updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("Test01");
        userInfo.setUsername("testNameUpdate");
        userInfo.setPassword("123456");
        userInfo.setSex(true);
        userInfo.setBornDate(new Date());
        userInfo.setUserTel("1245484413");
        userInfo.setUserAddress("testAddress");
        userInfo.setTypeId("1");
        userInfoController.updateUserInfo(userInfo);
    }

    @Test
    public void deleteUserInfo() {
        userInfoController.deleteUserInfo("Test01");
    }

    @Test
    public void updateUserInfoError() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("Test01");
        userInfo.setUsername("testNameUpdateError");
        userInfo.setPassword("123456");
        userInfo.setSex(true);
        userInfo.setBornDate(new Date());
        userInfo.setUserTel("1245484413");
        userInfo.setUserAddress("testAddress");
        userInfo.setTypeId("1");
        userInfoController.updateUserInfoError(userInfo);
    }
}
