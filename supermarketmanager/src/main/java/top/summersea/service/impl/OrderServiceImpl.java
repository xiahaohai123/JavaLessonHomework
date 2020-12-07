package top.summersea.service.impl;

import top.summersea.dao.OrderDao;
import top.summersea.dao.impl.OrderDaoImpl;
import top.summersea.service.OrderService;
import top.summersea.util.TimeUtil;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: top.summersea.service.impl
 * @ClassName: OrderServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/7 9:10
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDaoImpl();
    }

    @Override
    public List<Object> getOrderList() {


        List<Object> orderList = orderDao.getOrderList();
        for (Object o : orderList) {
            if (o instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) o;
                map.put("createTime", TimeUtil.timeStampToTimeString((Timestamp) map.get("createTime")));
            }
        }
        return orderList;
    }


    @Override
    public List<Object> getOrderList(String goodsName, List<Boolean> hasPayed, String supplierName) {
        // 加入模糊查询语法
        goodsName = "%" + goodsName + "%";
        supplierName = "%" + supplierName + "%";

        List<Object> orderList = orderDao.getOrderList(goodsName, hasPayed, supplierName);
        for (Object o : orderList) {
            if (o instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) o;
                map.put("createTime", TimeUtil.timeStampToTimeString((Timestamp) map.get("createTime")));
            }
        }

        return orderList;
    }

    @Override
    public boolean addOrder(Map<String, Object> map) {
        map.put("createTime", TimeUtil.getCurrentTimestamp());
        return orderDao.insertOrder(map) > 0;
    }
}
