package ma.chat.tp5poo.dao;

import java.sql.*;

public class SingletonConnexionDB {
    private static Connection connection;

    public SingletonConnexionDB() {}

    static {
        try {
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/prof_dep", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static Connection getConnection() {
        return connection;
    }
}


