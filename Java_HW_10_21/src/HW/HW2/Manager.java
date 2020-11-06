package HW.HW2;

/**
 * @PackageName:HW.HW2
 * @ClassName:Manager
 * @Description: 继承自Employee
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:20
 */
public class Manager extends Employee {
    // 职务
    private String job;
    // 年薪
    private int jncome;

    public Manager() {
    }

    public Manager(String name, int age, String sex, String job, int jncome) {
        super(name, age, sex);
        this.job = job;
        this.jncome = jncome;
    }

    /**
     * 返回整体信息
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("经理姓名：").append(name).append("，年龄：").append(age).append("，性别").append(sex);
        sb.append("，职务：").append(job).append("，年薪：").append(jncome);
        return sb.toString();
    }
}
