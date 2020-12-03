package top.summersea.dao.impl;

import top.summersea.dao.SupplierDao;
import top.summersea.entity.Supplier;
import top.summersea.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: dao
 * @ClassName: SupplierDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 15:15
 */
public class SupplierDaoImpl implements SupplierDao {
    private JDBCUtil jdbcUtil;

    public SupplierDaoImpl() {
        jdbcUtil = JDBCUtil.getInstance();
    }

    @Override
    public List<Supplier> selectAllSupplier() {
        String sql = "SELECT supplier_id,supplier_name, link_man, link_tel, link_address, fax, create_time, `describe`" +
                "FROM supplier;";
        ResultSet resultSet = jdbcUtil.executeQuery(sql);

        List<Supplier> resList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                // 拼装Supplier对象
                Supplier supplier = new Supplier();
                supplier.setSupplierId(resultSet.getString("supplier_id"));
                supplier.setSupplierName(resultSet.getString("supplier_name"));
                supplier.setLinkMan(resultSet.getString("link_man"));
                supplier.setLinkTel(resultSet.getString("link_tel"));
                supplier.setLinkAddress(resultSet.getString("link_address"));
                supplier.setFax(resultSet.getString("fax"));
                supplier.setCreateTime(resultSet.getDate("create_time"));
                supplier.setDescribe(resultSet.getString("describe"));

                resList.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resList;
    }
}
