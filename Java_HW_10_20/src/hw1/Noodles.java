package hw1;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Noodles
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 13:50
 */
public class Noodles {


    // 面宽
    private Width width;
    // 尺寸
    private Size size;
    // 加肉否？
    private boolean beef;
    // 蛋数量
    private int eggs;

    public Noodles(Width width, Size size, boolean beef, int eggs) {
        this.width = width;
        this.size = size;
        this.beef = beef;
        this.eggs = eggs;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // 面宽
        stringBuilder.append(width.toString()).append('，');
        // 尺寸
        stringBuilder.append(size.toString()).append('，');
        // 加肉嘛
        stringBuilder.append(beef ? "加肉" : "不加肉").append('，');
        // 加多少个蛋
        stringBuilder.append("加").append(eggs).append("个蛋.");
        stringBuilder.append("金额是：").append(calculatePrice());
        return stringBuilder.toString();
    }

    /**
     * 计算金额
     * 尺寸对应价格 + 加肉价格 + 蛋数量*蛋价格（1元）
     *
     * @return
     */
    private int calculatePrice() {
        return size.getPrice() + (beef ? 4 : 0) + eggs;
    }

    // 宽度枚举
    public enum Width {
        FINE("细"),
        MID_FINE("中细"),
        MID("中"),
        MID_WIDE("中宽"),
        WIDE("宽");

        private final String inString;

        Width(String inString) {
            this.inString = inString;
        }

        public String getInString() {
            return inString;
        }

        @Override
        public String toString() {
            return inString;
        }
    }

    // 尺寸枚举
    public enum Size {
        BIG("大碗", 8),
        SMALL("小碗", 6);

        private final String descriptionInChinese;
        private final int price;

        Size(String descriptionInChinese, int price) {
            this.descriptionInChinese = descriptionInChinese;
            this.price = price;
        }

        @Override
        public String toString() {
            return descriptionInChinese;
        }

        public int getPrice() {
            return price;
        }

        public String getDescriptionInChinese() {
            return descriptionInChinese;
        }
    }
}
