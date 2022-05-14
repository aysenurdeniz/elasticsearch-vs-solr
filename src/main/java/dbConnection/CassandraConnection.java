/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aysenurdeniz
 */
public class CassandraConnection {

    public CassandraConnection() {
       
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection connection = null;
        try {
            Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
            connection = DriverManager.getConnection("jdbc:cassandra://localhost:9160/reviews");
            System.out.println("Connection Success!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;

    }
}
