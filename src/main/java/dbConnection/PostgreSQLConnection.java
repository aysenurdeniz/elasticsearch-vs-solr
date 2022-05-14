/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aysenurdeniz
 */
public class PostgreSQLConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/playStore", "postgres", "4488");
            //System.out.println("Connection Success!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
