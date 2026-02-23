public class Vote {

    private Integer id;
    private Integer candidate_id;
    private Integer voter_id;
    private VoteType vote_type;

    public Vote(Integer id, Integer candidate_id, Integer voter_id, VoteType vote_type) {
        this.id = id;
        this.candidate_id = candidate_id;
        this.voter_id = voter_id;
        this.vote_type = vote_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Integer candidate_id) {
        this.candidate_id = candidate_id;
    }

    public Integer getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(Integer voter_id) {
        this.voter_id = voter_id;
    }

    public VoteType getVote_type() {
        return vote_type;
    }

    public void setVote_type(VoteType vote_type) {
        this.vote_type = vote_type;
    }


    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", candidate_id=" + candidate_id +
                ", voter_id=" + voter_id +
                ", vote_type=" + vote_type +
                '}';
    }
}
