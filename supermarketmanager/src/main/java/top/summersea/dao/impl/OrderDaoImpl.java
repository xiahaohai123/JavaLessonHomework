package top.summersea.dao.impl;

import top.summersea.dao.OrderDao;
import top.summersea.util.JDBCUtil;

import java.util.List;

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
}
