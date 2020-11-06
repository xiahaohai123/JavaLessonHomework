package ppt.practice1;

import java.util.Scanner;

/**
 * @PackageName:ppt.practice3
 * @ClassName:ElectronicPetTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 16:10
 */
public class ElectronicPetTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到宠物店！");
        // 获取名字
        System.out.print("请输入要领养的宠物的名字：");
        String name = scanner.next();
        // 获取类型
        System.out.print("请选择要养的宠物的类型（1、狗狗 2、企鹅）：");
        int type = scanner.nextInt();
        // 声明类对象
        ElectronicPet pet;
        // 根据类型选择宠物类型
        if (type == 1) {
            pet = new Dog();
        } else if (type == 2) {
            pet = new Penguin();
        } else {
            pet = new Penguin();
            System.out.println("错误的输入，默认选择企鹅");
        }

        pet.setName(name);

        // 性别 getType()利用多态特性
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

        System.out.println(pet.confession());
    }
}
