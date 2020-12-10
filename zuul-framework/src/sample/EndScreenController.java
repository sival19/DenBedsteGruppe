package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.*;

public class EndScreenController extends Main implements Initializable {

    @FXML
    Label endScore, highscores, title, highscore1, highscore2, highscore3, highscore4, highscore5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int userScore = getGame().getPlayer().totalPoints;
        endScore.setText(String.valueOf(userScore));

        writer(getName() + ": " + userScore + ";", "highscores.txt");

        // Read all high scores from file, and create a list with them as strings.
        String scores = reader("highscores.txt");
        String[] scoreList = scores.split(";");

        // Split the score strings into name:score pairs
        ArrayList<Map.Entry<String, String>> scoreMap = new ArrayList<>();
        for (String score : scoreList) {
            String[] scoreTuple = score.split(":");
            scoreMap.add(new java.util.AbstractMap.SimpleEntry<>(scoreTuple[0], scoreTuple[1].strip()));
        }

        // sort the list of pairs by score-value
        scoreMap.sort(Map.Entry.comparingByValue());

        // Make the list be in descending order.
        Collections.reverse(scoreMap);

        // Add the high scores to the scene
        highscore1.setText(scoreMap.get(0).getKey() + ": " + scoreMap.get(0).getValue());
        highscore2.setText(scoreMap.get(1).getKey() + ": " + scoreMap.get(1).getValue());
        highscore3.setText(scoreMap.get(2).getKey() + ": " + scoreMap.get(2).getValue());
        highscore4.setText(scoreMap.get(3).getKey() + ": " + scoreMap.get(3).getValue());
        highscore5.setText(scoreMap.get(4).getKey() + ": " + scoreMap.get(4).getValue());


        if (userScore < 20) {
            title.setText("Det var fandme ringe");

        } else if (userScore < 40) {
            title.setText("Det var ikke så godt");

        } else if (userScore < 60) {
            title.setText("meh");

        } else if (userScore < 80) {
            title.setText("Det var godt gået!");

        } else if (userScore < 100) {
            title.setText("Du er vist lidt af en helt!");

        }
    }
}
