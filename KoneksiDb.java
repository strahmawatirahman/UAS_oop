import java.sql.*;

public class KoneksiDb {
    static Connection koneksi = null;

    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_data";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Terkoneksi");
            } catch (SQLException t) {
                System.out.println("Tidak bisa terkoneksi");
            }
        }
        return koneksi;
    }
}
