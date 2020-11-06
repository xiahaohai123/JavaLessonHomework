package ppt.practice2;

/**
 * @PackageName:ppt.practice2
 * @ClassName:VoteCounter
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 16:25
 */
public class VoteCounter {
    private static final int MAX = 100;
    private int count = 0;

    /**
     * 投票方法
     *
     * @param voter 选民
     * @return 1表示投票成功 0表示投票失败：voter已投 -1表示票仓已满
     */
    public int vote(Voter voter) {
        if (count == MAX) return -1;
        if (voter.isHasVote()) {
            return 0;
        }

        voter.vote();
        count++;
        return 1;
    }
}
