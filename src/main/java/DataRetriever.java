import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetriever {
    private DBConnection dbConnection = new DBConnection();

    public long countAllVotes() {

        String sql =
                "" +
                    "SELECT COUNT(*) AS total_votes FROM vote" +
                "";


        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getLong("total_votes");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
