package top.summersea.service;

import java.util.List;

public interface OrderService {
    List<Object> getOrderList();

    List<Object> getOrderList(String goodsName, List<Boolean> hasPayed, String supplierName);
}
