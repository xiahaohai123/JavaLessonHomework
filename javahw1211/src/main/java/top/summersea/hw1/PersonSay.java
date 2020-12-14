package top.summersea.hw1;

/**
 * @PackageName: top.summersea.hw1
 * @ClassName: PersonSay
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/11 16:15
 */
public class PersonSay {
    private String name;
    private String wordToSay;

    public void setName(String name) {
        this.name = name;
    }

    public void setWordToSay(String wordToSay) {
        this.wordToSay = wordToSay;
    }

    public void say() {
        System.out.println(name + "说：\"" + wordToSay + "\"");
    }
}
