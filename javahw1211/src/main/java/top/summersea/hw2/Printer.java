package top.summersea.hw2;

import java.util.StringJoiner;

/**
 * @PackageName: top.summersea.hw2
 * @ClassName: Printer
 * @Description: 打印机
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/11 16:42
 */
public class Printer {
    private String name;
    private InkCartridge inkCartridge;
    private Paper paper;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InkCartridge getInkCartridge() {
        return inkCartridge;
    }

    public void setInkCartridge(InkCartridge inkCartridge) {
        this.inkCartridge = inkCartridge;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Printer.class.getSimpleName() + "{", "}")
                .add("name='" + name + "'")
                .add("inkCartridge=" + inkCartridge)
                .add("paper=" + paper)
                .toString();
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }


}
