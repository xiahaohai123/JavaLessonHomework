package order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:order
 * @ClassName:Order
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 16:19
 */
public class Order implements Serializable {
    private int id;
    private List<Commodity> commodityList;

    public Order(int id) {
        this.id = id;
        commodityList = new ArrayList<>();
    }

    public void addCommodity(Commodity commodity) {
        commodityList.add(commodity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("产品名\t\t单价\t\t数量\n");
        // 总价
        double total = 0D;
        for (Commodity commodity : commodityList) {
            // 增加总价
            double unitPrice = commodity.getUnitPrice();
            int num = commodity.getNums();
            total += unitPrice * num;

            // 拼接字符串
            sb.append(commodity.getName()).append("\t\t\t");
            sb.append(commodity.getNums()).append("\t\t\t");
            sb.append(commodity.getUnitPrice()).append('\n');
        }

        sb.append("\n订单总价：").append(total);

        return sb.toString();
    }
}
