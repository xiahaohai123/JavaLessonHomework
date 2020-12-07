package top.summersea.service.impl;

import top.summersea.dao.SupplierDao;
import top.summersea.dao.impl.SupplierDaoImpl;
import top.summersea.entity.Supplier;
import top.summersea.service.SupplierService;
import top.summersea.util.TimeUtil;

import java.util.List;

/**
 * @PackageName: service
 * @ClassName: SupplierServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 15:22
 */
public class SupplierServiceImpl implements SupplierService {
    private SupplierDao supplierDao;

    public SupplierServiceImpl() {
        supplierDao = new SupplierDaoImpl();
    }

    @Override
    public List<Supplier> getAllSupplier(String... supplierName) {
        // 加入模糊查询语法
        if (supplierName.length != 0) {
            supplierName[0] = "%" + supplierName[0] + "%";
        }
        List<Supplier> suppliers = supplierDao.selectAllSupplier(supplierName);
        for (Supplier supplier : suppliers) {
            supplier.setCreateTimeInString(TimeUtil.dateToDateString(supplier.getCreateTime()));
        }
        return suppliers;
    }

    @Override
    public boolean isSupplierExistent(String supplierId) {
        return supplierDao.selectCountBySupplierId(supplierId) > 0;
    }

    @Override
    public boolean registerSupplier(Supplier supplier) {
        return supplierDao.insertSupplier(supplier) > 0;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return supplierDao.updateSupplier(supplier) > 0;
    }

    @Override
    public boolean deleteSupplier(String supplierId) {
        return supplierDao.deleteSupplier(supplierId) > 0;
    }

    @Override
    public List<Object> getAllSupplierName() {
        return supplierDao.selectAllSupplierName();
    }
}
