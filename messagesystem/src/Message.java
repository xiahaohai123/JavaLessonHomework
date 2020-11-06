/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Message
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/31 9:30
 */
public class Message {

    private static int ID = 0;

    // id
    private int id;
    // 留言人
    private String userName;
    // 留言标题
    private String title;
    // 留言内容
    private String contents;
    // 留言时间 时间戳格式
    private long createTime;

    public Message(String userName, String title, String contents) {
        this.id = ++ID;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createTime = System.currentTimeMillis();
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public long getCreateTime() {
        return createTime;
    }
}
