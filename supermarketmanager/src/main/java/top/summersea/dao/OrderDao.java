package top.summersea.dao;

import java.util.List;

public interface OrderDao {
    List<Object> getOrderList();

    List<Object> getOrderList(String goodsName, List<Boolean> hasPayed, String supplierName);
}
