package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.awt.*;
import java.net.URL;
import java.util.*;

public class EndScreenController extends Main implements Initializable {

    @FXML
    Label endScore, title, highscore1, highscore2, highscore3, highscore4, highscore5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Label[] highscoreIds = {highscore1, highscore2, highscore3, highscore4, highscore5};

        int userScore = getGame().getPlayer().totalPoints;
        endScore.setText(String.valueOf(userScore));

        writer(getName() + ": " + userScore + ";", "highscores.txt");

        // Read all high scores from file, and create a list with them as strings.
        String scores = reader("highscores.txt");
        String[] scoreList = scores.split(";");

        // Split the score strings into name:score pairs
        ArrayList<Map.Entry<String, Integer>> scoreMap = new ArrayList<>();
        for (String score : scoreList) {
            String[] scoreTuple = score.split(":");
            scoreMap.add(new java.util.AbstractMap.SimpleEntry<>(scoreTuple[0], Integer.valueOf(scoreTuple[1].strip())));
        }

        // Sort the list of pairs by score-value
        scoreMap.sort(Map.Entry.comparingByValue());

        // Make the list be in descending order.
        Collections.reverse(scoreMap);

        // Add the high scores to the scene
        int i = 0;
        while (highscoreIds.length > i && i < scoreMap.size()) {
            highscoreIds[i].setText(scoreMap.get(i).getKey() + ": " + scoreMap.get(i).getValue());
            i++;
        }


        if (userScore <= 20) {
            title.setText("Vi troede på dig, men vi tog fejl..., " + getName());

        } else if (userScore <= 40) {
            title.setText("Prøvede du overhovedet " + getName()+ " ?");

        } else if (userScore <= 60) {
            title.setText("Det var ikke så godt, " + getName());

        } else if (userScore <= 80) {
            title.setText("Det var godt gået!, "+ getName());

        } else if (userScore <= 100) {
            title.setText("Fantastisk, "+ getName() + "!");

        } else {
            title.setText("Fantastisk! Du er vist lidt af en helt " + getName() + "!");
        }
    }
}
