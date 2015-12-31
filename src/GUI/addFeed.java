package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Created by Kairi on 31.12.2015.
 *
 * @author https://www.youtube.com/watch?v=SpL3EToqaXA
 */
public class addFeed {
    public static void display(String title, String message) {
        Stage addFeed = new Stage();
        addFeed.initModality(Modality.APPLICATION_MODAL);
        addFeed.setTitle("Sisestus");
        //input.setPromptText("Sisesta aadress siia");



        Label label = new Label("Siseta aadress");


      Button saveButton = new Button("Kinnita");
        // saveButton.setOnAction(event1 -> { DialogPane.getContentText(); });


        Button deleteButton = new Button ("Tühista");
        deleteButton.setOnAction(event -> addFeed.close());

        VBox layout = new VBox(75);
        layout.getChildren().addAll(label, deleteButton, saveButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        addFeed.setScene(scene);
        addFeed.showAndWait();




    }
}



















