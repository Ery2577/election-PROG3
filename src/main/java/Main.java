import java.util.ArrayList;
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

        System.out.println("==========================" );

        // Q3 - Affiche le nombre de votes valide par candidat
        System.out.println("Question 3 : ");
        List<CandidateVoteCount> candidateVotes = retriever.countValidVotesByCandidate();

        List<Object> finalDisplayQ3 = new ArrayList<>();

        for (CandidateVoteCount cvc : candidateVotes) {
            finalDisplayQ3.add(cvc.getCandidateName() + "=" + cvc.getValidVoteCount());
        }

        System.out.println(finalDisplayQ3);

        // Q4 :
    }
}