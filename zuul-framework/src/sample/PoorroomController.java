package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.shape.Circle;
import worldofzuul.Character;

public class PoorroomController {

    @FXML private Button dreng;

    @FXML private Circle apple;

    @FXML
    private TextField text;
    public void talkPoorChild() {
        dreng.getId();
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

    public void handleDragDropped(DragEvent dragEvent) {
        /* data dropped */
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            text.setText(db.getString());
            success = true;
        }
        /* let the source know whether the string was successfully
         * transferred and used */
        dragEvent.setDropCompleted(success);

        dragEvent.consume();

    }
}
