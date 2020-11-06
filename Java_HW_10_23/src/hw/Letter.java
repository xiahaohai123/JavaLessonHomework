package hw;

/**
 * @PackageName:hw
 * @ClassName:Letter
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 16:15
 */
public class Letter {
    private Appellation appellation;
    private MainBody mainBody;
    private Ending ending;
    private Signature signature;
    private WriteDay writeDay;

    public Letter(Appellation appellation, MainBody mainBody, Ending ending, Signature signature, WriteDay writeDay) {
        this.appellation = appellation;
        this.mainBody = mainBody;
        this.ending = ending;
        this.signature = signature;
        this.writeDay = writeDay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(appellation.getAppellation()).append('\n');
        sb.append(mainBody.getMainBody()).append('\n');
        sb.append(ending.getEnding()).append('\n');
        sb.append("\t\t\t\t\t\t\t").append(signature.getSign()).append('\n');
        sb.append("\t\t\t\t\t\t\t").append(writeDay.getWriteDay()).append('\n');
        return sb.toString();
    }
}
