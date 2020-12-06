package top.summersea.dao.impl;

import top.summersea.dao.GoodsDao;
import top.summersea.entity.Goods;
import top.summersea.util.JDBCUtil;

import java.util.List;

/**
 * @PackageName: top.summersea.dao.impl
 * @ClassName: GoodsDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/6 17:10
 */
public class GoodsDaoImpl implements GoodsDao {
    private JDBCUtil jdbcUtil;

    public GoodsDaoImpl() {
        jdbcUtil = JDBCUtil.getInstance();
    }

    @Override
    public Integer SelectCountByGoodsId(String goodsId) {
        String sql = "SELECT COUNT(1) FROM goods WHERE goods_id = ?";
        return jdbcUtil.executeQueryForCount(sql, goodsId);
    }

    @Override
    public List<Object> selectAllGoods(String... goodsName) {
        String sql;
        if (goodsName.length == 0) {
            sql = "SELECT " +
                    "goods_id, " +
                    "goods_name, " +
                    "goods_price, " +
                    "unit, " +
                    "g.supplier_id, " +
                    "supplier_name, " +
                    "link_tel,  " +
                    "stock " +
                    "FROM goods g LEFT JOIN supplier s ON g.supplier_id = s.supplier_id;";
            return jdbcUtil.executeAssociationQueryForList(sql);
        } else {
            sql = "SELECT " +
                    "goods_id, " +
                    "goods_name, " +
                    "goods_price, " +
                    "unit, " +
                    "g.supplier_id, " +
                    "supplier_name, " +
                    "link_tel,  " +
                    "stock " +
                    "FROM goods g LEFT JOIN supplier s ON g.supplier_id = s.supplier_id " +
                    "WHERE goods_name LIKE ?";
            return jdbcUtil.executeAssociationQueryForList(sql, goodsName[0]);
        }
    }

    @Override
    public Integer insertGoods(Goods goods) {
        String sql = "INSERT INTO goods VALUES(?,?,?,?,?,?);";
        Object[] objects = {goods.getGoodsId(), goods.getGoodsName(), goods.getGoodsPrice(),
                goods.getUnit(), goods.getSupplierId(), goods.getStock()};
        return jdbcUtil.executeUpdate(sql, objects);
    }

    @Override
    public Integer updateGoods(Goods goods) {
        String sql = "UPDATE goods SET " +
                "goods_name = ?, " +
                "goods_price = ?, " +
                "unit = ?, " +
                "supplier_id = ?, " +
                "stock = ? " +
                "WHERE goods_id = ?;";
        Object[] objects = {goods.getGoodsName(), goods.getGoodsPrice(),
                goods.getUnit(), goods.getSupplierId(), goods.getStock(),
                goods.getGoodsId()};
        return jdbcUtil.executeUpdate(sql, objects);
    }
}
