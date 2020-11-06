package order;

import java.io.Serializable;

/**
 * @PackageName:order
 * @ClassName:Custom
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 16:19
 */
public class Customer implements Serializable {
    private Order order;
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
