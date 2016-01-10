package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Kairi on 31.12.2015.
 *
 * https://www.youtube.com/watch?v=SpL3EToqaXA
 */
public class AddFeedInputbox {

    public static String answer;
    //stores answer
  //  public String answer;

    public static String display(String input, String message) {

        Stage addFeed = new Stage();
        addFeed.initModality(Modality.APPLICATION_MODAL);
        addFeed.setTitle("Sisestus");
        addFeed.setResizable(false);


        VBox inputboxlayout = new VBox();
        inputboxlayout.setAlignment(Pos.CENTER);
        inputboxlayout.setPrefSize(350, 180);
        inputboxlayout.setOpacity(40);
        inputboxlayout.setSpacing(2);

        Scene scene = new Scene(inputboxlayout);


        Label headerText = new Label("\n" + "  Kas soovite sisestada aadressi? \n " +
                "\n" +
                "  Sisestage aadress, mida soovite jälgima hakata \n" +
                "  ja vajutage Kinnita! \n " +
                "");
        headerText.setId("labell");

        TextField userInputField = new TextField();
        userInputField.setPromptText("Sisesta aadress");

        scene.getStylesheets().add(AddFeedInputbox.class.getResource("AddNewFeedDialog.css").toExternalForm());
        Button confirmButton = new Button("Kinnita");
        confirmButton.setId("button-ok");
        confirmButton.setOnAction(event -> {

                    try {

                       URL url = new URL(userInputField.getText()); //www.stackoverflow.com/questions/9909682/i-need-a-way-of-checking-a-url-is-valid-given-an-input
                       URLConnection conn = url.openConnection();
                       conn.connect();

                        if  (userInputField.getText().length() > 1)    {

                            //userInputField.getText().RSSConnection.class.inputUrl).
                            System.out.println("Trying to add new feed: " + userInputField.getText());
                            JOptionPane.showMessageDialog(null, "Uus feed lisatud!"); //Message Dialog https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                            userInputField.setText("");
                            
                        } else {

                            JOptionPane.showMessageDialog(null, "Täida jätkamiseks kõik väljad!");
                            addFeed.close();
                        }
                    } catch (MalformedURLException e) {
                       JOptionPane.showMessageDialog(null, "Aadress on vigane!");
                        System.out.println("Address not valid");
                       userInputField.clear(); // the URL is not in a valid form

                    } catch (IOException e) {
                       JOptionPane.showMessageDialog(null, "Ei saanud ühendust!");
                        userInputField.clear(); // the connection couldn't be established
           }

    });


        Button cancelButton = new Button ("Tühista");
        cancelButton.setOnAction(event -> {
            addFeed.close();
            System.out.println("Attempt cancelled");
        });


        headerText.setGraphic(new ImageView(Reader.class.getResource("mybutton.jpg").toString())); //handmade questionmark icon, made with GIMP
        inputboxlayout.getChildren().addAll(headerText, userInputField, confirmButton, cancelButton);
        addFeed.setScene(scene);
        addFeed.showAndWait();

        System.out.println(answer);
        return answer;


    }


}



















