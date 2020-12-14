package top.summersea.mapper;

import top.summersea.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    List<Map> selectOrderByGoodsNameAndSupplierIdAndPayInMap(Map<String, Object> parameterMap);

    List<Order> selectOrderByGoodsNameAndSupplierIdAndPayInOrder(Map<String, Object> parameterMap);
    List<Order> selectOrderByGoodsNameAndSupplierIdAndPayInOrderByPractice2(Map<String, Object> parameterMap);
}
