import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:HWTools
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/29 13:34
 */
public class HWTools {
    /**
     * 改自官方代码
     *
     * @param dest
     * @param src
     * @param <T>
     */
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
        if (srcSize > dest.size()) {
            // 改
            copy2(dest, src);
            return;
        }

        // 支持随机访问接口(RandomAccess)的集合用for循环遍历比迭代器快
        // srcSize<10的集合用for循环遍历可能也比迭代器快？
        if (srcSize < 10 ||
                (src instanceof RandomAccess && dest instanceof RandomAccess)) {
            for (int i = 0; i < srcSize; i++)
                dest.set(i, src.get(i));
        } else {
            ListIterator<? super T> di = dest.listIterator();
            ListIterator<? extends T> si = src.listIterator();
            for (int i = 0; i < srcSize; i++) {
                di.next();
                di.set(si.next());
            }
        }
    }

    /**
     * 针对dest.size()<src.size()的情况
     *
     * @param dest
     * @param src
     * @param <T>
     */
    private static <T> void copy2(List<? super T> dest, List<? extends T> src) {
        int destSize = dest.size();
        int srcSize = src.size();

        // 照搬官方源码办法
        // 随机访问接口和小于10的size用for循环处理
        if (srcSize < 10 ||
                (src instanceof RandomAccess && dest instanceof RandomAccess)) {
            // destSize前用set设置
            for (int i = 0; i < destSize; i++)
                dest.set(i, src.get(i));
            // 之后追加
            for (int i = destSize; i < srcSize; i++) {
                dest.add(src.get(i));
            }
        } else {
            ListIterator<? super T> di = dest.listIterator();
            ListIterator<? extends T> si = src.listIterator();
            for (int i = 0; i < destSize; i++) {
                di.next();
                di.set(si.next());
            }
            for (int i = destSize; i < srcSize; i++) {
                // add会自动next一次
                di.add(si.next());
            }
        }
    }


    /**
     * 源自官方源码
     *
     * @param src
     * @param prefix
     * @param toffset
     * @return
     */
    public static boolean startsWith(String src, String prefix, int toffset) {
        char ta[] = src.toCharArray();
        int to = toffset;
        char pa[] = prefix.toCharArray();
        int po = 0;
        int pc = prefix.length();
        /*
        如果toffset<0
        如果 0 > src.length() - prefix.length() - toffset
        不可能为true
         */
        if ((toffset < 0) || (toffset > ta.length - pc)) {
            return false;
        }
        // 循环判断
        while (--pc >= 0) {
            // 如果不等于直接返回false
            if (ta[to++] != pa[po++]) {
                return false;
            }
        }
        return true;
    }

    public static boolean endsWith(String src, String suffix) {
        return startsWith(src, suffix, src.length() - suffix.length());
    }

    /**
     * 源码香
     *
     * @param src
     * @param oldChar
     * @param newChar
     * @return
     */
    public static String replace(String src, char oldChar, char newChar) {
        if (oldChar != newChar) {
            int len = src.length();
            int i = -1;
            char[] val = src.toCharArray();

            // 先找到第一个替换目标
            // 之前的都可以不用管
            while (++i < len) {
                if (val[i] == oldChar) {
                    break;
                }
            }
            // 如果找得到替换目标时 i < len
            if (i < len) {
                // 新建一个数组，用来构造最后的返回对象
                char buf[] = new char[len];
                // 第一个目标前的字符先全部赋值
                for (int j = 0; j < i; j++) {
                    buf[j] = val[j];
                }
                // 目标后的字符可能会出现很多个目标字符
                while (i < len) {
                    char c = val[i];
                    // 如果是目标字符则替换，否则复制
                    buf[i] = (c == oldChar) ? newChar : c;
                    i++;
                }
                return new String(buf);
            }
        }
//        return new String(src);
        // 不可变类
        return src;
    }


    public static byte[] getBytes(String src) {
        char[] cs = src.toCharArray();
        byte[] bs = new byte[cs.length];
        for (int i = 0; i < cs.length; i++) {
            bs[i] = (byte) cs[i];
        }

        return bs;
    }
}
