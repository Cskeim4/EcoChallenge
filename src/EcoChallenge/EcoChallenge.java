/*
 * @author Clara Skeim
 * Version 1
 * EcoChallenge Program Main Class
 * Description: This program allows the user to keep a list of eco-friendly/sustainable challenges.
 * The user can add, update, and delete challenges from the list.
 */

package EcoChallenge;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * EcoChallenge Class, starts up the scene and gets the FXML components 
 * @author c.skeim
 */
public class EcoChallenge extends Application{
    
    /**
     * Start method, gets the resources needed for the scene from the FXML doc
     * @param stage, sets the stage for the application
     * @throws Exception, throws an exception if the resources needed to start the scene do not exist
     */
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method, launches the application in the scene window
     * @param args, takes in string arguments 
     */
    public static void main(String[] args){
        launch(args);
    }
}
