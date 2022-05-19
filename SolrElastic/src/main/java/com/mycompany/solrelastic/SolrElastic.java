/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solrelastic;

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
public class SolrElastic {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.apache.solr.client.solrj.SolrServerException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, SolrServerException, ClassNotFoundException, InterruptedException {

 //      String query1 = "Sentiment_Polarity:0.5*";
        //QueryMethods sınıfındaki metotları çağırmak için oluşturulan methods nesnesi
        SolrMethods methodss = new SolrMethods();
        //ESMethods eSMethods = new ESMethods();
        
        methodss.generalQuery("App:Food AND Sentiment:Positive", "id, App", "id asc");


}