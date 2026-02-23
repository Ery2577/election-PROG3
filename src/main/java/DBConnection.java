import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/achat";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Hery101005";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à PostgreSQL");
            return null;
        }
    }

    public static Connection getDBConnection() {
        return null;
    }
}