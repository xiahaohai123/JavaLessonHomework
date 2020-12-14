package top.summersea.hw2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName: top.summersea.hw2
 * @ClassName: HW2Test
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/14 14:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hw2.xml"})
public class HW2Test {
    @Autowired
    private ServiceDao serviceDao;

    @Test
    public void testSomething() {
        serviceDao.doSomething();
    }

    @Test
    public void testSomethingWrong() {
        serviceDao.doSomethingWrong();
    }

}
