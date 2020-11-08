package factory;

import entity.service_package.NetPackage;
import entity.service_package.ServicePackage;
import entity.service_package.SuperPackage;
import entity.service_package.TalkPackage;

/**
 * @PackageName: factory
 * @ClassName: ServicePackageFactory
 * @Description: 工厂类
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/6 20:45
 */
public class ServicePackageFactory {
    public static ServicePackage getServicePackage(String serviceString) {
        if ("网虫套餐".equals(serviceString)) {
            return new NetPackage(68, 0.2, 0.1, 0.1, 5 * 1024);
        } else if ("超人套餐".equals(serviceString)) {
            return new SuperPackage(78, 0.2, 0.1, 0.1, 200, 100, 1024);
        } else if ("话唠套餐".equals(serviceString)) {
            return new TalkPackage(58, 0.2, 0.1, 0.1, 200, 50);
        } else {
            return null;
        }
    }
}
