package top.summersea.service;

import top.summersea.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSupplier(String... supplierName);
}
