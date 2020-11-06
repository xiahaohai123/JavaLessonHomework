package hw.practice2;

/**
 * @PackageName:hw.practice2
 * @ClassName:Flower
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 13:51
 */
public class Flower {
    private String color;
    private double price;

    public Flower() {
    }

    public Flower(String color, double price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    /**
     * 显示信息
     */
    public void showInfo() {
        System.out.println("该花的颜色是" + color + "，价格是" + price + "元");
    }
}
