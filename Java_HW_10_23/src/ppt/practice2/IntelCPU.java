package ppt.practice2;

/**
 * @PackageName:practice2
 * @ClassName:IntelCPU
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:01
 */
public class IntelCPU implements CPU {
    // 获取品牌
    @Override
    public String getBrand() {
        return "Intel";
    }

    //
    @Override
    public String getMainFrequency() {
        return "2GHz";
    }
}
