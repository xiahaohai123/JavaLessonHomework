/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:MessageService
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/31 9:32
 */
public interface MessageService {

    /**
     * 获取所有留言
     *
     * @return 留言的字符串
     */
    String getAllMessage();

    /**
     * 新增留言
     *
     * @param username 留言人
     * @param title    标题
     * @param content  内容
     */
    void addMessage(String username, String title, String content);
}
