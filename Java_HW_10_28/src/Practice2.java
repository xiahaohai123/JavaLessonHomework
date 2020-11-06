import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice2
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 14:27
 */
public class Practice2 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        /*
        10万条
         */
        long currTime0 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(1);
        }
        long currTime1 = System.currentTimeMillis();
        System.out.println("在ArrayList最后插入100000条数据，总共耗时" + (currTime1 - currTime0) + "ms");


        currTime0 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(1);
        }
        currTime1 = System.currentTimeMillis();
        System.out.println("在LinkedList最后插入100000条数据，总共耗时" + (currTime1 - currTime0) + "ms");


        /*
        一千万条
         */
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        currTime0 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            arrayList.add(1);
        }
        currTime1 = System.currentTimeMillis();
        System.out.println("在ArrayList最后插入一千万条数据，总共耗时" + (currTime1 - currTime0) + "ms");


        currTime0 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            linkedList.add(1);
        }
        currTime1 = System.currentTimeMillis();
        System.out.println("在LinkedList最后插入一千万条数据，总共耗时" + (currTime1 - currTime0) + "ms");


    }
}
