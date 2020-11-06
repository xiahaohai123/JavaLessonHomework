package practice4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:practice4
 * @ClassName:Practice4
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 15:07
 */
public class Practice4 {
    public static void main(String[] args) {
        List<Worker> list = new LinkedList<>();
        list.add(new Worker("zhang3", 18, 3000));
        list.add(new Worker("li4", 25, 3500));
        list.add(new Worker("wang5", 22, 3200));

        int index = list.size();
        for (int i = 0; i < list.size(); i++) {
            if ("li4".equals(list.get(i).getName())) {
                index = i;
                break;
            }
        }

        list.add(index, new Worker("zhao6", 24, 3300));
        // 点赞idea 教我这里可以用lambda
        list.removeIf(worker -> "wang5".equals(worker.getName()));

        for (Worker worker : list) {
            System.out.println(worker);
        }

        System.out.println("\n工作：");
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().work();
        }

    }
}
