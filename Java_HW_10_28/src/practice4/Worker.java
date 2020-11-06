package practice4;

/**
 * @PackageName:practice4
 * @ClassName:Worker
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 15:05
 */
public class Worker {
    private String name;
    private int age;
    private int salary;

    public Worker(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + "\t" + age + "\t" + salary;
    }

    public void work() {
        System.out.println(name + "工作");
    }

    public String getName() {
        return name;
    }
}
