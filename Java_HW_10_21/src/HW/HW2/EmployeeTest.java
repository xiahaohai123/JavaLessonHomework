package HW.HW2;

/**
 * @PackageName:HW.HW2
 * @ClassName:EmployeeTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 15:29
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("甲", 31, "男", "项目经理", 200000);
        Manager manager2 = new Manager("乙", 34, "女", "项目经理", 200000);
        Staff staff = new Staff("丙", 23, "女", "人事部", 5000);
        Staff staff2 = new Staff("丁", 23, "男", "开发部", 8000);

        System.out.println(manager);
        System.out.println(manager2);
        System.out.println(staff);
        System.out.println(staff2);
    }
}
