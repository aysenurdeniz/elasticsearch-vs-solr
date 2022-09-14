/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solrelastic;

import java.io.IOException;
import methods.ESMethods;
import methods.SolrMethods;
import org.apache.solr.client.solrj.SolrServerException;

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
     */
    public static void main(String[] args) throws IOException, SolrServerException, ClassNotFoundException {
    
        
        //ESMethods eSMethods = new ESMethods();
        // SolrMethods methodss = new SolrMethods();
        // cmdCommand.CmdCommand cc = new CmdCommand();
     
        // eSMethods.generalQuery("papers", "keywords", "*and*", 100);
        // System.out.println("++++++++++++++++++++++++++++++++++");
        // methodss.generalQuery("papers", "keywords:and", "100");
        //cc.IndexingCommand("curl http://localhost:8983/solr/reviews/update -H \"Content-Type: application/csv\" -T \"C:\\solr-8.11.1\\example\\wos-ect-journals-info.csv\" -X POST");
        //cc.IndexingCommand("curl http://localhost:9200/reviews/_doc/_bulk -H \"Content-Type: application/csv\" -T \"C:\\solr-8.11.1\\example\\wos-ect-journals-info.csv\" -X POST");
        //cc.IndexingCommand("curl -u admin:my_elastic_pass -H ‘Content-Type: application/json’ -XPOST ‘https://my-search-hieswgdbdgi8907fazkabdjknh.ap-south-1.es.amazonaws.com/myindex/_doc/_bulk?pretty' — data-binary @/path/output.json");

    }

}
