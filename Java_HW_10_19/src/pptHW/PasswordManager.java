package pptHW;

import java.util.Scanner;

/**
 * @PackageName:pptHW
 * @ClassName:PasswordManager
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/19 13:44
 */
public class PasswordManager {
    private String username;
    private String pwd;

    public PasswordManager() {
        username = "xhh";
        pwd = "xhh";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 创建账户对象
        PasswordManager pwdManager = new PasswordManager();
        // 要求输入账密
        System.out.print("请输入用户名：");
        String usernameIn = sc.next();
        System.out.print("请输入密码：");
        String passwordIn = sc.next();

        // 登录
        if (pwdManager.login(usernameIn, passwordIn)) {
            // 成功则修改密码
            System.out.print("请输入新密码：");
            String newPwd = sc.next();
            // 修改密码
            if (pwdManager.modifyPwd(newPwd)) {
                System.out.println("修改成功，您的新密码是：" + pwdManager.getPwd());
            }
        } else {
            // 失败
            System.out.println("用户名和密码不匹配！您没有权限更新管理员信息。");
        }

        sc.close();
    }

    public boolean login(String username, String pwd) {
        return this.username.equals(username) && this.pwd.equals(pwd);
    }

    public boolean modifyPwd(String newPwd) {
        this.pwd = newPwd;
        return true;
    }

    public String getPwd() {
        return pwd;
    }
}
