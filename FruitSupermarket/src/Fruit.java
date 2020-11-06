/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Fruit
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 16:13
 */
public class Fruit {
    // 名称
    private String name;
    // 价格
    private double price;
    // 库存
    private int inventory;
    // 备注
    private String remark;

    public Fruit(String name, double price, int inventory, String remark) throws AbnormalInventoryNumberException, AbnormalPriceException {
        this.name = name;
        setPrice(price);
        setInventory(inventory);
        this.remark = remark;
    }

    public static String getInfoHead() {
        return "名称\t\t\t价格\t\t库存量\t\t备注";
    }

    public void setPrice(double price) throws AbnormalPriceException {
        if (price > 0) {
            this.price = price;
        } else {
            throw new AbnormalPriceException();
        }
    }

    public void setInventory(int inventory) throws AbnormalInventoryNumberException {
        if (inventory > 0) {
            this.inventory = inventory;
        } else {
            throw new AbnormalInventoryNumberException();
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "\t\t\t" +
                price + "\t\t\t" +
                inventory + "\t\t\t" +
                remark;
    }

    public String getInfoCompleted() {
        return getInfoHead() + '\n' + toString();
    }

    public class AbnormalInventoryNumberException extends RuntimeException {
        @Override
        public String getMessage() {
            return "库存量必须为正数";
        }
    }

    public class AbnormalPriceException extends RuntimeException {
        @Override
        public String getMessage() {
            return "价格必须为正数";
        }
    }
}
