import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.summersea.entity.Supplier;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: TestMybatis
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/9 12:08
 */
public class TestMybatis {
    private String resource = "mybatis-config.xml";

    @Test
    public void testMybatis() {


        try (InputStream is = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = factory.openSession()) {
//                List<UserInfo> userInfoList = sqlSession.selectList("top.summersea.mapper.UserInfoMapper.getAll");
//                System.out.println(userInfoList.toString());
                List<Supplier> supplierList = sqlSession.selectList("top.summersea.mapper.SupplierMapper.selectAll");
                System.out.println(supplierList.toString());
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
                Supplier supplier = new Supplier();
                supplier.setSupplierId("TGY003");
                supplier.setSupplierName("TGY003");
                supplier.setLinkMan("TGY003Link");
                supplier.setLinkTel("14515154854");
                int insert = sqlSession.insert("top.summersea.mapper.SupplierMapper.insertSupplier", supplier);
                System.out.println("影响行数：" + insert);

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
                Supplier supplier = new Supplier();
                supplier.setSupplierId("TGY003");
                supplier.setSupplierName("TGY003");
                supplier.setLinkMan("TGY003LinkChanged");
                supplier.setLinkTel("14515154854");
                int insert = sqlSession.insert("top.summersea.mapper.SupplierMapper.updateSupplier", supplier);
                System.out.println("影响行数：" + insert);

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
                Supplier supplier = new Supplier();
                supplier.setSupplierId("TGY003");
                int insert = sqlSession.insert("top.summersea.mapper.SupplierMapper.deleteSupplier", supplier);
                System.out.println("影响行数：" + insert);

                // 提交
                sqlSession.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
