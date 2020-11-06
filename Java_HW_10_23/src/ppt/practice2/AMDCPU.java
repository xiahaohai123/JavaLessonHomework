package ppt.practice2;

/**
 * @PackageName:practice2
 * @ClassName:AMDCPU
 * @Description: AMD CPU
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:05
 */
public class AMDCPU implements CPU {
    @Override
    public String getBrand() {
        return "AMD YES!";
    }

    @Override
    public String getMainFrequency() {
        return "2GHz";
    }
}
