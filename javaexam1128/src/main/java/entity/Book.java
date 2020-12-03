package entity;

import java.math.BigDecimal;

/**
 * @PackageName: entity
 * @ClassName: Book
 * @Description: description book实体类
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/28 9:26
 */
public class Book {
    private int bid;
    private String bookName;
    private String bPrice;
    private String image;
    // 现货
    private BigDecimal stock;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getbPrice() {
        return bPrice;
    }

    public void setbPrice(String bPrice) {
        this.bPrice = bPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
