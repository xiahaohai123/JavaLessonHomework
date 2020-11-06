package hw;

/**
 * @PackageName:hw
 * @ClassName:MySignature
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:36
 */
public class MySignature implements Signature {
    private String signature;

    public MySignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String getSign() {
        return signature;
    }
}
