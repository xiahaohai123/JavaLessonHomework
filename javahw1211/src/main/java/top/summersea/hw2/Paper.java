package top.summersea.hw2;

import java.util.StringJoiner;

/**
 * @PackageName: top.summersea.hw2
 * @ClassName: Paper
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/11 16:47
 */
public class Paper {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Paper.class.getSimpleName() + "{", "}")
                .add("type='" + type + "'")
                .toString();
    }
}
