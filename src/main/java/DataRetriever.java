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
}