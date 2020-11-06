package hw1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @PackageName:hw1
 * @ClassName:NoodlesManager
 * @Description: 面条点单类，使用单例模式
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/20 15:34
 */
public class NoodlesManagerSingleton {
    private static NoodlesManagerSingleton uniqueInstance;
    private final String addBeef = "加肉";
    private final String notAddBeef = "不加肉";

    private NoodlesManagerSingleton() {
    }

    public static NoodlesManagerSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new NoodlesManagerSingleton();
        }
        return uniqueInstance;
    }

    public void order() {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎贵客点面!");
        System.out.print("请输入面的宽度（宽/中宽/中/中细/细）：");
        // 获取宽度
        String widthInString = sc.next();
        // 获取枚举类对象
        Noodles.Width width = judgeWidth(widthInString);
        //循环判断输入的是否正确
        while (width == null) {
            System.out.print("输入的宽度不对，请重新输入：");
            widthInString = sc.next();
            width = judgeWidth(widthInString);
        }

        // 获取尺寸
        System.out.print("要大碗还是小碗？：");
        String sizeInString = sc.next();
        Noodles.Size size = judgeSize(sizeInString);
        while (size == null) {
            System.out.println("输入的尺寸不对，请重新输入：");
            sizeInString = sc.next();
            size = judgeSize(sizeInString);
        }

        // 加肉否？
        System.out.print("加肉嘛？(加肉/不加肉)：");
        String addBeefInString = sc.next();
        Boolean addBeef = judgeAddBeef(addBeefInString);
        while (addBeef == null) {
            System.out.println("输入的值不对，请重新输入：");
            addBeefInString = sc.next();
            addBeef = judgeAddBeef(addBeefInString);
        }

        System.out.print("加几个蛋？：");
        int eggs;
        // 输入检测，直到输入正常为止。
        while (true) {
            // 异常捕获，输入的不是数字则捕获异常
            try {
                eggs = sc.nextInt();
                if (eggs >= 0) {
                    break;
                } else {
                    System.out.print("给我好好输入非负整数啊kora！：");
                }
            } catch (InputMismatchException e) {
                System.out.print("不要给我输奇怪的东西好吗？：");
                // 出错后读掉后面的所有字符
                sc.nextLine();
            }
        }
        // 关闭输入流
        sc.close();

        Noodles noodles = new Noodles(width, size, addBeef, eggs);
        // 显示信息
        System.out.println(noodles);
    }

    /**
     * 根据输入的字符串来判断是否加肉
     *
     * @param input
     * @return 一个Boolean对象，如果是true表示加牛肉，如果为false表示不加牛肉，如果是null则表示输入不合法
     */
    public Boolean judgeAddBeef(String input) {
        switch (input) {
            case addBeef:
                return true;
            case notAddBeef:
                return false;
        }
        return null;
    }

    /**
     * 判断输入的宽度返回对应的枚举实例
     *
     * @param width
     * @return
     */
    public Noodles.Width judgeWidth(String width) {
        if (width.equals(Noodles.Width.WIDE.getInString())) {
            return Noodles.Width.WIDE;
        } else if (width.equals(Noodles.Width.MID_WIDE.getInString())) {
            return Noodles.Width.MID_WIDE;
        } else if (width.equals(Noodles.Width.MID.getInString())) {
            return Noodles.Width.MID;
        } else if (width.equals(Noodles.Width.MID_FINE.getInString())) {
            return Noodles.Width.MID_FINE;
        } else if (width.equals(Noodles.Width.FINE.getInString())) {
            return Noodles.Width.FINE;
        }
        return null;
    }

    public Noodles.Size judgeSize(String size) {
        if (Noodles.Size.BIG.getDescriptionInChinese().equals(size)) {
            return Noodles.Size.BIG;
        } else if (Noodles.Size.SMALL.getDescriptionInChinese().equals(size)) {
            return Noodles.Size.SMALL;
        }

        return null;
    }
}
