package top.summersea.entity;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * @PackageName: entity
 * @ClassName: Supplier
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 14:53
 */
public class Supplier {
    private String supplierId;
    private String supplierName;
    private String linkMan;
    private String linkTel;
    private String linkAddress;
    private String fax;
    private String describe;
    private Date createTime;
    private String createTimeInString;

    private List<Order> orderList;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {

        this.supplierId = "".equals(supplierId) ? null : supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = "".equals(supplierName) ? null : supplierName;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = "".equals(linkMan) ? null : linkMan;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = "".equals(linkTel) ? null : linkTel;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = "".equals(linkAddress) ? null : linkAddress;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = "".equals(fax) ? null : fax;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = "".equals(describe) ? null : describe;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeInString() {
        return createTimeInString;
    }

    public void setCreateTimeInString(String createTimeInString) {
        this.createTimeInString = "".equals(createTimeInString) ? null : createTimeInString;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Supplier.class.getSimpleName() + "[", "]")
                .add("supplierId='" + supplierId + "'")
                .add("supplierName='" + supplierName + "'")
                .add("linkMan='" + linkMan + "'")
                .add("linkTel='" + linkTel + "'")
                .add("linkAddress='" + linkAddress + "'")
                .add("fax='" + fax + "'")
                .add("describe='" + describe + "'")
                .add("createTime=" + createTime)
                .add("createTimeInString='" + createTimeInString + "'")
                .add("orderList=" + orderList)
                .toString();
    }
}
