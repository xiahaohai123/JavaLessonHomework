package oac3;

import java.lang.reflect.Method;

/**
 * @PackageName: oac3
 * @ClassName: Person
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/23 19:11
 */
public class Person {
    int age;

    public Person(int age) {
        this.age = age;
    }

    @AgeLimit(age = 18)
    public boolean checkAge() {
        try {
            Method mCheckAge = getClass().getDeclaredMethod("checkAge");
            if (mCheckAge.isAnnotationPresent(AgeLimit.class)) {
                AgeLimit annotation = mCheckAge.getAnnotation(AgeLimit.class);
                if (age > annotation.age()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }
}
