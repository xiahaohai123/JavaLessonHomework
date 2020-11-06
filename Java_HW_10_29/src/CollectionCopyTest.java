import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Test
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/29 13:34
 */
public class CollectionCopyTest {
    public static void main(String[] args) {
        System.out.println("支持随机访问接口的ArrayList：");
        List<Integer> dest = new ArrayList<>();
        List<Integer> src = new ArrayList<>();
        dest.add(1);
        for (int i = 0; i < 20; i++) {
            src.add(i);
        }
//        Collections.copy(dest, src);
        HWTools.copy(dest, src);
        dest.forEach(System.out::println);

        System.out.println("不支持随机访问接口的LinkedList：");
        dest = new LinkedList<>();
        src = new LinkedList<>();
        dest.add(1);
        for (int i = 0; i < 20; i++) {
            src.add(i);
        }
//        Collections.copy(dest, src);
        HWTools.copy(dest, src);
        dest.forEach(System.out::println);



    }
}
