package GUI;

import RSS_Connect.ConnectRSS;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.activation.URLDataSource;
import javax.naming.spi.StateFactory;
import javax.print.DocFlavor;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Optional;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import static javafx.scene.paint.Color.*;

/**
 * Created by Kairi on 18.12.2015.
 */
public class Reader extends Application {
    Stage window;
    Scene scene1, scene2;
    public Object url;
    private TextArea selectedDescription;


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


        //Checkboxes - actions to add
        CheckBox chk1 = new CheckBox("Intro");
        URL purr = MyApp.class.getResource("Hail_And_Kill.wav");
        AudioClip click = Applet.newAudioClip(purr);
        chk1.setOnAction(event1 -> click.play());


        // Sama saaks stagidega Stage'i vahetus stage1.close() stage2.show()
        CheckBox chk2 = new CheckBox("A");
        chk2.setOnAction(event1 -> {
            //scene1.getStylesheets().add("uus.css");
            
            scene1.getStylesheets().add(
                    getClass().getResource("UusStyleSheet_Accessibility.css")
                            .toExternalForm());
        });


        // Button addNewfeed calls Dialogbox // Siit sai võetud malli: http://stackoverflow.com/questions/22166610/how-to-create-a-popup-windows-in-javafx
        //ei oska sellega
        Button addNewFeed = new Button("+");
        Stage testija = new Stage();
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        Label headerText = new Label("Kas soovite sisestada aadressi? \n " +
                                     "Sisestage lahtrisse aadress, mida soovite jälgima hakata ja vajutage OK");

        TextField userInputField = new TextField();
        userInputField.setPromptText("Sisesta aadress");

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        headerText.setGraphic(new ImageView(this.getClass().getResource("mybutton.jpg").toString()));
        vbox.setPrefSize(450, 70);
        vbox.setSpacing(2);

        vbox.getChildren().addAll(headerText, userInputField, okButton, cancelButton);

        testija.setTitle("Sisestus");
        testija.setScene(scene);
        testija.setResizable(false);
        addNewFeed.setOnAction(event -> testija.showAndWait());


        okButton.setOnAction(event -> {
            userInputField.getText();
            String inputUrl = new String(String.valueOf(userInputField));

        });


        cancelButton.setOnAction(event -> {
            userInputField.setText("");

        });

       /* TextInputDialog testija = new TextInputDialog();
        testija.setTitle("Feedi Sisestus");
        testija.setHeaderText(" Kas soovite sisestada aadressi? \n " +
                "Sisestage lahtrisse aadress, mida soovite jälgima hakata ja vajutage OK");
        testija.setGraphic(new ImageView(this.getClass().getResource("mybutton.jpg").toString()));
        testija.setResizable(false);
        Button addNewFeed = new Button("+");
        addNewFeed.setOnAction(event -> testija.showAndWait());*/


        //Dialogbox response
        //Järgnev ei tööta

      /*  ButtonType buttonTypeCancel(); = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);

       // SEE NÄITAB ESIMESENA DIALOGBOXI ja prindib
        Optional<String> result = isEmpty();
        if (result.isPresent()){
            System.out.println(result.get());
        }
        */
        

        
        //meetod, et saada input - KÕIK NUPUD TULEKS ERALDI MEETODITEKS LÕHKUDA !!

        /*
        Optional<Object> result;
       // testija.showAndWait().ifPresent(response -> {
            if (result.isPresent() &&  response == ButtonType.OK) {
                System.out.println("sisu: " + result.get());
            }
        });

    Optional<TextInputDialog> result = testija.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        formatSystem();
    }
        /*String kasutajaInputUrl = testija.getResult();
                System.out.println(kasutajaInputUrl); */


     /* /if (result.isPresent()) {
            System.out.println("Your name: " + result.get());
        } else {
            System.out.println("VIGA");
        }*/



        /*class Handler extends URLStreamHandler {
            public ClassLoader classLoader;

            public Handler() {
                Optional<String> result = testija.showAndWait();
                this.classLoader = getClass().getClassLoader();
            }

            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                URL resourceUrl;
                resourceUrl = classLoader.getResource(u.getPath());
                if (resourceUrl == null)
                    throw new IOException("Resource not found: " + u);

                return resourceUrl.openConnection();
            }
        }

        */
        /*ButtonType buttonTypeOK = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        */


        ComboBox chooseFeed = new ComboBox();

        //Choicebox variant 1
        /* ChoiceBox choosefeed = new ChoiceBox (FXCollections.observableArrayList(
                "Kanal 1", "Kanal 2", "Kanal 3")); */

        /*ChoiceBox <String>choosefeed = new ChoiceBox <>();
        choosefeed.getItems().addAll();*/

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
                //choosefeed,
                addNewFeed

        );

      /*  choosefeed.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object newValue) -> {
                            System.out.println(newValue); }); */

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

        Text feedtext = new Text("TERE");


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
                "Viimasel ajal on RSSi üha rohkem hakatud kasutama ka meeskonnatöövahendites paljusid \n" +
                "meeskonnaliikmeid puudutava info edastamiseks. Tavaliselt koostatakse uudisvoog \n" +
                "(ingl.k RSS-feed) internetilehekülje või mõne muu seotud allika muutumisel automaatselt.\n" +
                "\n");


        text.setFont(new Font("Arial", 10));//font
        text.setFill(WHITE);
        text.setTextAlignment(TextAlignment.CENTER);


        VBox vboxjuhis = new VBox();
        vboxjuhis.getChildren().addAll(label, text, button2);
        vboxjuhis.setStyle("-fx-background-color: #FF6600; -fx-text-fill: white;");

        scene2 = new Scene(vboxjuhis, 420, 300); //akna suurus


        //Ikoon
        //Image ikoon = new Image("file:fiiderlogo1.jpg");
       // window.getIcons().add(new Image("resources/images/fiiderlogo1.jpg"));

        window.getIcons().add(new Image(Reader.class.getResourceAsStream("fiiderlogo6.jpg")));
        //KUVAMINE

        //Display scene1 at first
        window.setScene(scene1);
        window.setTitle("Fiider");
        window.show();
    }



    private void selectedDescription() {

       TextArea selectedDescription = new TextArea();
                selectedDescription.getChildrenUnmodifiable().addAll();

        System.out.println(selectedDescription);

    }



}