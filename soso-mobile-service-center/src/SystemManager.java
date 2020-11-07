import entity.MobileCard;
import service.SystemService;
import service.SystemServiceImpl;
import utils.CardUtil;
import utils.ScannerUtil;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SystemManager
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 14:35
 */
public class SystemManager {
    private ScannerUtil scannerUtil;
    private SystemService systemService;

    /**
     * 初始化基础数据
     */
    public SystemManager() {
        scannerUtil = new ScannerUtil(System.in);
        systemService = new SystemServiceImpl();
    }


    public void run() {

        boolean runningFlag = true;
        while (runningFlag) {
            // 显示主菜单
            showMainMenu();
            System.out.print("请输入对应序号使用相应功能：");
            // 读取输入
            int input = scannerUtil.getNumInSection(1, 7);
            switch (input) {
                case 1:
                    // 用户登录
                    loginModule();
                    break;
                case 2:
                    // 用户注册
                    registerModule();
                    break;
                case 3:
                    System.out.println("使用嗖嗖");
                    break;
                case 4:
                    System.out.println("话费充值");
                    break;
                case 5:
                    System.out.println("资费说明");
                    break;
                case 6:
                    System.out.println("退出系统");
                    runningFlag = false;
                    break;
            }
        }
        beforeDestroyed();
    }

    private void showMainMenu() {
        System.out.println("*****************欢迎使用嗖嗖移动业务大厅*****************" +
                "\n1、用户登录\t2、用户注册\t3、使用嗖嗖\t4、话费充值\t5、资费说明\t6、退出系统\n");
    }

    /**
     * 程序关闭前
     */
    private void beforeDestroyed() {
        scannerUtil.close();
    }

    /**
     * 注册模组
     */
    private void registerModule() {
        // 获取号码数组
        String[] numArray = CardUtil.getCardNumList("139", 10);
        StringBuilder sb = new StringBuilder();
        // 输出格式
        for (int i = 0; i < numArray.length; i++) {
            if (i % 5 == 0) {
                sb.append('\n');
            }
            sb.append(i + 1).append('、').append(numArray[i]).append('\t');
        }
        sb.append("\n请选择一个号码：");
        System.out.print(sb);

        while (true) {
            int targetIndex = scannerUtil.getNumInSection(1, 10) - 1;
            // 号码已注册
            if (systemService.isExist(numArray[targetIndex])) {
                System.out.println("您要选的号码已被注册，请重新选择");
                continue;
            }
            // 姓名
            System.out.print("请输入姓名：");
            String name = scannerUtil.nextString();
            // 密码
            System.out.print("请输入密码：");
            String password = scannerUtil.nextString();

            MobileCard card = new MobileCard(numArray[targetIndex], name, password);
            if (systemService.registerMobileCard(card)) {
                System.out.println("注册成功！");
                break;
            } else {
                System.out.println("注册失败，请重试！");
            }
        }

    }

    /**
     * 登录模组
     */
    private void loginModule() {
        System.out.print("请输入卡号：");
        String cardNumber = scannerUtil.nextString();
        System.out.print("请输入密码：");
        String password = scannerUtil.nextString();

        // 登录操作
        MobileCard card = systemService.login(cardNumber, password);
        if (card == null) {
            // 登录失败
            System.out.println("您输入的卡号或密码错误，登录失败...");
        } else {
            // 登录成功
            System.out.println("登录成功！");
            System.out.println("您好！用户" + card.getUsername());
            // 登录标志
            boolean loginFlag = true;

            while (loginFlag) {
                showUserMenu();
                switch (scannerUtil.getNumInSection(1, 7)) {
                    case 1:
                        System.out.println("本月账单查询");
                        System.out.println(systemService.lookupBillCurMonth(card));
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("套餐余量查询");
                        System.out.println(systemService.lookupMealAllowance(card));
                        break;
                    case 3:
                        System.out.println("打印消费详单");
                        break;
                    case 4:
                        System.out.println("套餐变更");
                        break;
                    case 5:
                        System.out.println("办理退网");
                        break;
                    case 6:
                        loginFlag = false;
                        System.out.println(card.getCardNumber() + " 退出登录");
                        break;
                }
            }
        }
    }

    /**
     * 用户菜单
     */
    private void showUserMenu() {
        System.out.println("******嗖嗖移动用户菜单******\n" +
                "1.本月账单查询\n" +
                "2.套餐余量查询\n" +
                "3.打印消费详单\n" +
                "4.套餐变更\n" +
                "5.办理退网\n" +
                "6.退出登录\n");
    }
}
