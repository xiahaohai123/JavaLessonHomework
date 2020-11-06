package ppt.practice2;

/**
 * @PackageName:ppt.practice2
 * @ClassName:Voter
 * @Description: 简单的voter类 只记录是否已投票
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 16:23
 */
public class Voter {

    private boolean hasVote;

    public Voter() {
    }


    public boolean isHasVote() {
        return hasVote;
    }

    // 设置投票状态，只能设置为true
    public void vote() {
        this.hasVote = true;
    }
}
