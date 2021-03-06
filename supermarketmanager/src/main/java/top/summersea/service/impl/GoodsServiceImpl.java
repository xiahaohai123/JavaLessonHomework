package top.summersea.service.impl;

import top.summersea.dao.GoodsDao;
import top.summersea.dao.impl.GoodsDaoImpl;
import top.summersea.entity.Goods;
import top.summersea.service.GoodsService;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: top.summersea.service.impl
 * @ClassName: GoodsServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/6 17:11
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao;

    public GoodsServiceImpl() {
        goodsDao = new GoodsDaoImpl();
    }

    @Override
    public List<Object> getGoodsList(String... goodsName) {
        if (goodsName.length != 0) {
            goodsName[0] = "%" + goodsName[0] + "%";
        }

        return goodsDao.selectAllGoods(goodsName);
    }

    @Override
    public boolean isGoodsIdExistent(String goodsId) {
        return goodsDao.SelectCountByGoodsId(goodsId) > 0;
    }

    @Override
    public boolean addGoods(Goods goods) {
        return goodsDao.insertGoods(goods) > 0;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods) > 0;
    }

    @Override
    public boolean deleteGoods(String goodsId) {
        return goodsDao.deleteGoods(goodsId) > 0;
    }

    @Override
    public Map<String, Object> getGoodsAndSupplier(String goodsName) {
        return goodsDao.selectGoodsAndSupplier(goodsName);
    }



}
