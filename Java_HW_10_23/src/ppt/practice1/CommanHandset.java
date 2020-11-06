package ppt.practice1;

/**
 * @PackageName:practice1
 * @ClassName:CommanHandset
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 14:19
 */
public class CommanHandset extends Handset implements PlayWiring {
    public CommanHandset(String brand, String type) {
        super(brand, type);
    }

    @Override
    public void sendInfo() {
        System.out.println("发送文字信息......");
    }

    @Override
    public void call() {
        System.out.println("开始语音通话......");
    }

    @Override
    public void play(String content) {
        System.out.println("开始播放音乐" + content + "......");
    }
}
