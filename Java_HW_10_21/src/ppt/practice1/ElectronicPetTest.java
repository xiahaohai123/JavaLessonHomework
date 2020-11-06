package ppt.practice1;

import java.util.Scanner;

/**
 * @PackageName:ppt
 * @ClassName:ElectronicPetTest
 * @Description: 电子宠物测试类
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 14:01
 */
public class ElectronicPetTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎来到宠物店！");
        // 实例化一个默认对象
        ElectronicPet pet = new ElectronicPet();
        // 名字
        System.out.print("请输入要领养的宠物的名字：");
        String name = scanner.next();
        pet.setName(name);

        // 类型
        System.out.print("请输入要领养的宠物的类型（1、狗狗 2、企鹅）：");
        String typeNumber = scanner.next();
        // 要求输入正确的值不然循环输入
        while (!pet.setType(typeNumber)) {
            System.out.print("请输入正确的值（1、狗狗 2、企鹅）：");
            typeNumber = scanner.next();
        }

        // 性别
        System.out.print("请选择" + pet.getType() + "的性别（1、Q仔 2、Q妹）：");
        String sexNumber = scanner.next();
        while (!pet.setSex(sexNumber)) {
            System.out.print("请输入正确的值（1、Q仔 2、Q妹）：");
            sexNumber = scanner.next();
        }

        // 健康值
        System.out.print("请输入" + pet.getType() + "的健康值（1~100之间）：");
        String health = scanner.next();
        if (!pet.setHealth(health)) {
            System.out.println("健康值应该在0至100之间，默认为60.");
        }

        scanner.close();

        // 自白
        System.out.println("宠物的自白：");
        System.out.println(pet);

    }
}
