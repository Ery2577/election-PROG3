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

            System.out.println("==========================");

        // Q4 - Synthèse globale des votes (une seule ligne)
        System.out.println("Question 4 : ");
        VoteSummary summary = retriever.computeVoteSummary();
        System.out.println(summary);

            System.out.println("==========================");

        // Q5 - Taux de participation
        System.out.println("Question 5 : ");
        double turnoutRate = retriever.computeTurnoutRate();

        System.out.println("Donc taux de participations = " + turnoutRate + "%");

            System.out.println("==========================");

        // Q6 - Résultat élection
        System.out.println("Question 6 : ");
        ElectionResult winner = retriever.findWinner();

        if (winner != null) {
            System.out.println(winner);
        } else {
            System.out.println("Aucun gagnant trouvé.");
        }

    }
}