/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author aysenurdeniz
 */
public class ReviewsModel {

    private long id;
    private String App;
    private String Translated_Review;
    private String Sentiment;
    private String Sentiment_Polarity;
    private String Sentiment_Subjectivity;

    public ReviewsModel() {
    }

    public ReviewsModel(long id, String App, String Translated_Review, String Sentiment, String Sentiment_Polarity, String Sentiment_Subjectivity) {
        this.id = id;
        this.App = App;
        this.Translated_Review = Translated_Review;
        this.Sentiment = Sentiment;
        this.Sentiment_Polarity = Sentiment_Polarity;
        this.Sentiment_Subjectivity = Sentiment_Subjectivity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApp() {
        return App;
    }
    
    public void setApp(String App) {
        this.App = App;
    }

    public String getTranslated_Review() {
        return Translated_Review;
    }

    public void setTranslated_Review(String Translated_Review) {
        this.Translated_Review = Translated_Review;
    }

    public String getSentiment() {
        return Sentiment;
    }

    public void setSentiment(String Sentiment) {
        this.Sentiment = Sentiment;
    }

    public String getSentiment_Polarity() {
        return Sentiment_Polarity;
    }

    public void setSentiment_Polarity(String Sentiment_Polarity) {
        this.Sentiment_Polarity = Sentiment_Polarity;
    }

    public String getSentiment_Subjectivity() {
        return Sentiment_Subjectivity;
    }

    public void setSentiment_Subjectivity(String Sentiment_Subjectivity) {
        this.Sentiment_Subjectivity = Sentiment_Subjectivity;
    }

    @Override
    public String toString() {
        return "EntityModel{" + "id=" + id + ", App=" + App + ", Translated_Review=" + Translated_Review + ", Sentiment=" + Sentiment + ", Sentiment_Polarity=" + Sentiment_Polarity + ", Sentiment_Subjectivity=" + Sentiment_Subjectivity + '}';
    }
    
}
