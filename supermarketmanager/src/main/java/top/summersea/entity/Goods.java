package top.summersea.entity;

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

    public void setGoodsId(String goodsId) {
        this.goodsId = "".equals(goodsId) ? null : goodsId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = "".equals(goodsName) ? null : goodsName;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setUnit(String unit) {
        this.unit = "".equals(unit) ? null : unit;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = "".equals(supplierId) ? null : supplierId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public String getUnit() {
        return unit;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock =stock;
    }
}
