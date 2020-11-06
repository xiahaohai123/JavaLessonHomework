package hw.practice2;

/**
 * @PackageName:hw.practice2
 * @ClassName:Rose
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/22 13:53
 */
public class Rose extends Flower {
    // 产地
    private String placeOfOrigin;

    public Rose(String color, double price, String placeOfOrigin) {
        super(color, price);
        this.placeOfOrigin = placeOfOrigin;
    }

    /**
     * 显示玫瑰花的信息
     */
    @Override
    public void showInfo() {
        System.out.println("玫瑰");
        showPlaceOfOrigin();
        super.showInfo();
    }

    /**
     * 显示产地信息
     */
    public void showPlaceOfOrigin() {
        System.out.println("产地是" + placeOfOrigin);
    }

    /**
     * 警告
     */
    public void warn() {
        System.out.println("不要摘玫瑰花，小心扎手！");
    }

}
