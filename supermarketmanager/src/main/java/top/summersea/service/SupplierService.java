package top.summersea.service;

import top.summersea.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSupplier(String... supplierName);

    boolean isSupplierExistent(String supplierId);

    boolean registerSupplier(Supplier supplier);

    boolean updateSupplier(Supplier supplier);

    boolean deleteSupplier(String supplierId);

    List<Object> getAllSupplierName();
}
