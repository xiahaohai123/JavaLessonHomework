package ppt.practice2;

/**
 * @PackageName:practice2
 * @ClassName:SamsunEMS
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:04
 */
public class SamsunEMS implements EMS {
    @Override
    public String getType() {
        return "DDR4";
    }

    @Override
    public String getCapacity() {
        return "8GB";
    }
}
