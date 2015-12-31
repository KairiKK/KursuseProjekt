package GUI;

import RSS_Connect.ConnectRSS;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Created by Kairi on 18.12.2015.
 */
public class Reader extends Application {
    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //TOOLBAR on top

        //Button 1
        Button button1 = new Button("Juhis");
        button1.setOnAction(e -> window.setScene(scene2));

        //Checkbox - actions to add
        CheckBox chk1 = new CheckBox("Teavita");
        CheckBox chk2 = new CheckBox("R");

       // Button add feed - action to add (Dialogbox, JavaFX8 peaks toetama)
        Button addfeed = new Button("+");                   //addfeed.setOnAction(event -> popuppeakstulemasiia);

        //Choicebox
        ChoiceBox choosefeed = new ChoiceBox(FXCollections.observableArrayList(
                "Kanal 1", "Kanal 2", "Kanal 3"));

        //Toolbar
        ToolBar toolBar1 = new ToolBar();
        toolBar1.getItems().addAll(
                new Separator(),
                button1,
                new Separator(),
                new Separator(),
                chk1,
                chk2,
                new Separator(),
                addfeed,
                choosefeed

        );

        // SCROLLPANE ON THE RIGHT

        Rectangle rect = new Rectangle(200, 400, Color.BLUEVIOLET);
        ScrollPane s1 = new ScrollPane();
        s1.setPrefSize(120, 120);
        s1.setContent(rect);

        // method that adds buttons and things alltoghther to borderpane
        BorderPane borderpane = new BorderPane();
            borderpane.setTop(toolBar1);
            borderpane.setRight(rect);

        scene1 = new Scene(borderpane, 600, 400);


        //"FEEDWINDOW" CENTER, at least 3 different sections






        //SCENE 2

        //Button 2
        Button button2 = new Button("Tagasi scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        button2.setAlignment(Pos.BOTTOM_CENTER);

        Label label = new Label("Juhised on siin");
        label.setAlignment(Pos.TOP_RIGHT);
        label.setFont(new Font("Harlow Solid Italic", 24));//font

        // tules teha ümber selliseks http://stackoverflow.com/questions/16828341/how-to-justify-text-for-a-character-array-in-java
        Text text = new Text("SIIA TULEB PALJU TEKSTi" +  "\n" + "\n" +
                "RSS (Rich Site Summary; originally RDF Site Summary; often called Really Simple Syndication) uses" +
                "a family of standard web feed formats[2] to publish frequently updated information: blog entries, " +
                "news headlines, audio, video. An RSS document (called \"feed\", \"web feed\",[3] or \"channel\") " +
                "includes full or summarized text, and metadata, like publishing date and author's name.\n" +
                "RSS feeds enable publishers to syndicate data automatically. A standard XML file format ensures " +
                "compatibility with many different machines/programs. RSS feeds also benefit users who want to receive" +
                " timely updates from favourite websites or to aggregate data from many sites.\n" +
                "\n" +
                "Subscribing to a website RSS removes the need for the user to manually check the website for new content. " +
                "Instead, their browser constantly monitors the site and informs the user of any updates. The browser can " +
                "also be commanded to automatically download the new data for the user.\n" +
                "\n" +
                "Software termed \"RSS reader\", \"aggregator\", or \"feed reader\", which can be web-based, desktop-based, " +
                "or mobile-device-based, presents RSS feed data to users. Users subscribe to feeds either by entering " +
                "a feed's URI into the reader or by clicking on the browser's feed icon. The RSS reader checks" +
                " the user's feeds regularly for new information and can automatically download it, if that function" +
                " is enabled. The reader also provides a user interface.");

        VBox vboxjuhis = new VBox();
        vboxjuhis.getChildren().addAll(label, text,button2);

        scene2 = new Scene(vboxjuhis, 300, 300);



        //KUVAMINE


        //Display scene 1 at first
        window.setScene(scene1);
        window.setTitle("Fiider");
        window.show();
    }

}
