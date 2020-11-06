import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:AnimalManager
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/24 17:11
 */
public class AnimalManager {
    Animal[] animals;

    public AnimalManager() {
        initValue();
    }

    /**
     * 初始化数据
     */
    private void initValue() {
        Cat cat = new Cat("加菲猫", 4);
        Duck duck = new Duck("唐小鸭", 2);
        Dolphin dolphin = new Dolphin("海豚琪琪");
        // 动物数组
        animals = new Animal[3];
        // 填充
        animals[0] = cat;
        animals[1] = duck;
        animals[2] = dolphin;
    }

    // 叫 和腿的条数
    private void showInfo() {

        System.out.println("序号\t动物名字\t\t\t\t腿的条数\t\t\t动物叫");
        for (int i = 0; i < animals.length; i++) {
            System.out.print((i + 1) + "\t\t" + animals[i].getName() + "\t\t\t\t\t");
            // 根据遍历的对象是不是实现了陆生动物接口来判断输出腿的数量
            if (animals[i] instanceof Terrestrial) {
                System.out.print(((Terrestrial) animals[i]).getLegNum() + "\t\t\t\t\t");
            } else {
                // 非陆生动物0条腿
                System.out.print("0\t\t\t\t\t");
            }
            // 动物叫
            animals[i].shout();
        }
    }

    // 修改数据
    private void modifyData() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("是否要继续修改数据：输入对应序号进行修改操作，其他任意数字键退出");
        int modifyNum;
        try {
            // 捕获输入错误异常
            modifyNum = scanner.nextInt();

            // 正确输入
            if (modifyNum > 0 && modifyNum <= 3) {
                System.out.print("请输入动物名字：");
                String newName = scanner.next();
                Animal animal = animals[modifyNum - 1];
                animal.setName(newName);

                // 判断是不是陆生生物
                if (animal instanceof Terrestrial) {
                    System.out.println("请输入腿的条数");
                    int newLegNum;
                    while (true) {
                        try {
                            newLegNum = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("错误输入类型，请输入整数");
                        }
                    }
                    ((Terrestrial) animal).setLegNum(newLegNum);
                }
            }


        } catch (InputMismatchException e) {
            // 读掉错误字符串
            scanner.nextLine();
        } catch (Duck.OutOfObjectiveConditionException | Cat.OutOfObjectiveConditionException e) {
            e.printStackTrace();
        } finally {
            System.out.println("退出");
            scanner.close();
        }

    }

    public void run() {
        // 显示数据
        showInfo();
        // 修改数据
        modifyData();
        // 再显示数据
        showInfo();

    }

}
