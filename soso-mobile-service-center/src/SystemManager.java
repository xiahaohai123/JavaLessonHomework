import entity.MobileCard;
import entity.service_package.ServicePackage;
import factory.ServicePackageFactory;
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
            int input = scannerUtil.nextNumInSection(0, 4);
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
                    System.out.println("\n*****资费说明*****");
                    System.out.println(systemService.getExpensesDescription());
                    break;
                case 0:
                    System.out.println("退出系统");
                    runningFlag = false;
                    break;
            }
        }
        beforeDestroyed();
    }

    private void showMainMenu() {
        System.out.println("*****************欢迎使用嗖嗖移动业务大厅*****************" +
                "\n1、用户登录\t2、用户注册\t3、资费说明\t0、退出系统\n");
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
            int targetIndex = scannerUtil.nextNumInSection(1, 10) - 1;
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
                System.out.print("请输入序号以进行对应操作：");
                switch (scannerUtil.nextNumInSection(0, 8)) {
                    case 1:
                        // 查询月度账单
                        System.out.println("*****本月账单查询*****");
                        System.out.println(systemService.lookupBillCurMonth(card));
                        System.out.println();
                        break;
                    case 2:
                        // 查询套餐余量
                        System.out.println("*****套餐余量查询*****");
                        System.out.println(systemService.lookupMealAllowance(card));
                        break;
                    case 3:
                        // 查询消费详单
                        System.out.println("*****消费详单查询*****");
                        System.out.println(systemService.getConsumptionInfoList(card));
                        break;
                    case 4:
                        // 套餐变更
                        changeMenuModule(card);
                        break;
                    case 5:
                        // 办理退网
                        System.out.println("退网...");
                        if (systemService.withdrawFromTheNet(card)) {
                            System.out.println("退网成功");
                            // 退出登录
                            loginFlag = false;
                        } else {
                            System.out.println("退网失败");
                        }
                        break;
                    case 6:
                        System.out.println("*****使用嗖嗖*****");
                        System.out.println(systemService.useSoSo(card));
                        break;
                    case 7:
                        System.out.println("*****话费充值*****");
                        chargeMoneyModule(card);
                        break;
                    case 0:
                        loginFlag = false;
                        System.out.println(card.getCardNumber() + " 退出登录");
                        break;
                }
            }
        }
    }

    /**
     * 变更套餐模块
     *
     * @param card 目标用户
     */
    private void changeMenuModule(MobileCard card) {
        System.out.println("*****套餐资费说明*****");
        System.out.println(systemService.getExpensesDescription());
        System.out.println("请选择您需要的套餐：\n" +
                "\t1.超人套餐\n" +
                "\t2.网虫套餐\n" +
                "\t3.话唠套餐\n");

        int input = scannerUtil.nextNumInSection(1, 4);
        ServicePackage nextServicePackage = null;
        switch (input) {
            case 1:
                nextServicePackage = ServicePackageFactory.getServicePackage("超人套餐");
                break;
            case 2:
                nextServicePackage = ServicePackageFactory.getServicePackage("网虫套餐");
                break;
            case 3:
                nextServicePackage = ServicePackageFactory.getServicePackage("话唠套餐");
                break;
        }

        if (nextServicePackage == null) {
            System.out.println("套餐变更失败！");
        } else {
            // 变更次月套餐
            systemService.changeNextMenu(card, nextServicePackage);
            System.out.println("您选择的套餐：" +
                    nextServicePackage.getSelectString() +
                    "\n套餐变更成功，次月生效!");
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
                "6.使用嗖嗖\n" +
                "7.话费充值\n" +
                "0.退出登录\n");
    }

    /**
     * 话费充值模块
     */
    private void chargeMoneyModule(MobileCard card) {
        System.out.print("请输入要充值的费用：");
        if (systemService.chargeCard(card, scannerUtil.nextNumInSection(10, Integer.MAX_VALUE))) {
            System.out.println("话费充值成功");
        } else {
            System.out.println("充值失败");
        }
    }
}
