package top.summersea.hw2;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectByAnnotation {

    @Pointcut("execution (* top.summersea.hw2.*.*(..))")
    public void my() {
    }

    @Before("my()")
    public void before() {
        System.out.println("AspectByXML前置通知。");
    }

    @AfterReturning("my()")
    public void afterReturn() {
        System.out.println("AspectByXML后置通知。");
    }

    @Around("my()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AspectByXML环绕通知前。");
        proceedingJoinPoint.proceed();
        System.out.println("AspectByXML环绕通知后。");
    }

    @AfterThrowing(pointcut = "my()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("AspectByXML异常通知：" + ex);
    }

    @After("my()")
    public void after() {
        System.out.println("AspectByXML最终通知。");
    }
}
