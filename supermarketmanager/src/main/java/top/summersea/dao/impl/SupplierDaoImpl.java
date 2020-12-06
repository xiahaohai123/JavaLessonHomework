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


    @Override
    public Integer selectCountBySupplierId(String supplierId) {
        String sql = "SELECT COUNT(1) FROM supplier WHERE supplier_id = ?";
        return jdbcUtil.executeQueryForCount(sql, supplierId);
    }

    @Override
    public Integer insertSupplier(Supplier supplier) {
        String sql = "INSERT INTO supplier VALUES(?,?,?,?,?,?,?,?);";
        Object[] objects = {supplier.getSupplierId(), supplier.getSupplierName(),
                supplier.getLinkMan(), supplier.getLinkTel(), supplier.getLinkAddress(),
                supplier.getFax(), supplier.getCreateTime(), supplier.getDescribe()};
        return jdbcUtil.executeUpdate(sql, objects);
    }

    @Override
    public Integer updateSupplier(Supplier supplier) {
        String sql = "UPDATE supplier SET " +
                "supplier_name = ?, " +
                "link_man = ?, " +
                "link_tel = ?, " +
                "link_address = ?, " +
                "fax = ?, " +
                "create_time = ?," +
                "`describe` = ? " +
                "WHERE supplier_id = ?";
        Object[] objects = {supplier.getSupplierName(), supplier.getLinkMan(),
                supplier.getLinkTel(), supplier.getLinkAddress(), supplier.getFax(),
                supplier.getCreateTime(), supplier.getDescribe(), supplier.getSupplierId()};
        return jdbcUtil.executeUpdate(sql, objects);
    }

    @Override
    public Integer deleteSupplier(String supplierId) {
        String sql = "DELETE FROM supplier WHERE supplier_id = ?;";
        return jdbcUtil.executeUpdate(sql, supplierId);
    }
}
