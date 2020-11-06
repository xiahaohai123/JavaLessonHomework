package order;

import java.io.Serializable;

/**
 * @PackageName:order
 * @ClassName:Commodity
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 16:20
 */
public class Commodity implements Serializable {
    private String no;
    private String name;
    private int nums;
    private double unitPrice;

    public Commodity(String no, String name, int nums, double unitPrice) {
        this.no = no;
        this.name = name;
        this.nums = nums;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Commodity{");
        sb.append("no='").append(no).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", nums=").append(nums);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getNums() {
        return nums;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
