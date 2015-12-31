package GUI;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Optional;

import static javafx.scene.paint.Color.*;

/**
 * Created by Kairi on 18.12.2015.
 */
public class Reader extends Application {
    Stage window;
    Scene scene1, scene2;
    private EventHandler<ActionEvent> actionEventEventHandler;

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
        CheckBox chk1 = new CheckBox("Intro");
        URL url = MyApp.class.getResource("Hail_And_Kill.wav");
        AudioClip click = Applet.newAudioClip(url);
        chk1.setOnAction(event1 -> click.play());



        CheckBox chk2 = new CheckBox("A");

        // Button add feed - action to add (Dialogbox, JavaFX8 peaks toetama)
        Button addNewFeed = new Button("+");


        //TextInputDialog testija = null;
        /*actionEventEventHandler = e -> addNewFeed;
        addNewFeed.setOnAction(actionEventEventHandler
                (new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                        System.out.println("Reader.handle");
                    }
                });
*/
        TextInputDialog testija = new TextInputDialog("Sisesta aadress");
        testija.setTitle("Feedi Sisestus");
        testija.setHeaderText( " Kas soovite sisestada aadressi? \n " +
                "Sisestage lahtrisse aadress, mida soovite jälgima hakata ja vajutage OK");
        testija.setGraphic(new ImageView(this.getClass().getResource("Hand_drawn.png").toString()));


        // Siit sai võetud malli: http://stackoverflow.com/questions/22166610/how-to-create-a-popup-windows-in-javafx

        addNewFeed.setOnAction(event -> testija.showAndWait());

        //https://www.iconfinder.com/iconsets/hand-drawn-icons litsentseeritud peab checkima

        /*ButtonType buttonTypeOK = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);


        //Järgnev ei tööta

        testija.getButtonType().setAll(buttonTypeOK, buttonTypeCancel);

       /Optional<ButtonType> result = testija.showAndWait();
        if (result.get() == buttonTypeOK){
            // ... Seda peaks nüüd salvestama ARRAYLISTI tegelikult: " + result.get());
        } else if (result.get() == buttonTypeCancel) {
            // ... kui valida Cancel ei juhtu midagi ja aken sulgub
        } else {
            //
        }
        */



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
                choosefeed,
                addNewFeed

        );

        choosefeed.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object newValue) -> {
                            System.out.println(newValue);

                        });

        //toolBar1.setStyle(Color.CORAL));
        /*toolBar1.setStyle("-fx-background-color: whitesmoke; -fx-text-fill: white;");
        "-fx-background-color: whitesmoke; -fx-text-fill: white;");
        //#001133   */


        // SCROLLPANE ON THE RIGHT

        Rectangle rect = new Rectangle(200, 400, Color.BISQUE);
        rect.setStroke(Color.WHITE);
        ScrollPane s1 = new ScrollPane();
        s1.setPrefSize(120, 120);
        s1.setContent(rect);


        //"FEEDWINDOW" CENTER, at least 3 different sections

        Pane feedWindow = new StackPane();
        feedWindow.setStyle("-fx-background-color: tomato; -fx-text-fill: black;");

        Text feedtext = new Text(

        );


        // method that adds buttons and things alltogether to BorderPane
        BorderPane borderpane = new BorderPane();
        borderpane.setTop(toolBar1);
        borderpane.setRight(rect);
        borderpane.setLeft(feedWindow);

        scene1 = new Scene(borderpane, 600, 400);


        //SCENE 2

        //Button 2
        Button button2 = new Button("Tagasi");
        button2.setAlignment(Pos.BASELINE_CENTER);
        button2.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
        button2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        button2.setOnAction(e -> window.setScene(scene1));


        Label label = new Label("Juhised on siin ...");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Harlow Solid Italic", 20));//font
       // label.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
        label.setStyle("-fx-text-fill: white;");


        // tules teha ümber selliseks http://stackoverflow.com/questions/16828341/how-to-justify-text-for-a-character-array-in-java
        Text text = new Text(20, 100, " \n" +
                " S I I A T U L E B P A L J U T E K S T I \n" +
                "\n" +
                "\n" +
                "RSS (ingliskeelne lühend sõnadest Rich Site Summary või Really Simple Syndication) \n" +
                "on XML-il põhinev andmevorming (uudistevoo vormingu standard)Internetis kasutamiseks, \n" +
                "peamiselt veebilehtede sisukorra või uudiste kokkuvõtete tegemiseks. \n" +
                "\n" +
                "\n" +
                "Viimasel ajal on RSSi üha rohkem hakatud kasutama ka meeskonnatöövahendites paljusid \n"+
                "meeskonnaliikmeid puudutava info edastamiseks. Tavaliselt koostatakse uudisvoog \n" +
                "(ingl.k RSS-feed) internetilehekülje või mõne muu seotud allika muutumisel automaatselt.\n" +
                        "\n");


        text.setFont(new Font("Arial", 10));//font
        text.setFill(WHITE);
        text.setTextAlignment(TextAlignment.CENTER);


        VBox vboxjuhis = new VBox();
        vboxjuhis.getChildren().addAll(label, text, button2);
        vboxjuhis.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        scene2 = new Scene(vboxjuhis, 420, 300); //akna suurus


        //KUVAMINE

        //Display scene1 at first
        window.setScene(scene1);
        window.setTitle("Fiider");
        window.show();
    }

}
