package top.summersea.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @PackageName: top.summersea.controller
 * @ClassName: MethodFinder
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/6 18:21
 */
public class MethodFinder {
    public static void findAndInvokeMethod(Object invokeInstance, String methodName, Class<?>[] parameterClasses, Object... parameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = invokeInstance.getClass();
        // 获取class数组
        // 因为有多态问题所以这个方案行不通
//        Class<?>[] parameterClasses = new Class[parameters.length];
//        for (int i = 0; i < parameters.length; i++) {
//            parameterClasses[i] = parameters[i].getClass();
//        }

        // 根据方法名和class数组获取方法
        Method declaredMethod = cls.getDeclaredMethod(methodName, parameterClasses);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(invokeInstance, parameters);
    }
}
