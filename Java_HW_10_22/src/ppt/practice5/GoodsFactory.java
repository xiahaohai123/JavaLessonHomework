package ppt.practice5;

/**
 * @PackageName:ppt.practice5
 * @ClassName:Goods
 * @Description: 工厂模式
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 15:00
 */
public class GoodsFactory {


    public static Goods getGoods(String input, double price) {
        Goods goods = null;
        switch (input) {
            case "电视":
                goods = new TVs(price);
                break;
            case "食品":
                goods = new Foods(price);
                break;
            default:
                break;
        }

        return goods;
    }


}
