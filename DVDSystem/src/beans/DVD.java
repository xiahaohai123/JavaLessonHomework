package beans;

/**
 * @PackageName:beans
 * @ClassName:DVD
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/16 11:26
 */
public class DVD {
    private static final int DEFAULT_LENDING_DAY = -1;

    //DVD名字
    private String name;
    //借出状态
    private Status status;
    //借出次数
    private int lentCount;
    //借出时长
    private int lendingTime;


    public DVD(String name) {
        this(name, 0, DEFAULT_LENDING_DAY);
    }

    public DVD(String name, int lentCount, int lendingTime) {
        this.name = name;
        if (lendingTime == DEFAULT_LENDING_DAY) {
            this.status = Status.AVAILABLE;
        } else {
            this.status = Status.LENT;
        }
        this.lentCount = lentCount;
        this.lendingTime = lendingTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(status).append("\t\t《").append(name).append("》\t").append(lendingTime == DEFAULT_LENDING_DAY ? "" : lendingTime + "日").append("\t\t\t\t").append(lentCount).append("次");
        return stringBuilder.toString();
    }

    //借出
    public boolean lend(int lendingTime) {
        //如果已借出
        if (status.isLending()) {
            return false;
        }
        //未借出才能借出
        else {
            this.lendingTime = lendingTime;
            lentCount++;
            status = Status.LENT;
            return true;
        }
    }

    //归还
    public boolean returnDVD() {
        if (status.isLending()) {
            this.lendingTime = DEFAULT_LENDING_DAY;
            status = Status.AVAILABLE;
            return true;
        } else {
            return false;
        }
    }

    public boolean isLending() {
        return status.isLending();
    }

    //借出状态
    private enum Status {
        //已借出
        LENT(true) {
            //重写，利用多态当需要toString的时候直接输出该状态
            @Override
            public String toString() {
                return "已借出";
            }
        },
        //可借
        AVAILABLE(false) {
            @Override
            public String toString() {
                return "可借";
            }
        };

        boolean lending;

        Status(boolean lending) {
            this.lending = lending;
        }

        public boolean isLending() {
            return lending;
        }

        @Override
        public String toString() {
            return "";
        }
    }
}
