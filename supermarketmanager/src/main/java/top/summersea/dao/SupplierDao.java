package top.summersea.dao;

import top.summersea.entity.Supplier;

import java.util.List;

public interface SupplierDao {
    List<Supplier> selectAllSupplier(String... supplierName);
}
