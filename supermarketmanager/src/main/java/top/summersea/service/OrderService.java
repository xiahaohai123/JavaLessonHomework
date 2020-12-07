package top.summersea.service;

import top.summersea.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Object> getOrderList();

    List<Object> getOrderList(String goodsName, List<Boolean> hasPayed, String supplierName);

    boolean addOrder(Map<String, Object> map);

    boolean updateOrderPay(Order order);
}
