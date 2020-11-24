package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Circle;
import worldofzuul.Character;

public class PoorroomController {

    @FXML private Button poorChild;

    @FXML private Circle apple;

    @FXML
    private TextField text;
    public void talkPoorChild() {
        poorChild.getId();
        // Somehow call getCharMessage from Game class with button id as argument. Make sure char name == buttonid
        text.setText("Jeg er sulten"); // set text to getCharMessage return value

        // 
    }

    // TEST
     Character name = new Character("kaj","er sej");

    @FXML
    public void talkWoman(){

    }

    public void handleDragDetection(MouseEvent mouseEvent) {
        Dragboard db = apple.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString("Does not matter");
        db.setContent(content);

        mouseEvent.consume();
    }
}
