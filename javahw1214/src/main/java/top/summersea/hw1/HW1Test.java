package top.summersea.hw1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @PackageName: top.summersea.hw1
 * @ClassName: HW1Test
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/14 14:23
 */
public class HW1Test {

    @Test
    public void testAopByXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hw1.xml");
        ServiceDao serviceDao = (ServiceDao) context.getBean("serviceDao");
        serviceDao.doSomething();

        System.out.println("\n干坏事\n");
        serviceDao.doSomethingWrong();
    }
}
