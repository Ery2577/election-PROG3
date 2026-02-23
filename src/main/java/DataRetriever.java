import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetriever {

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


}
