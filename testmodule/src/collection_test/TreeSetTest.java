package collection_test;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @PackageName:collection_test
 * @ClassName:TreeSetTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/2 15:24
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> s = new TreeSet<>();
        s.add("one");
        s.add("two");

        SortedSet<String> sorted = s.tailSet(s.first());

        for (String s1 : sorted) {
            System.out.println(s1);
        }
    }
}
