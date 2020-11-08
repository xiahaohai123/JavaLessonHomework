package utils;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @PackageName:utils
 * @ClassName:ScannerUtil
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 14:50
 */
public class ScannerUtil {
    Scanner sc;

    public ScannerUtil(InputStream is) {
        sc = new Scanner(is);
    }

    /**
     * 获取一个区间内的数字
     * 调用sc.next导致阻塞
     * 区间左闭右开
     * 如果获取失败则循环重新获取
     *
     * @return
     */
    public int nextNumInSection(int start, int end) {
        for (; ; ) {
            try {
                int res = sc.nextInt();
                if (res >= start && res < end) {
                    return res;
                } else {
                    System.out.println("输入的值超出范围，请重新输入");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("输入不符合要求，请重新输入数值");
            }
        }
    }

    public String nextString() {
        return sc.next();
    }

    /**
     * 关闭
     */
    public void close() {
        sc.close();
    }
}
