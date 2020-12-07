package top.summersea.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Object> getOrderList();

    List<Object> getOrderList(String goodsName, List<Boolean> hasPayed, String supplierName);

    boolean addOrder(Map<String, Object> map);
}
