package top.summersea.dao;

import top.summersea.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    List<Object> getOrderList();

    List<Object> getOrderList(String goodsName, List<Boolean> hasPayed, String supplierName);

    Integer insertOrder(Map<String, Object> map);

    Integer updateOrder(Order order);
}
