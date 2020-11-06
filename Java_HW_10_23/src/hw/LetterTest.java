package hw;

/**
 * @PackageName:hw
 * @ClassName:LetterTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:40
 */
public class LetterTest {
    public static void main(String[] args) {
        Appellation appellation = new MyAppellation("致XXXXXXX：");
        MainBody mainBody = new MyMainBody("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\nXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Ending ending = new MyEnding("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Signature signature = new MySignature("XXX");
        WriteDay writeDay = new MyWriteDay("XXXX年XX月XX日");

        Letter letter = new Letter(appellation, mainBody, ending, signature, writeDay);

        System.out.println(letter);
    }

}
