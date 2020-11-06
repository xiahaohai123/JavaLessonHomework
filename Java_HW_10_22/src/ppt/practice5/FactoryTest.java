package ppt.practice5;

/**
 * @PackageName:ppt.practice5
 * @ClassName:FactoryTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 15:09
 */
public class FactoryTest {
    public static void main(String[] args) {
        Goods tv = GoodsFactory.getGoods("电视", 3000);
        Goods food = GoodsFactory.getGoods("食品", 16);

        if (tv != null) {
            tv.showFunction();
            tv.showPrice();
        } else {
            System.out.println("此商品不存在");
        }
        if (food != null) {
            food.showFunction();
            food.showPrice();
        } else {
            System.out.println("此商品不存在");
        }
    }

}
