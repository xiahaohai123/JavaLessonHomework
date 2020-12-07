package top.summersea.dao;

import top.summersea.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsDao {

    List<Object> selectAllGoods(String... goodsName);

    Integer SelectCountByGoodsId(String goodsId);

    Integer insertGoods(Goods goods);

    Integer updateGoods(Goods goods);

    Integer deleteGoods(String goodsId);

    Map<String, Object> selectGoodsAndSupplier(String goodsName);
}
