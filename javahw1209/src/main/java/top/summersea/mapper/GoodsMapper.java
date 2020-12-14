package top.summersea.mapper;

import top.summersea.entity.Goods;

import java.util.List;

/**
 * @PackageName: top.summersea.mapper
 * @ClassName: GoodsMapper
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/9 16:03
 */
public interface GoodsMapper {

    List<Goods> selectAll();

    Integer insertGoods(Goods goods);

    Integer updateGoods(Goods goods);

    Integer deleteGoods(Goods goods);
}
