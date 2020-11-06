import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Supermarket
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 16:15
 */
public class Supermarket {
    private FruitService fruitService;
    private Scanner scanner;

    public Supermarket() {
        this.fruitService = new FruitServiceImpl();
        this.scanner = new Scanner(System.in);
    }


    public void run() {

        boolean running = true;
        int input = 0;

        do {
            // 显示菜单
            showMenu();
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                // 触发异常
                System.out.println("输入的类型不正确，请重新输入");
                // 读掉缓冲区
                scanner.nextLine();
                // 循环从头起步
                continue;
            }
            // 对输入值进行判断
            switch (input) {
                case 1:
                    System.out.println(fruitService.getDisplayString());
                    break;
                case 2:
                    addFruitMode();
                    break;
                case 3:
                    lookupFruitMode();
                    break;
                case 4:
                    offShelfMode();
                    break;
                case 5:
                    System.out.println(fruitService.getDisplayStringOrderByAsc());
                    break;
                case 6:
                    System.out.println("请确认是否退出（Y/N）");
                    String checkInput = scanner.next();
                    if ("y".equalsIgnoreCase(checkInput) || "yes".equalsIgnoreCase(checkInput)) {
                        running = false;
                    } else {
                        System.out.println("不退出");
                    }
                    break;
                default:
                    System.out.println("输入的值不正确，请重新输入！");
                    break;
            }
        } while (running);

        // 退出系统
        destroy();
    }

    /**
     * 显示菜单
     */
    private void showMenu() {
        System.out.print("===================================\n" +
                "1.展示所有水果的信息\n" +
                "2.添加水果信息\n" +
                "3.查看特定水果信息\n" +
                "4.水果下架\n" +
                "5.按照价格升序展示\n" +
                "6.退出\n" +
                "===================================\n" +
                "请选择：");
    }

    /**
     * 添加水果模组
     */
    private void addFruitMode() {
        System.out.print("请输入名称：");
        String name = scanner.next();
        // 检查是否已存在的水果
        if (fruitService.contains(name)) {
            // 进入修改模块
            modifyFruitMode(name);
        } else {
            addNewFruitMode(name);
        }
        System.out.println("添加成功");
    }

    /**
     * 修改水果库存量的模块
     *
     * @param name 水果名字
     */
    private void modifyFruitMode(String name) {
        System.out.print("请输入库存量：");
        while (true) {
            // 库存量
            try {
                int inventory = scanner.nextInt();
                fruitService.modifyInventory(name, inventory);
                break;
            } catch (InputMismatchException e) {
                // 吃掉缓冲区
                scanner.nextLine();
                System.out.println("请输入数字");
                System.out.print("请重新输入：");
            } catch (Fruit.AbnormalInventoryNumberException e) {
                System.out.println(e.getMessage());
                System.out.print("请重新输入：");
            }
        }
    }

    /**
     * 加入新的水果的模组l
     *
     * @param name
     */
    private void addNewFruitMode(String name) {
        while (true) {
            try {
                System.out.print("请输入价格：");
                double price = scanner.nextDouble();
                System.out.print("请输入库存量：");
                int inventoryNum = scanner.nextInt();
                System.out.print("请输入备注：");
                String remark = scanner.next();
                // 可能发生非正常库存量和价格的异常
                fruitService.addFruit(name, price, inventoryNum, remark);
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("请输入正确的数据类型");
                System.out.print("请重新输入：");
            } catch (Fruit.AbnormalInventoryNumberException e) {
                System.out.println(e.getMessage());
                System.out.println("请重新输入：");
            } catch (Fruit.AbnormalPriceException e) {
                System.out.println(e.getMessage());
                System.out.println("请重新输入：");
            }
        }
    }

    /**
     * 查看水果特定信息的模组
     */
    private void lookupFruitMode() {
        System.out.print("请输入名称：");
        String name = scanner.next();

        String info = fruitService.getLookUpFruitString(name);
        if (info != null) {
            System.out.println(info);
        } else {
            System.out.println("对不起，没有找到你需要查询的水果信息！");
        }
    }

    /**
     * 下架水果的模组
     */
    private void offShelfMode() {
        System.out.print("请输入名称：");
        String name = scanner.next();
        Fruit fruit;
        if (fruitService.contains(name)) {
            // 打印对应水果的信息
            System.out.println(fruitService.getLookUpFruitString(name));

            // 判断是否真的要删
            System.out.print("是否确认下架？（y/n）：");
            String checkInput = scanner.next();
            if ("y".equalsIgnoreCase(checkInput) || "yes".equalsIgnoreCase(checkInput)) {
                // 删除对应元素
                fruitService.deleteFruit(name);
            }
        } else {
            System.out.println("对不起，没有找到你需要查询的水果信息！");
        }
    }


    private void destroy() {
        System.out.println("商店关闭");
        scanner.close();
    }
}
