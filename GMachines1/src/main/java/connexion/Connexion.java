package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static String login = "wfxzmfbbnadlme";
    private static String password = "1aec3874cf951b03e1c5357321acc2ebea4aa8d0947d25a2aa33b7d04c8f1d90";
    private static String url = "jdbc:postgres://wfxzmfbbnadlme:1aec3874cf951b03e1c5357321acc2ebea4aa8d0947d25a2aa33b7d04c8f1d90@ec2-54-175-147-69.compute-1.amazonaws.com:5432/d789m6upo45shc";
    private Connection connection;
    private static Connexion instane;

    private Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver introvable");
        } catch (SQLException e) {
            System.out.println("Connexion errror");
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connexion getInstane() {
        if (instane == null) {
            instane = new Connexion();
        }
        return instane;
    }

}
