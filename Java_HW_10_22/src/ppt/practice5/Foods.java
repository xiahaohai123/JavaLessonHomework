package ppt.practice5;

/**
 * @PackageName:ppt.practice5
 * @ClassName:Foods
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 15:07
 */
public class Foods extends Goods {
    public Foods(double price) {
        super(price);
    }

    @Override
    public void showPrice() {
        System.out.println("该食品的价格为" + this.getPrice());
    }

    @Override
    public void showFunction() {
        System.out.println("该食品的功能是给人充饥，保证一段时间的能量");
    }
}
