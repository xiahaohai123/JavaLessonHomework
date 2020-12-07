package top.summersea.dao.impl;

import top.summersea.dao.OrderDao;
import top.summersea.entity.Order;
import top.summersea.util.JDBCUtil;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: top.summersea.dao.impl
 * @ClassName: OrderDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/7 9:09
 */
public class OrderDaoImpl implements OrderDao {
    private JDBCUtil jdbcUtil;

    public OrderDaoImpl() {
        jdbcUtil = JDBCUtil.getInstance();
    }

    @Override
    public List<Object> getOrderList() {
        String sql;
        List<Object> objects;
        sql = "SELECT order_id, count, total, pay, o.create_time, " +
                "g.goods_name, s.supplier_name, " +
                "g.unit " +
                "FROM `order` o LEFT JOIN goods g ON o.goods_id = g.goods_id " +
                "LEFT JOIN supplier s ON g.supplier_id = s.supplier_id;";
        objects = jdbcUtil.executeAssociationQueryForList(sql);


        return objects;
    }

    @Override
    public List<Object> getOrderList(String goodsName, List<Boolean> hasPayed, String supplierName) {
        String sql;
        List<Object> objects;
        if (hasPayed == null) {
            sql = "SELECT " +
                    "order_id, count, total, pay, o.create_time, " +
                    "g.goods_name, s.supplier_name, " +
                    "g.unit " +
                    "FROM `order` o INNER JOIN goods g " +
                    "ON o.goods_id = g.goods_id AND goods_name LIKE ? " +
                    "INNER JOIN supplier s " +
                    "ON g.supplier_id = s.supplier_id AND supplier_name LIKE ?;";
            objects = jdbcUtil.executeAssociationQueryForList(sql, goodsName, supplierName);
        } else {
            sql = "SELECT " +
                    "order_id, count, total, pay, o.create_time, " +
                    "g.goods_name, s.supplier_name, " +
                    "g.unit " +
                    "FROM `order` o INNER JOIN goods g " +
                    "ON o.goods_id = g.goods_id AND goods_name LIKE ? AND pay = ? " +
                    "INNER JOIN supplier s " +
                    "ON g.supplier_id = s.supplier_id AND supplier_name LIKE ?;";
            objects = jdbcUtil.executeAssociationQueryForList(sql, goodsName, hasPayed.get(0), supplierName);
        }


        return objects;
    }

    @Override
    public Integer updateOrder(Order order) {
        String sql = "UPDATE `order` " +
                "SET " +
                "pay = ? " +
                "WHERE order_id = ?";
        return jdbcUtil.executeUpdate(sql, order.getPay(), order.getOrderId());
    }

    @Override
    public Integer insertOrder(Map<String, Object> map) {
        String sql = "INSERT INTO `order` " +
                "VALUES(" +
                "?, " +
                "(" +
                "SELECT goods_id FROM goods WHERE goods_name = ?" +
                ")" +
                ", ?, ?, ?, ?" +
                ");";
        Object[] objects = {map.get("orderId"), map.get("goodsName"),
                map.get("count"), map.get("total"), map.get("pay"), map.get("createTime")};
        return jdbcUtil.executeUpdate(sql, objects);


    }
}
