import beans.DVD;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:OrderSystem
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/15 16:00
 */
public class DVDLendManager {
    private static final int CAPACITY = 4;
    private static final int MAGNIFICATION = 2;
    int size = 0;
    private DVD[] dvdShelf = new DVD[CAPACITY];
    private Scanner sc;

    public static void main(String[] args) {
        DVDLendManager dvdLendManager = new DVDLendManager();
        dvdLendManager.run();
    }

    private void run() {
        //系统初始化
        init();


        int input = -1;
        do {
            //打印主菜单
            printHomeMenu();
            try {
                input = sc.nextInt();
                //异常捕获
            } catch (InputMismatchException e) {
                //读掉缓冲区
                sc.nextLine();
                System.out.println("输入非法，请重新输入");
                continue;
            }
            switch (input) {
                case 1:
                    //增加DVD
                    addDVDMode();
                    break;
                case 2:
                    System.out.println("------->查看DVD\n");
                    System.out.println("序号\t\t状态\t\t名称\t\t\t借出日期\t\t借出次数");
                    for (int i = 0; i < size; i++) {
                        System.out.println((i + 1) + "\t\t\t" + dvdShelf[i]);
                    }
                    backMenu();
                    break;
                case 3:
                    deleteDVDMode();
                    break;
                case 4:
                    lendDVDMode();
                    break;
                case 5:
                    returnDVDMode();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("请输入有效序号");
            }
        } while (input != 6);

        //退出
        finalOperation();

    }

    private void init() {
        //初始化输入流
        sc = new Scanner(System.in);
        //初始化方法
        initValue();
    }

    //初始化数据方法
    private void initValue() {
        dvdShelf[0] = new DVD("疯马假日", 15, 1);
        dvdShelf[1] = new DVD("风声鹤唳", 12, -1);
        dvdShelf[2] = new DVD("浪漫满屋", 30, -1);
        size = 3;
    }

    private void finalOperation() {
        sc.close();
        System.out.println("退出系统");
    }

    private void printHomeMenu() {
        String homeMenuBuilder = "请输入序号进入对应功能：\n" +
                "***************************************\n1、新增DVD\n2、查看DVD\n3、删除DVD\n4、借出DVD\n5、归还DVD\n6、退出DVD\n***************************************\n请选择:";
        System.out.print(homeMenuBuilder);
    }

    private void backMenu() {
        int subInput;
        do {
            System.out.println("*************************");
            System.out.println("输入0返回");
            subInput = sc.nextInt();
            if (subInput != 0) {
                System.out.println("非法输入，请重新输入");
            }
        } while (subInput != 0);
    }

    /**
     * 新增DVD模组
     */
    private void addDVDMode() {
        boolean runningFlag = true;
        while (runningFlag) {
            System.out.println("\n------->新增DVD");
            System.out.print("请输入DVD名称(输入back退出该模组)：");
            String name = sc.next();
            //退出条件
            if ("back".equals(name)) {
                //防止输入的值是DVD名，再判断一次
                while (true) {
                    System.out.println("Y:退出该模组,N:不退出,back:输入的是DVD名");
                    String input = sc.next();
                    if ("Y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input)) {
                        runningFlag = false;
                        break;
                    } else if ("n".equalsIgnoreCase(input) || "no".equalsIgnoreCase(input)) {
                        break;
                    } else if ("back".equalsIgnoreCase(input) || "b".equalsIgnoreCase(input)) {
                        //是DVD名则新增
                        addNewDVD(name);
                        break;
                    } else {
                        System.out.println("输入错误，请重新输入：");
                    }
                }
            }
            //常规情况下增加
            else {
                addNewDVD(name);
            }
        }
    }

    /**
     * 删除DVD模组
     */
    private void deleteDVDMode() {
        boolean runningFlag = true;
        while (runningFlag) {
            System.out.println("\n------->删除DVD");
            System.out.print("请输入DVD名称(back退出该模组)：");
            String name = sc.next();
            if ("back".equals(name)) {
                //防止输入的值是DVD名，再判断一次
                while (true) {
                    System.out.println("Y:退出该模组,N:不退出,back:输入的是DVD名");
                    String input = sc.next();
                    if ("Y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input)) {
                        runningFlag = false;
                        break;
                    } else if ("n".equalsIgnoreCase(input) || "no".equalsIgnoreCase(input)) {
                        break;
                    } else if ("back".equalsIgnoreCase(input) || "q".equalsIgnoreCase(input)) {
                        //是DVD名则删除
                        deleteDVD(name);
                        break;
                    } else {
                        System.out.println("输入错误，请重新输入：");
                    }
                }
            } else {
                deleteDVD(name);
            }
        }
    }

    /**
     * 出借DVD模组
     */
    private void lendDVDMode() {
        boolean runningFlag = true;
        while (runningFlag) {
            System.out.println("\n------->借出DVD");
            System.out.print("请输入DVD名称(输入back退出该模组)：");
            String name = sc.next();
            //退出条件
            if ("back".equals(name)) {
                //防止输入的值是DVD名，再判断一次
                while (true) {
                    System.out.println("Y:退出该模组,N:不退出,back:输入的是DVD名");
                    String input = sc.next();
                    if ("Y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input)) {
                        runningFlag = false;
                        break;
                    } else if ("n".equalsIgnoreCase(input) || "no".equalsIgnoreCase(input)) {
                        break;
                    } else if ("back".equalsIgnoreCase(input) || "b".equalsIgnoreCase(input)) {
                        //是DVD名则借出
                        lendDVD(name);
                        break;
                    } else {
                        System.out.println("输入错误，请重新输入：");
                    }
                }
            }
            //常规情况下借出
            else {
                lendDVD(name);
            }
        }
    }

    /**
     * 归还DVD模组
     */
    private void returnDVDMode() {
        boolean runningFlag = true;
        while (runningFlag) {
            System.out.println("\n------->归还DVD");
            System.out.print("请输入DVD名称(输入back退出该模组)：");
            String name = sc.next();
            //退出条件
            if ("back".equals(name)) {
                //防止输入的值是DVD名，再判断一次
                while (true) {
                    System.out.println("Y:退出该模组,N:不退出,back:输入的是DVD名");
                    String input = sc.next();
                    if ("Y".equalsIgnoreCase(input) || "yes".equalsIgnoreCase(input)) {
                        runningFlag = false;
                        break;
                    } else if ("n".equalsIgnoreCase(input) || "no".equalsIgnoreCase(input)) {
                        break;
                    } else if ("back".equalsIgnoreCase(input) || "b".equalsIgnoreCase(input)) {
                        //是DVD名则借出
                        returnDVD(name);
                        break;
                    } else {
                        System.out.println("输入错误，请重新输入：");
                    }
                }
            }
            //常规情况下借出
            else {
                returnDVD(name);
            }
        }
    }

    /**
     * 新增DVD操作
     * 如果数组中不存在相同的DVD对象则会填充新的DVD对象到数组中 size++
     * 如果数组长度不够则扩容数组
     * 扩容倍率为2，即每次扩容后的数组长度都是原数组的两倍
     *
     * @param dvdName DVD的名字
     */
    private void addNewDVD(String dvdName) {
        //判断是否已存在
        for (int i = 0; i < size; i++) {
            if (dvdShelf[i].getName().equals(dvdName)) {
                //存在则提示并退出此方法，不新增
                System.out.println("该DVD已存在");
                return;
            }
        }

        //如果数组已满
        if (size == dvdShelf.length) {
            //扩容数组，指数式扩容
            dvdShelf = Arrays.copyOf(dvdShelf, dvdShelf.length * MAGNIFICATION);
        }

        //增加DVD
        dvdShelf[size] = new DVD(dvdName);
        //增加有效数组长度
        size++;
        System.out.println("添加成功");
    }

    /**
     * 删除DVD操作
     * 找到目标DVD的下标
     * 如果目标DVD已经借出则不删除
     * 未借出则删除
     * 并让size--
     *
     * @param dvdName DVD名字
     */
    private void deleteDVD(String dvdName) {
        //删除下标，默认-1，表示没找到
        int removeIndex = -1;
        for (int i = 0; i < size; i++) {
            if (dvdShelf[i].getName().equals(dvdName)) {
                //找到后更新删除下标
                removeIndex = i;
                break;
            }
        }

        //要求找到DVD
        if (removeIndex >= 0) {
            //DVD被借出
            if (dvdShelf[removeIndex].isLending()) {
                System.out.println("DVD已借出，无法删除，请等待归还");
            }
            //删除DVD
            else {
                //将后面的元素全部向前移
                for (int i = removeIndex; i < size - 1; i++) {
                    dvdShelf[i] = dvdShelf[i + 1];
                }
                //有效长度-1
                size--;
                System.out.println("删除成功");
            }
        } else {
            System.out.println("要删除的对象不存在");
        }


    }

    /**
     * 借出DVD操作
     * 如果DVD存在则检查是否已被借出
     * 如果未被借出则要求输入借出天数
     *
     * @param name
     */
    private void lendDVD(String name) {
        //出借的DVD索引 默认-1未找到
        int lendIndex = -1;
        for (int i = 0; i < size; i++) {
            //找到后改变索引位置
            if (dvdShelf[i].getName().equals(name)) {
                lendIndex = i;
                break;
            }
        }

        //如果找到了
        if (lendIndex >= 0) {
            //已借出状态
            if (dvdShelf[lendIndex].isLending()) {
                System.out.println("该DVD已被借出，请等待归还");
            } else {
                //可出借，需要借出天数
                int lendingDays;
                do {
                    System.out.print("请输入借出天数（1~31天）");
                    lendingDays = sc.nextInt();

                    if (lendingDays <= 0 || lendingDays > 31) {
                        System.out.println("输入错误");
                    } else {
                        break;
                    }
                } while (true);

                //借出操作
                if (dvdShelf[lendIndex].lend(lendingDays)) {
                    System.out.println("借出成功");
                } else {
                    System.out.println("借出失败");
                }
            }
        } else {
            System.out.println("没有此DVD");
        }
    }

    /**
     * 归还DVD操作
     * 如果DVD存在则检查是否已归还
     * 如果未归还则归还
     *
     * @param name
     */
    private void returnDVD(String name) {
        int returnIndex = -1;
        for (int i = 0; i < size; i++) {
            //找到后改变索引位置
            if (dvdShelf[i].getName().equals(name)) {
                returnIndex = i;
                break;
            }
        }

        //如果找到了
        if (returnIndex >= 0) {
            //判断是否归还
            //未归还则归还
            if (dvdShelf[returnIndex].isLending()) {
                if (dvdShelf[returnIndex].returnDVD()) {
                    System.out.println("成功归还");
                } else {
                    System.out.println("归还失败");
                }
            } else {
                System.out.println("该DVD未借出，不用归还");
            }
        } else {
            System.out.println("未找到对应的DVD");
        }
    }
}
