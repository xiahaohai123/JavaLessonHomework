package HW.HW2;

/**
 * @PackageName:HW.HW2
 * @ClassName:Staff
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:21
 */
public class Staff extends Employee {
    // 所属部门
    private String dept;
    // 月薪
    private int salary;

    public Staff() {
    }

    public Staff(String name, int age, String sex, String dept, int salary) {
        super(name, age, sex);
        this.dept = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("雇员姓名：").append(name).append("，年龄：").append(age).append("，性别").append(sex);
        sb.append("，所属部门：").append(dept).append("，月薪：").append(salary);
        return sb.toString();
    }
}
