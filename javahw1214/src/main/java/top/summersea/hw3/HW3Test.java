package top.summersea.hw3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.summersea.hw3.controller.UserInfoController;

/**
 * @PackageName: top.summersea.hw3
 * @ClassName: HW3Test
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/14 16:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hw3.xml"})
public class HW3Test {
    @Autowired
    UserInfoController userInfoController;

    @Test
    public void iocTest() {
        userInfoController.printAllUserInfo();
    }
}
