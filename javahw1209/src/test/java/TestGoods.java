import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.summersea.entity.Goods;
import top.summersea.mapper.GoodsMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: TestGoods
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/9 16:12
 */
public class TestGoods {
    private String resource = "mybatis-config.xml";

    @Test
    public void testSelect() {

        try (InputStream is = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = factory.openSession()) {
                GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
                System.out.println(mapper.selectAll().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {

        try (InputStream is = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = factory.openSession()) {
                Goods goods = new Goods();
                goods.setGoodsId("Test02");
                goods.setGoodsName("test02");
                goods.setGoodsPrice(10D);
                goods.setUnit("听");
                goods.setSupplierId("GY0001");
                goods.setStock(30);
                GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
                Integer integer = mapper.insertGoods(goods);
                System.out.println("影响行数：" + integer);

                // 提交
                sqlSession.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {

        try (InputStream is = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = factory.openSession()) {
                Goods goods = new Goods();
                goods.setGoodsId("Test02");
                goods.setGoodsName("test02改");
                goods.setGoodsPrice(10D);
                goods.setUnit("听");
                goods.setSupplierId("GY0001");
                goods.setStock(30);
                GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
                Integer integer = mapper.updateGoods(goods);
                System.out.println("影响行数：" + integer);

                // 提交
                sqlSession.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {

        try (InputStream is = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = factory.openSession()) {
                Goods goods = new Goods();
                goods.setGoodsId("Test02");
                GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
                Integer integer = mapper.deleteGoods(goods);
                System.out.println("影响行数：" + integer);

                // 提交
                sqlSession.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
