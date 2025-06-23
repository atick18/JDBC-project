import java.sql.*;

public class MyDBClass {

    protected Connection connection;
    protected PreparedStatement ps;
    protected ResultSet rs;

    public MyDBClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ updated
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        try {
            connection = DriverManager.getConnection(url, "root", "8265");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeAll() {
        try {
            if (this.rs != null) rs.close();
            if (this.ps != null) ps.close();
            if (this.connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
