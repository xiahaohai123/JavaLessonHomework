package top.summersea.service;

import top.summersea.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Object> getGoodsList(String... goodsName);

    boolean isGoodsIdExistent(String goodsId);

    boolean addGoods(Goods goods);

    boolean updateGoods(Goods goods);

    boolean deleteGoods(String goodsId);

    Map<String, Object> getGoodsAndSupplier(String goodsName);
}
