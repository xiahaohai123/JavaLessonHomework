package top.summersea.hw2;

import java.util.StringJoiner;

/**
 * @PackageName: top.summersea.hw2
 * @ClassName: InkCartridge
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/11 16:44
 */
public class InkCartridge {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InkCartridge.class.getSimpleName() + "{", "}")
                .add("color='" + color + "'")
                .toString();
    }
}
