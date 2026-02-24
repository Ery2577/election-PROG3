public class ElectionResult {
    private String candidateName;
    private long validCountVote;

    public ElectionResult(String candidateName, long validCountVote) {
        this.candidateName = candidateName;
        this.validCountVote = validCountVote;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public long getValidCountVote() {
        return validCountVote;
    }

    public void setValidCountVote(long validCountVote) {
        this.validCountVote = validCountVote;
    }

    @Override
    public String toString() {
        return "ElectionResult{" +
                "candidateName='" + candidateName + '\'' +
                ", validCountVote=" + validCountVote +
                '}';
    }
}
