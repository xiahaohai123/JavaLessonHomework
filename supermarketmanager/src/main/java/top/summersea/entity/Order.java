package top.summersea.entity;

import java.util.Date;

/**
 * @PackageName: entity
 * @ClassName: Order
 * @Description: description 订单实体类l
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 14:51
 */
public class Order {
    private String orderId;
    private String goodId;
    private Integer count;
    private Double total;
    private Boolean pay;
    private Date createTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = "".equals(orderId) ? null : orderId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = "".equals(goodId) ? null : goodId;

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    public Boolean getPay() {
        return pay;
    }

    public void setPay(Boolean pay) {
        this.pay = pay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
