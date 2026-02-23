public class Main {
    public static void main(String[] args) {
       // Pour afficher tout les votes dans l'election
        DataRetriever retriever = new DataRetriever();
        long totalVotes = retriever.countAllVotes();

        System.out.println("All vote = " + totalVotes);
    }
}