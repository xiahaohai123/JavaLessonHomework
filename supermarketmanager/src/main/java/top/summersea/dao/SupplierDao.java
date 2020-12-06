package top.summersea.dao;

import top.summersea.entity.Supplier;

import java.util.List;

public interface SupplierDao {
    /**
     * 获取所有的供应商信息
     * 支持模糊查询
     *
     * @param supplierName 模糊查询参数
     * @return
     */
    List<Supplier> selectAllSupplier(String... supplierName);

    Integer selectCountBySupplierId(String supplierId);

    Integer insertSupplier(Supplier supplier);

    Integer updateSupplier(Supplier supplier);

    Integer deleteSupplier(String supplierId);
}
