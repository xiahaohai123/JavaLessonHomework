package top.summersea.hw1;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @PackageName: top.summersea.hw1
 * @ClassName: AspectByXML
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/14 14:00
 */
public class AspectByXML {
    public void before() {
        System.out.println("AspectByXML前置通知。");
    }

    public void afterReturn() {
        System.out.println("AspectByXML后置通知。");
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AspectByXML环绕通知前。");
        proceedingJoinPoint.proceed();
        System.out.println("AspectByXML环绕通知后。");
    }

    public void afterThrowing(Throwable ex) {
        System.out.println("AspectByXML异常通知：" + ex);
    }

    public void after() {
        System.out.println("AspectByXML最终通知。");
    }
}
