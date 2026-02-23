public class voteTypeCount {
    private VoteType voteType;
    private long count;

    public voteTypeCount(VoteType voteType, long count) {
        this.voteType = voteType;
        this.count = count;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "voteTypeCount{" +
                "voteType=" + voteType +
                ", count=" + count +
                '}';
    }
}
