import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRetriever retriever = new DataRetriever();

        // Q1: Pour afficher tout les votes dans l'election
        long totalVotes = retriever.countAllVotes();
        System.out.println("Question 1 : " );
        System.out.println("All vote = " + totalVotes);

        System.out.println("==========================" );

        // Q2 : Affiche le nombre de vote par type
        List<voteTypeCount> typeCounts = retriever.countVotesByType();
        System.out.println("Question 2 : " );
        System.out.println(typeCounts);
    }
}