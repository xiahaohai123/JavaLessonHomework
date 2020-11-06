package practice3;

/**
 * @PackageName:practice3
 * @ClassName:Member
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/27 14:04
 */
public class Member {
    private String username;
    private String password;

    public Member(String username, String password, String repeatedPwd) throws IllegalUsernameLengthException {
        setUsername(username);
        setPassword(password, repeatedPwd);
    }

    public void setUsername(String username) throws IllegalUsernameLengthException {
        // 大于3位才能成功set
        if (username.length() >= 3) {
            this.username = username;
        } else {
            throw new IllegalUsernameLengthException();
        }
    }

    /**
     * 注册密码
     *
     * @param pwd         输入的新密码
     * @param repeatedPwd 重复输入的新密码
     *                    两个参数保证同时输入
     * @return
     */
    public void setPassword(String pwd, String repeatedPwd) throws IllegalUsernameLengthException, MisMatchPasswordException {
        if (pwd.length() < 6) {
            throw new IllegalPasswordLengthException();
        }
        if (!pwd.equals(repeatedPwd)) {
            throw new MisMatchPasswordException();
        }

        this.password = pwd;
    }

    /**
     * 当username小于3的时候被抛出
     */
    public class IllegalUsernameLengthException extends RuntimeException {
        @Override
        public String getMessage() {
            return "用户名长度不能小于3";
        }
    }

    /**
     * 当密码长度小于6的时候被抛出
     */
    public class IllegalPasswordLengthException extends RuntimeException {
        @Override
        public String getMessage() {
            return "密码长度不能小于6";
        }
    }

    /**
     * 密码不匹配时抛出
     */
    public class MisMatchPasswordException extends RuntimeException {
        @Override
        public String getMessage() {
            return "两次输入的密码不同";
        }
    }
}
