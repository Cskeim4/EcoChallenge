package EcoChallenge;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Eco Challenge FXML controller class, manages all of the FXML components and their functions
 * @author c.skeim
 */
public class FXMLController implements Initializable{
    // Controls added in the GUI
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField levelTextField;
    @FXML
    private TextField goalDateTextField;
    
    @FXML
    private ListView ecoListView;
    
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    
    // The list of challenge names to be viewed in the list view as received from the extractor method
    private ObservableList<Challenge> challengeList = FXCollections.observableArrayList(Challenge.extractor);
    
    // Handles changes to the list view, and sends an alert when a challenge is selected
    private ChangeListener<Challenge> challengeChangeListener;
    
    // Variable that holds the challenge that is currently selected 
    private Challenge selectedChallenge;
    
    // Called when the program first starts.
    /**
     * Initialize method, sets up the initial screen
     * @param url, takes in the URL as a parameter
     * @param rb, takes in the resources needed to set up the initial stage for the application
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        // Hard code to show in the list view on the application interface
        challengeList.add(new Challenge("Pick Up Litter", 1, "6/01/2021"));
        challengeList.add(new Challenge("Bring Your Own Reusable Bag", 2, "7/01/2021"));
        challengeList.add(new Challenge("Visit a Thrift Store", 1, "06/01/2021"));
        challengeList.add(new Challenge("Set-Up Compost", 3, "9/30/2021"));
        challengeList.add(new Challenge("Say No To Straws", 2, "7/01/2021"));
        challengeList.add(new Challenge("Do an Upcycle Craft", 2, "8/01/2021"));
        challengeList.add(new Challenge("Trash Audit", 3, "8/30/2021"));
        challengeList.add(new Challenge("Visit a Coop/Bulk Store", 1, "7/30/2021"));
        challengeList.add(new Challenge("Find a Plastic Bag Recycling Drop Off", 2, "05/30/2021"));
        challengeList.add(new Challenge("Walk or Carpool", 2, "06/30/2021"));
        ecoListView.setItems(challengeList);
        
        // Listens for changes in the data, and sets the text fields if they are not null
        ecoListView.getSelectionModel().selectedItemProperty().addListener(
            challengeChangeListener = (observable, oldValue, newValue) -> {
                // Set the selected challenge variable to the challenge that is currently selected
                selectedChallenge = newValue;
                
                if (newValue != null) {
                    // Take input data and push it to the grid in the GUI
                    nameTextField.setText(selectedChallenge.getChalName());
                    levelTextField.setText("" + selectedChallenge.getChalLevel());
                    goalDateTextField.setText(selectedChallenge.getChalGoalDate());
                    
                    
                }
                else {
                    //Put an empty field in the text fields, if a challenge is not selected
                    nameTextField.setText("");
                    levelTextField.setText("");
                    goalDateTextField.setText("");
                }
            }
        );
        
        // Set when the buttons should be enabled or disabled
        
        // Add Button, disable when the text field is empty and there is nothing to add to the list
        buttonAdd.disableProperty().bind(
            nameTextField.textProperty().isEmpty());
        
        // Update and Delete Buttons
        buttonUpdate.disableProperty().bind(ecoListView.getSelectionModel().selectedItemProperty().isNull());
        buttonDelete.disableProperty().bind(ecoListView.getSelectionModel().selectedItemProperty().isNull());
    }

    /**
     * Add button Action Method, handles when the add button is pressed 
     * @param actionEvent, takes in the button click event
     */
    @FXML
    private void buttonAddAction(ActionEvent actionEvent) {
        // Get data from GUI components 
        String chalName = nameTextField.getText();
        int level = Integer.parseInt(levelTextField.getText());
        String chalGoalDate = goalDateTextField.getText();
        
        // Create a Challenge object to store the data in 
        Challenge challenge = new Challenge(chalName, level, chalGoalDate);
        
        // Add the challenge to the challenge list 
        challengeList.add(challenge);
        
        // Select the challenge from the list
        ecoListView.getSelectionModel().select(challenge);
    }

    /**
     * Update Button Action Method, handles update(save) button events 
     * @param actionEvent, takes in the button click action for the save button 
     */
    @FXML
    private void buttonUpdateAction(ActionEvent actionEvent) {
        // Get the selected challenge from the challenge list 
        Challenge challenge = (Challenge) ecoListView.getSelectionModel().getSelectedItem();
        
        // While data is being updated, disable the change listener
        ecoListView.getSelectionModel().selectedItemProperty().removeListener(challengeChangeListener);
        
        // Get the updated challenge data from the text fields in the application
        String chalName = nameTextField.getText();
        int level = Integer.parseInt(levelTextField.getText());
        String chalGoalDate = goalDateTextField.getText();
        
        // Change the data in the challenge object selected 
        challenge.setChalName(chalName);
        challenge.setChalLevel(level);
        challenge.setChalGoalDate(chalGoalDate);
        
        // Once data is done being updated for the challenge, add the listener back in
        ecoListView.getSelectionModel().selectedItemProperty().addListener(challengeChangeListener);
    }   

    /**
     * Delete action method, handles events where the user clicks the delete button
     * @param actionEvent, takes the delete button click event in for the delete button as an action event
     */
    @FXML
    private void buttonDeleteAction(ActionEvent actionEvent) {
        // Delete the selected challenge from the challenge list
        challengeList.remove(selectedChallenge);
    }
}
