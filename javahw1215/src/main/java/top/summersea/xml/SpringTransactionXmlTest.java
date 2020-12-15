package top.summersea.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.summersea.entity.UserInfo;
import top.summersea.xml.controller.UserInfoController;

import java.util.Date;

/**
 * @PackageName: top.summersea.xml
 * @ClassName: SpringTransactionAnnotationTest
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/15 14:44
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-aop-transaction.xml")
public class SpringTransactionXmlTest {

    private UserInfoController userInfoController;

    public SpringTransactionXmlTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-transaction.xml");
        userInfoController = (UserInfoController) context.getBean("userInfoController");
    }

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
        userInfo.setUserId("Test02");
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
