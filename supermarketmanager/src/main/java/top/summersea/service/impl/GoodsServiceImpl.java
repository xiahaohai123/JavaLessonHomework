package top.summersea.service.impl;

import top.summersea.dao.GoodsDao;
import top.summersea.dao.impl.GoodsDaoImpl;
import top.summersea.service.GoodsService;

import java.util.List;

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
}
