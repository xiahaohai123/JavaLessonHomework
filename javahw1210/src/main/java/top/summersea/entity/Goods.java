package top.summersea.entity;

import java.util.StringJoiner;

/**
 * @PackageName: entity
 * @ClassName: Goods
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 14:40
 */
public class Goods {
    private String goodsId;
    private String goodsName;
    private Double goodsPrice;
    private String unit;
    private String supplierId;
    private Integer stock;

    private Supplier supplier;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = "".equals(goodsId) ? null : goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = "".equals(goodsName) ? null : goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = "".equals(unit) ? null : unit;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = "".equals(supplierId) ? null : supplierId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Goods.class.getSimpleName() + "[", "]")
                .add("goodsId='" + goodsId + "'")
                .add("goodsName='" + goodsName + "'")
                .add("goodsPrice=" + goodsPrice)
                .add("unit='" + unit + "'")
                .add("supplierId='" + supplierId + "'")
                .add("stock=" + stock)
                .add("supplier=" + supplier)
                .toString();
    }
}
