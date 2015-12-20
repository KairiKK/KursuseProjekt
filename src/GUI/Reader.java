package GUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Kairi on 18.12.2015.
 */
public class Reader extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
          //  VBox vbox = new VBox();
          //  Scene window = new Scene(vbox, 700, 500);

        // vbox.setSpacing(8);
        // vbox.setBackground(2);
        // vbox.backgroundProperty
        // Color.rgb(255, 255, 255);
        // window.setBackground(Color.rgb(22, 22, 33, 32));

        //button.setVisible(true);

            ChoiceBox valik = new ChoiceBox(FXCollections.observableArrayList(
                    "Kanal 1", "Kanal 2", "Kanal 3"));


            //vbox.getChildren().addAll(
                    //valik
          //  );

           // primaryStage.setScene(window);
            primaryStage.show();

        // http://www.dummies.com/how-to/content/using-the-toolbar-class-in-javafx.html
        Button btn1 = new Button("Sisesta");
        Button btn2 = new Button("Kustuta");
        Button btn3 = new Button("Eralda");
       // btn1.setFont(Font.font("Harlow Solid Italic", FontWeight.BOLD, 12));
        CheckBox chk1 = new CheckBox("Teavita");
        CheckBox chk2 = new CheckBox("R");
        StackPane feed = new StackPane();
        feed.setAlignment(Pos.TOP_RIGHT);
        feed.setPrefSize(100, 100);

        ToolBar toolBar1 = new ToolBar();
        toolBar1.getItems().addAll(
                new Separator(),
                btn1,
                btn2,
                btn3,
                new Separator(),
                new Separator(),
                chk1,
                chk2,
                new Separator()
        );
        final BorderPane pane = new BorderPane();

        pane.setTop(toolBar1);
        pane.setRight(valik);
        pane.setLeft(feed);

        final Scene scene = new Scene(pane, 600, 400);
        pane.setStyle("-fx-background-color: rgb(56, 64, 90)");
        toolBar1.setStyle("-fx-background-color: rgb(255, 255, 255)");
        //btn1.setFont(Font.font("Harlow Solid Italic", FontWeight.BOLD, 12));
       // scene.setFill(Color.WHITE);

        valik.setPrefSize(200, 25);
        valik.setStyle("-fx-background-color: rgb(255, 255, 255)");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fiider");
        primaryStage.show();
    }
}

        //getContentPane().setBackground();
        /*btn1.setOnAction((event) -> {
        public void handle(ActionEvent e) { fileChooser.showOpenDialog(primaryStage);

        // Siia tegevus, kui vajutad nuppu
        }
        });
       // private Color background = new Color(55, 55, 55);
       // private Color textcolor = new Color(255, 255, 255);


/* static ObservableList toonid = // menyy
            FXCollections.observableArrayList();
    toonid.addAll(
            "kollane, roosa, sinine, must"
            );
    list.setPrefWidth(100);
    list.setPrefHeight(70);


   */


/*
How to get data stored in array after application has ended?
http://stackoverflow.com/questions/18827862/how-to-keep-data-stored-in-array-after-application-has-ended
*/
