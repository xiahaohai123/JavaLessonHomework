package top.summersea.hw1;

/**
 * @PackageName: top.summersea.hw1
 * @ClassName: ServiceDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/14 14:23
 */
public class ServiceDaoImpl implements ServiceDao {
    @Override
    public void doSomething() {
        System.out.println("做了些啥。。");
    }

    @Override
    public void doSomethingWrong() {
        System.out.println("来个1除以0吧！");
        int i = 1 / 0;
    }
}
