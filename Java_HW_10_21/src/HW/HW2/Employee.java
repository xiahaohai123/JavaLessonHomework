package HW.HW2;

/**
 * @PackageName:HW.HW2
 * @ClassName:Employee
 * @Description: 员工类
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:15
 */
public class Employee {
    protected String name;
    // 年龄
    protected int age;
    protected String sex;

    public Employee() {
        sex = "男";
    }

    public Employee(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = "男";
        setSex(sex);
    }

    public void setSex(String sex) {
        if ("男".equals(sex) || "女".equals(sex)) {
            this.sex = sex;
        }
    }
}
