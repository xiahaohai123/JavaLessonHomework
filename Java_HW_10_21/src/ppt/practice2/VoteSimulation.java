package ppt.practice2;

/**
 * @PackageName:ppt.practice2
 * @ClassName:VoteSimulation
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/21 16:24
 */
public class VoteSimulation {
    public static void main(String[] args) {
        // 票箱记录
        VoteCounter voteCounter = new VoteCounter();

        Voter[] voters = new Voter[150];
        for (int i = 0; i < voters.length; i++) {
            voters[i] = new Voter();
        }

        for (Voter voter : voters) {
            if (voteCounter.vote(voter) == -1) {
                System.out.println("票仓已满，停止投票");
                break;
            }
        }

    }
}
