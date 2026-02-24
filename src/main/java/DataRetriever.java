import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    // Q1 : Affiche tout les votes
    public long countAllVotes() {

        long totalVotes = 0;
        String sql = "SELECT COUNT(*) AS total_votes FROM vote";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                totalVotes = rs.getLong("total_votes");
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return totalVotes;

    }

    private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }


    // Q2 : Affiche les votes selon leurs types
    public List<voteTypeCount> countVotesByType() {
        List<voteTypeCount> results = new ArrayList<>();

        String sql = "SELECT vote_type, COUNT(*) AS count FROM vote GROUP BY vote_type";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String typeStr = rs.getString("vote_type");
                long count = rs.getLong("count");

                VoteType type = VoteType.valueOf(typeStr.toUpperCase());
                results.add(new voteTypeCount(type, count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    // Q3 : Affiche le nombre de votes valides par candidat
    public  List<CandidateVoteCount> countValidVotesByCandidate() {
        List<CandidateVoteCount> results = new ArrayList<>();

        String sql = "SELECT c.name AS candidate_name, COUNT(v.id) AS valid_vote " +
                "FROM candidate c " +
                "LEFT JOIN vote v ON c.id = v.candidate_id AND v.vote_type = 'VALID' " +
                "GROUP BY c.name " +
                "ORDER BY valid_vote ";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("candidate_name");
                long count = rs.getLong("valid_vote");

               results.add(new CandidateVoteCount(name, count));
            }
        } catch (SQLException e) {
            System.out.println("Erreur Q3 : " + e.getMessage());
        }
        return results;
    }


    // Q4 - Synthèse globale des votes (une seule ligne)
    public VoteSummary computeVoteSummary() {
        String sql = "SELECT " +
                "(SELECT COUNT(*) FROM vote WHERE vote_type = 'VALID') AS valid_count, " +
                "(SELECT COUNT(*) FROM vote WHERE vote_type = 'BLANK') AS blank_count, " +
                "(SELECT COUNT(*) FROM vote WHERE vote_type = 'NULL') AS null_count";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return new VoteSummary(
                        rs.getLong("valid_count"),
                        rs.getLong("blank_count"),
                        rs.getLong("null_count")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur Q4 : " + e.getMessage());
        }
        return new VoteSummary(0, 0, 0);
    }

    // Q5 - Taux de participation
    public double computeTurnoutRate() {
        long totalVotes = this.countAllVotes();
        long totalVoters = 0;

        String sql = "SELECT COUNT(*) AS total_voters FROM voter";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                totalVoters = rs.getLong("total_voters");
            }

            System.out.println("_ Nombre total d’électeurs : " + totalVoters);
            System.out.println("_ Nombre de votes enregistrés : " + totalVotes);

            if (totalVoters == 0) return 0.0;

            return ((double) totalVotes / totalVoters) * 100.0;

        } catch (SQLException e) {
            System.out.println("Erreur Q5 : " + e.getMessage());
        }
        return 0.0;
    }

    // Q6 - Résultat élection
    public ElectionResult findWinner() {
        String sql = "SELECT c.name AS candidate_name, COUNT(v.id) AS valid_vote_count " +
                "FROM candidate c " +
                "JOIN vote v ON c.id = v.candidate_id " +
                "WHERE v.vote_type = 'VALID' " +
                "GROUP BY c.name " +
                "ORDER BY valid_vote_count DESC " +
                "LIMIT 1";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return new ElectionResult(
                        rs.getString("candidate_name"),
                        rs.getLong("valid_vote_count")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur Q6 : " + e.getMessage());
        }
        return null;
    }
}