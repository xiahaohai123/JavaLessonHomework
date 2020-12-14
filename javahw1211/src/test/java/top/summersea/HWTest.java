package top.summersea;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.summersea.hw1.PersonSay;
import top.summersea.hw2.Printer;
import top.summersea.hw3.controller.UserInfoController;

/**
 * @PackageName: top.summersea
 * @ClassName: HWTest
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/11 16:27
 */
public class HWTest {

    @Test
    public void hw1Test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-hw1-cfg.xml");
        PersonSay zhangGa = (PersonSay) applicationContext.getBean("zhangGa");
        PersonSay rod = (PersonSay) applicationContext.getBean("rod");

        zhangGa.say();
        rod.say();

        applicationContext.close();
    }

    @Test
    public void hw2Test() {
        // 引入配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-hw2-cfg.xml");
        // 根据配置文件内定义的id获取到bean
        Printer blackA4Printer = (Printer) classPathXmlApplicationContext.getBean("blackA4Printer");
        Printer blueA3Printer = (Printer) classPathXmlApplicationContext.getBean("blueA3Printer");

        System.out.println(blackA4Printer);
        System.out.println(blueA3Printer);
    }

    @Test
    public void hw3Test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hw3-cfg.xml");

        UserInfoController userInfoController = (UserInfoController) context.getBean("userInfoController");
        userInfoController.printAllUserInfo();

    }

}
