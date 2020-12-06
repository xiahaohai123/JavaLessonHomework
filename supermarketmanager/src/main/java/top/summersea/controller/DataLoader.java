package top.summersea.controller;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * @PackageName: top.summersea.controller
 * @ClassName: DataLoader
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/6 16:33
 */
public class DataLoader {
    /**
     * 装载单个类使用的方法
     * 利用request的parameters参数列表来装载
     *
     * @param cls
     * @param request
     * @param <T>
     * @return
     */
    public static <T> T loadClassByRequest(Class<T> cls, HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        T t = cls.newInstance();


        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            try {
                String parameterName = parameterNames.nextElement();
                Method declaredMethod = cls.getDeclaredMethod(getSetMethodName(parameterName), String.class);
                if (declaredMethod.getParameterTypes()[0].equals(String.class)) {
                    declaredMethod.invoke(t, request.getParameter(parameterName));
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    private static String getSetMethodName(String parameter) {
        char[] chars = parameter.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return "set" + String.valueOf(chars);
    }
}
