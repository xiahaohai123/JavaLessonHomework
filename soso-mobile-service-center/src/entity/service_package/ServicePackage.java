package entity.service_package;

/**
 * @PackageName:entity
 * @ClassName:ServicePackage
 * @Description: 套餐抽象父类
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 10:14
 */
public abstract class ServicePackage {
    private double price;

    public ServicePackage(double price) {
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public abstract String showInfo();

    /**
     * 获取工厂类选取字符串
     *
     * @return
     */
    public abstract String getSelectString();
}
