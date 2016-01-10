package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by Kairi on 18.12.2015.
 *
 * Main window.
 */

public class Reader extends Application {

    Stage window;
    Scene scene1, scene2;
    ListView<String> ListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Fiider");
        window.getIcons().add(new Image(Reader.class.getResourceAsStream("fiiderlogo6.jpg")));

        BorderPane borderpane = new BorderPane();

        ArrayList newsItem = new ArrayList<>();

        //Main window items

        //Button 1 which takes to Guide and returns
        Button button1 = new Button("Juhis");


        //Checkboxes - actions to add
        CheckBox chk1 = new CheckBox("Intro");
        URL purr = Reader.class.getResource("Professional_Jazz_Guitar_Samples.wav"); //https://www.youtube.com/watch?v=tION5wkvsLo&index=2&list=PL04C8F6434A8E2F4F (00:00:18-00:00:21)
        AudioClip click = Applet.newAudioClip(purr); //Praegu mängib Manowari ja jazzi. Siia tahaks panna voiceoveri tegelikult :D
        chk1.setOnAction(event1 -> click.play());


        // Checbox "A" changes window theme to Accessibility mode (larger font) //Sama saaks stagidega Stage'i vahetus stage1.close() stage2.show()
        CheckBox chk2 = new CheckBox("A");
        chk2.setOnAction(event1 -> {

            scene1.getStylesheets().add(
                    getClass().getResource("UusStyleSheet_Accessibility.css")
                            .toExternalForm());
        });

        // Scrollpane on the right side of the main window https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html

        Rectangle rect = new Rectangle(200, 5000);
        rect.setStroke(Color.WHITE);
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(rect);
        scroll.setFitToWidth(true);

        ListView = new ListView<>();  // https://www.youtube.com/watch?v=GbzKr46VvD0
        ListView.getItems().addAll("Fiid1", "Fiid2", "Fiid3");
        ListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //Colorpicker widget. Enables to change background color of the main window.

        ColorPicker colorpicker = new ColorPicker();
        Color c = colorpicker.getValue();
        colorpicker.setOnAction(e ->
                rect.setFill(colorpicker.getValue()));


        // Button addNewfeed calls dialogbox, asks input.
        // Used examples from following site: http://stackoverflow.com/questions/22166610/how-to-create-a-popup-windows-in-javafx

        Button addNewFeed = new Button("+");
        addNewFeed.setOnAction(event1 -> {

            AddFeedInputbox.display("Kas oled kindel?","Nonoh");

        });

        //Button removeFeed removes inserted feed (name + address) from the list
        Button removeFeed = new Button("Kustuta aadress");
        removeFeed.setOnAction(event -> {
            JOptionPane.showMessageDialog(null, "Kas olete kindel?"); //Message Dialog https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html;

        });




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
                colorpicker,
                new Separator(),
                new Separator(),
                new Separator(),
                addNewFeed,
                removeFeed,
                new Separator(),
                new Separator()
        );


        //Feedwindow in the center. Displays unpacked feed items - title of the feed, link and summary.

        VBox feedWindow = new VBox();
        feedWindow.setSpacing(5);
        feedWindow.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        Text titlearea = new Text();
        Text descriptionarea = new Text();
        Text linkarea = new Text();

        feedWindow.getChildren().addAll(titlearea, descriptionarea, linkarea);


        // Buttons and things alltogether to BorderPane
        borderpane.setTop(toolBar1);
        borderpane.setRight(scroll);
        borderpane.setCenter(feedWindow);
        Scene scene1 = new Scene(borderpane, 800, 600);
        borderpane.getChildren().addAll(ListView);

        //Button 2. Takes from scene2 back to scene 1. https://www.youtube.com/watch?v=7LxWQIDOzyE
        Button button2 = new Button("Tagasi");
        button2.setAlignment(Pos.BASELINE_CENTER);
        button2.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
        button2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        button2.setOnAction(e -> window.setScene(scene1));

        Label label = new Label("      Juhised on siin ...");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Harlow Solid Italic", 20));//font
        label.setStyle("-fx-text-fill: white;");


        Text text = new Text(20, 100, " \n" +
                " Mis on RSS? \n" +
                "\n" +
                "\n" +
                "RSS (ingliskeelne lühend sõnadest Rich Site Summary või Really Simple Syndication) \n" +
                "on XML-il põhinev andmevorming (uudistevoo vormingu standard)Internetis kasutamiseks, \n" +
                "peamiselt veebilehtede sisukorra või uudiste kokkuvõtete tegemiseks. \n" +
                "\n" +
                "\n" +
                "Viimasel ajal on RSSi üha rohkem hakatud kasutama ka meeskonnatöövahendites paljusid \n" +
                "meeskonnaliikmeid puudutava info edastamiseks. Tavaliselt koostatakse uudisvoog \n" +
                "(ingl.k RSS-feed) internetilehekülje või mõne muu seotud allika muutumisel automaatselt.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Kuidas programmi kasutada? \n" +
                "\n" +
                "\n" +
                "RSS lugeja käivitamiseks tuleb alustada soovitud aadressi lisamisega. Selleks vali menüüribalt \n" +
                "nupp + ja sisesta aadress, mida soovid jälgima hakata. Aadress tuleb sisestada URL kujul. \n "+
                "\n" +
                "\n" +
                "    Nüüd kuvatakse paremal uudislisti. Kikkides huvipakkuvale pealkirjale, kuvatakse valitud uudis peaaknas. \n" +
                "  Üks uudis koosneb pealkirjast ja uudise lühikokkuvõttest. Lisaks kuvatakse valitud uudisele \n" +
                "otselinki, mis annab võimaluse huvipakkuvat uudist kiirelt ja mugavalt üles leida ja lähemalt lugeda. \n" +
                "RSS lugeja aitab hoida kokku väärtuslikku aega koondades ja kuvades erinevate kanalite uudisvood \n " +
                "Sinu töölaual. \n" +
                "\n" +
                "\n" +

                "");


        //text.setFont(new Font("Arial", 10));
        text.setStyle("-fx-font: 16 arial;");
        text.setStyle("-fx-text-fill: white;");
        text.setTextAlignment(TextAlignment.CENTER);

        VBox vboxjuhis = new VBox();
        vboxjuhis.setStyle("-fx-background-color: #FF6600; -fx-text-fill: white;");
        vboxjuhis.getChildren().addAll(button2, label, text);

        Scene scene2 = new Scene(vboxjuhis, 570, 600);
        button1.setOnAction(e -> window.setScene(scene2));

        //Display scene1 at first
        window.setScene(scene1);
        window.show();


    }
}


