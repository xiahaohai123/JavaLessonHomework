package collection_test;

import java.util.LinkedList;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ArrayListTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 16:12
 */
public class ArrayListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.offer("struts");
        list.push("javase");
        list.offerFirst("javaee");
        list.offer("as");

        for (String s : list) {
            System.out.println(s);
        }

//        new collection_test.ArrayListTest().recursion();
    }

//    public void recursion() {
//        recursion();
//    }
}
