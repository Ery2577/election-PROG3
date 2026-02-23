public class Main {

    public class Main {
        public static void main(String[] args) {
            VoteRepository voteRepository = new VoteRepository();
            long totalVote = voteRepository.countAllVotes();
            System.out.println("totalVote=" + totalVote);
        }
}
