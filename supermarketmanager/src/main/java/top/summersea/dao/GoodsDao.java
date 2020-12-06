package top.summersea.dao;

import java.util.List;

public interface GoodsDao {

    List<Object> selectAllGoods(String... goodsName);
}
