import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:MessageSystem
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/31 9:34
 */
public class MessageSystem {
    // 输入流
    private Scanner sc;
    // 留言服务
    private MessageService messageService;

    public MessageSystem() {
        sc = new Scanner(System.in);
        messageService = new MessageServiceImpl();
    }

    /**
     * 打印菜单
     */
    public void showMenu() {
        System.out.print("\n---欢迎登陆留言系统---" +
                "\n\t1、查询留言" +
                "\n\t2、添加留言" +
                "\n\t3、退出系统" +
                "\n请选择：");
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int input;
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("请输入正确序号");
                // 吃掉缓冲区
                sc.nextLine();
                continue;
            }

            switch (input) {

                case 1:
                    // 查询留言
                    System.out.println(messageService.getAllMessage());
                    break;
                case 2:
                    // 新增留言
                    System.out.print("请输入留言人姓名：");
                    String username = sc.next();
                    System.out.print("请输入留言标题：");
                    String title = sc.next();
                    System.out.print("请输入留言内容：");
                    String content = sc.next();

                    messageService.addMessage(username, title, content);
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("请输入正确序号");
            }
        }

        beforeExit();
    }

    /**
     * 程序退出前要做的事情
     */
    public void beforeExit() {
        sc.close();
        System.out.println("\n谢谢使用，再见！");
    }

}
