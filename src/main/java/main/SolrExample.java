/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dbConnection.CassandraConnection;
import dbConnection.PostgreSQLConnection;
import indexing.ByPostgreSQL;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import methods.ESMethods;
import methods.SolrMethods;
import org.apache.solr.client.solrj.SolrServerException;
import timer.Timer;

/**
 *
 * @author aysenurdeniz
 */
public class SolrExample {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.apache.solr.client.solrj.SolrServerException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, SolrServerException, ClassNotFoundException, InterruptedException {

//        String query1 = "Sentiment_Polarity:0.5*";
        //QueryMethods sınıfındaki metotları çağırmak için oluşturulan methods nesnesi
//        SolrMethods methods = new SolrMethods();
        //ESMethods eSMethods = new ESMethods();
        
        CassandraConnection cassandraConnection = new CassandraConnection();
        try {
            cassandraConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SolrExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Timer.start();
//        eSMethods.queryEigth();
//        eSMethods.print();
        Timer.stop();

//        PostgreSQLConnection connection = new PostgreSQLConnection();
//        connection.connect();
//        connection.indexingPostgreSQLData();
//        ByPostgreSQL bpsql = new ByPostgreSQL();
//        bpsql.indexingPostgreSQLData();
        /*Çalışma süresi hesaplanmak istenen kod Timer.start() ve Timer.stop() 
        arasına yazılmaktadır.*/
        //for (int i = 0; i < 10; i++) {
//            Timer.start();
//            methods.querySeven();
//            methods.print();
//            Timer.stop();

        //System.out.println("Sorgu çalisirken geçen süre: " + Timer.getElapsedMilliseconds());
        //}      
    }

}
