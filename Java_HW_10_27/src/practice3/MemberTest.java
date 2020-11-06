package practice3;

import java.util.Scanner;

/**
 * @PackageName:practice3
 * @ClassName:MemberTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 14:20
 */
public class MemberTest {
    public static void main(String[] args) {
        System.out.println("********欢饮进入注册系统********\n\n");
        Scanner scanner = new Scanner(System.in);

        // 声明
        Member member;
        String username;
        String pwd;
        String repeatedPwd;

        do {
            System.out.print("请输入用户名：");
            username = scanner.next();
            System.out.print("请输入密码：");
            pwd = scanner.next();
            System.out.println("请再次输入密码：");
            repeatedPwd = scanner.next();
            try {
                member = new Member(username, pwd, repeatedPwd);
                break;
            } catch (Member.IllegalUsernameLengthException e) {
                System.out.println(e.getMessage());
            } catch (Member.IllegalPasswordLengthException e) {
                System.out.println(e.getMessage());
            } catch (Member.MisMatchPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);

        System.out.println("注册成功，请牢记用户名和密码");

    }
}
