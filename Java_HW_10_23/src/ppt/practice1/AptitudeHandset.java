package ppt.practice1;

/**
 * @PackageName:practice1
 * @ClassName:AptitudeHandset
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 14:15
 */
public class AptitudeHandset extends Handset implements TheakPictures, Network, PlayWiring {
    public AptitudeHandset(String brand, String type) {
        super(brand, type);
    }

    @Override
    public void sendInfo() {
        System.out.println("发送带图片与文字的信息");
    }

    @Override
    public void call() {
        System.out.println("开始视频通话......");
    }


    @Override
    public void networkConn() {
        System.out.println("已经启用移动网络......");
    }

    @Override
    public void play(String content) {
        System.out.println("开始播放视频《" + content + "》......");
    }

    @Override
    public void takePicture() {
        System.out.println("咔嚓......拍照成功");
    }
}
