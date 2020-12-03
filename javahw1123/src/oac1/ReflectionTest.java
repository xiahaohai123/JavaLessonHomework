package oac1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: oac1.ReflectionTest
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/23 18:31
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取class对象
        // 1、直接获取
        Class<?> c1 = Student.class;
        System.out.println("直接获取：" + c1.getName());

        // 2、Class.forName();
        Class c2 = Class.forName("oac1.Student");
        System.out.println("Class.forName()：" + c2.getName());

        // 3、instance.getClass();
        Student student = new Student();
        System.out.println("getClass：" + student.getClass());

        // 获取结构信息
        System.out.println("获取结构信息");
        System.out.println("Student域信息：");
        for (Field declaredField : c2.getDeclaredFields()) {
            // 域名字和域类型
            System.out.println(declaredField.getName() + ":" + declaredField.getType());
        }
        // 获取方法列表
        System.out.println("获取方法列表");
        for (Method declaredMethod : c2.getDeclaredMethods()) {
            System.out.println("name:" + declaredMethod.getName() + "\treturnType:" + declaredMethod.getReturnType());
            int i = 0;
            for (Class<?> parameterType : declaredMethod.getParameterTypes()) {
                System.out.println("参数" + (++i) + ":" + parameterType);
            }
            System.out.println();
        }

        // 通过无参构造构造学生并输出
        Constructor constructor = c2.getConstructor();
        System.out.println(constructor.newInstance());

        // 有参构造器并输出
        Constructor constructor1 = c2.getConstructor(String.class, int.class);
        System.out.println(constructor1.newInstance("asd", 16));

    }
}
