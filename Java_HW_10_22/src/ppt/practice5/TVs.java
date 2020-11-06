package ppt.practice5;

/**
 * @PackageName:ppt.practice5
 * @ClassName:TV
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 15:05
 */
public class TVs extends Goods {


    public TVs(double price) {
        super(price);
    }

    @Override
    public void showPrice() {
        System.out.println("该电视的价格为" + this.getPrice());
    }

    @Override
    public void showFunction() {
        System.out.println("该电视的功能是显示电视节目供观看");
    }
}
