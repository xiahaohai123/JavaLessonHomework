package practice3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @PackageName:practice3
 * @ClassName:Practice3
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 14:36
 */
public class Practice3 {
    public static void main(String[] args) {
        List<Hero> heroList = new ArrayList<>();

        // 填充数据
        for (int i = 0; i < 100; i++) {
            heroList.add(new Hero(i));
        }

        int count = 1;
        // 原始数据输出
        System.out.println("原始数据：");
        for (Hero hero : heroList) {
            if (count < 10) {
                System.out.print(hero + "\t");
                count++;
            } else {
                System.out.println(hero);
                count = 1;
            }
        }

        // 删除数据
        Iterator<Hero> iterator = heroList.iterator();
        StringBuilder sb = new StringBuilder("\n要删除的数据：\n");
        while (iterator.hasNext()) {
            Hero hero = iterator.next();
            // 如果是8的倍数
            if (hero.getName() % 8 == 0) {
                sb.append(hero.toString()).append("\t");
                // iterator移除
                iterator.remove();
            }
        }

        System.out.println(sb);


        count = 1;
        // 删除后的数据
        System.out.println("\n删除后的数据：");
        for (Hero hero : heroList) {
            if (count < 10) {
                System.out.print(hero + "\t");
                count++;
            } else {
                System.out.println(hero);
                count = 1;
            }
        }
    }
}
