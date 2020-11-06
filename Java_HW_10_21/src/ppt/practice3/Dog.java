package ppt.practice3;

/**
 * @PackageName:ppt.practice3
 * @ClassName:Dog
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 16:06
 */
public class Dog extends ElectronicPet {

    public Dog() {
        super();
    }

    @Override
    public String confession() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("宠物狗狗的自白：\n");
        stringBuilder.append("我的名字叫").append(getName())
                .append(",健康值是").append(getHealth())
                .append("，和主人的亲密度是").append(getIntimacy())
                .append("，我的性别是").append(getSex());
        return stringBuilder.toString();
    }

    @Override
    public String getType() {
        return "狗狗";
    }
}
