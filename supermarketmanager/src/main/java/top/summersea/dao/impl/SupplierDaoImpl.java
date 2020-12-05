package top.summersea.dao.impl;

import top.summersea.dao.SupplierDao;
import top.summersea.entity.Supplier;
import top.summersea.util.JDBCUtil;

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
    public List<Supplier> selectAllSupplier(String... supplierName) {
        String sql;
        List<Supplier> suppliers;
        if (supplierName.length == 0) {
            sql = "SELECT supplier_id,supplier_name, link_man, link_tel, link_address, fax, create_time, `describe` " +
                    "FROM supplier;";
            suppliers = jdbcUtil.executeQueryForList(sql, Supplier.class);
        } else {
            sql = "SELECT supplier_id,supplier_name, link_man, link_tel, link_address, fax, create_time, `describe` " +
                    "FROM supplier " +
                    "WHERE supplier_name LIKE ? ;";
            suppliers = jdbcUtil.executeQueryForList(sql, Supplier.class, supplierName[0]);
        }


        return suppliers;
    }
}
