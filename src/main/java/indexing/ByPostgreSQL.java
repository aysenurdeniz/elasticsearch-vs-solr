/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexing;

import dbConnection.PostgreSQLConnection;
import entity.EntityModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ByCassandra sınıfı ile bir design pattern kullan!
 *
 * @author aysenurdeniz
 */
public final class ByPostgreSQL {

    ArrayList<EntityModel> models = new ArrayList<>();
    EntityModel model;
    String query = "select * from google_play_store_user_reviews";

    public ByPostgreSQL() {

    }

    public List<EntityModel> getPostgreSQLData() throws ClassNotFoundException, SQLException {

        PreparedStatement ps = PostgreSQLConnection.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) { //next - Veriyi tek tek alıyor! 1000 1000 alınabilir mi?
            model = new EntityModel(
                    rs.getInt("id"),
                    rs.getString("app"),
                    rs.getString("translated_review"),
                    rs.getString("sentiment"),
                    rs.getString("sentiment_polarity"),
                    rs.getString("sentiment_subjectivity"));

            models.add(model);
        }
        return models;
    }

}
