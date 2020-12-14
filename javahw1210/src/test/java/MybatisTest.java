import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.summersea.entity.Order;
import top.summersea.entity.Supplier;
import top.summersea.mapper.OrderMapper;
import top.summersea.mapper.SupplierMapper;
import top.summersea.util.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: MybatisTest
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/10 15:04
 */
public class MybatisTest {
    @Test
    public void mapTest() {
        //1.获得会话对象
        SqlSession session = MybatisUtil.getSession();

        //2.接口对象
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("goodsName", "%奶%");
        parameterMap.put("supplierId", "GY0003");
        parameterMap.put("pay", true);
        List<Map> list = mapper.selectOrderByGoodsNameAndSupplierIdAndPayInMap(parameterMap);
//        for (Classes cl : list) {
////            System.out.println(cl);
//            System.out.println(cl.getTeacher());
//        }

        System.out.println(list);

        //3.关闭会话
        MybatisUtil.closeSession(session);

    }

    @Test
    public void resultMapOrderShowTest() {
        //1.获得会话对象
        SqlSession session = MybatisUtil.getSession();

        //2.接口对象
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("goodsName", "%奶%");
        parameterMap.put("supplierId", "GY0003");
        parameterMap.put("pay", true);
        List<Order> list = mapper.selectOrderByGoodsNameAndSupplierIdAndPayInOrder(parameterMap);

        for (Order order : list) {
            System.out.println(order);
        }

        //3.关闭会话
        MybatisUtil.closeSession(session);

    }

    @Test
    public void practice2() {
        //1.获得会话对象
        SqlSession session = MybatisUtil.getSession();

        //2.接口对象
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("goodsName", "%奶%");
        parameterMap.put("supplierId", "GY0003");
        parameterMap.put("pay", true);
        List<Order> list = mapper.selectOrderByGoodsNameAndSupplierIdAndPayInOrderByPractice2(parameterMap);

        for (Order order : list) {
            System.out.println(order);
        }

        //3.关闭会话
        MybatisUtil.closeSession(session);

    }

    @Test
    public void practice3() {
        //1.获得会话对象
        SqlSession session = MybatisUtil.getSession();

        //2.接口对象
        SupplierMapper mapper = session.getMapper(SupplierMapper.class);
        Supplier supplier = mapper.practice3("GY0003");

        System.out.println(supplier);

        //3.关闭会话
        MybatisUtil.closeSession(session);

    }
}
