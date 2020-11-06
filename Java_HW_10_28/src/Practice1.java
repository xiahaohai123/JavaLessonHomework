import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice1
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 9:57
 */
public class Practice1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        // 50个
        while (set.size() < 50) {
            // [0,1) * 9000 -> [0,9000)
            // [0,9000) + 1000 -> [0,10000)
            set.add((int) (Math.random() * 9000 + 1000));
        }

        int count = 1;
        for (Integer integer : set) {
            if (count < 10) {
                System.out.print(integer + "\t");
                count++;
            } else {
                System.out.println(integer);
                count = 1;
            }
        }
    }
}
