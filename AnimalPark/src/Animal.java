/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Animal
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:59
 */
public abstract class Animal {
    // 名字
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void shout();

}
