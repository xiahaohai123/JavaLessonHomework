package ppt.practice1;

/**
 * @PackageName:practice1
 * @ClassName:HandSet
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 14:05
 */
public abstract class Handset {
    // 品牌
    private String brand;
    // 类型
    private String type;

    public Handset(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    // 发信息
    public abstract void sendInfo();

    // 打电话
    public abstract void call();

    // 信息
    public void info() {
        System.out.println("这是一款型号为" + type + "的" + brand + "手机");
    }
    
}
