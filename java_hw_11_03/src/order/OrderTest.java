package order;

import java.io.*;
import java.util.Scanner;

/**
 * @PackageName:order
 * @ClassName:OrderTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 16:36
 */
public class OrderTest {
    public static void main(String[] args) {
        File file = new File("java_hw_11_03/files/order/save.bin");
        // 文件不存在
        if (!file.exists()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入用户姓名：");
            String name = sc.next();
            Customer customer = new Customer(name);

            Order order = new Order(0);
            // 死循环下订单
            for (; ; ) {

                System.out.println("请输入产品：");
                System.out.print("产品号：");
                String no = sc.next();
                System.out.print("名称：");
                String prName = sc.next();
                System.out.print("购买数量：");
                int nums = sc.nextInt();
                System.out.print("产品单价：");
                double unitPrice = sc.nextDouble();
                System.out.println("是否继续？（Y/N）：");
                // 添加商品到订单
                order.addCommodity(new Commodity(no, prName, nums, unitPrice));
                String check = sc.next();
                // 如果不是y则退出循环
                if (!(check.equalsIgnoreCase("y") || check.equalsIgnoreCase("yes"))) {
                    break;
                }
            }

            // 绑定订单到客户
            customer.setOrder(order);

            System.out.println(customer.getOrder());

            // 写入到文件
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                // 把客户写进去
                oos.writeObject(customer);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 如果文件存在
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                // 从文件里读取对象数据
                Customer customer = (Customer) ois.readObject();
                // 获取订单数据和总价
                System.out.println(customer.getOrder());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
