package ppt.practice5;

/**
 * @PackageName:ppt.practice5
 * @ClassName:Goods
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 11:41
 */
public abstract class Goods {
    // 价格
    private double price;

    public Goods(double price) {
        this.price = price;
    }

    /**
     * 显示价格
     *
     * @return
     */
    public abstract void showPrice();

    /**
     * 显示功能
     *
     * @return
     */
    public abstract void showFunction();


    public double getPrice() {
        return price;
    }
}
