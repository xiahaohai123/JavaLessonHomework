package entity.service_package;

/**
 * @PackageName:entity
 * @ClassName:NetPackage
 * @Description: 网虫套餐实体类
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 10:41
 */
public class NetPackage extends ServicePackage {
    // 可用流量(MB)
    private int flow;

    public NetPackage(double price, int flow) {
        super(price);
        this.flow = flow;
    }

    @Override
    public String showInfo() {
        return "----------网虫套餐----------" +
                "\n***可用流量：" + flow + "(MB)" +
                "\n***资费：" + getPrice() +
                "\n----------********----------\n";
    }

    @Override
    public String getSelectString() {
        return "网虫套餐";
    }
}
