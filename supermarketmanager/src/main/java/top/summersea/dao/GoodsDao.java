package top.summersea.dao;

import top.summersea.entity.Goods;

import java.util.List;

public interface GoodsDao {

    List<Object> selectAllGoods(String... goodsName);

    Integer SelectCountByGoodsId(String goodsId);

    Integer insertGoods(Goods goods);

    Integer updateGoods(Goods goods);
}
