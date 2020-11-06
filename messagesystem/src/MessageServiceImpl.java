import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: MessageServiceImpl
 * @Description:
 * @Version: V1.0
 * @Author 夏浩海
 * @Date 2020/10/31 9:33
 */
public class MessageServiceImpl implements MessageService {
    // 留言列表
    private List<Message> messageList;
    // 时间戳转换器
    private SimpleDateFormat sdf;

    public MessageServiceImpl() {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 初始化数据
        messageList = new ArrayList<>();
        messageList.add(new Message("lkl", "2008年奥运会开幕式", "开幕式非常精彩，大气磅礴，极富创意"));
        messageList.add(new Message("bdqn", "欢迎您", "欢迎您来学习Java课程"));
        messageList.add(new Message("丁丁", "第三条留言", "唧唧啵唧，唧唧啵耶耶"));
    }


    /**
     * 返回所有留言信息
     *
     * @return String
     */
    @Override
    public String getAllMessage() {
        int size = messageList.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Message message = messageList.get(i);
            sb.append("【第").append(i + 1).append("条留言信息】\n");
            sb.append("姓名：").append(message.getUserName()).append('\n');
            sb.append("时间：").append(sdf.format(message.getCreateTime())).append('\n');
            sb.append("标题：").append(message.getTitle()).append('\n');
            sb.append("内容：").append(message.getContents()).append("\n\n");
        }

        return sb.toString();
    }

    /**
     * @param username 留言人
     * @param title    标题
     * @param content  内容
     */
    @Override
    public void addMessage(String username, String title, String content) {
        messageList.add(new Message(username, title, content));
    }
}
