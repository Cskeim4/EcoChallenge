/*
 * @author Clara Skeim
 * Version 1
 * EcoChallenge Program Challenge Class
 */

package EcoChallenge;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.util.Callback;

/** 
 * Challenge Class, to create challenge objects and set up instance variables and properties for challenges
 * @author c.skeim
 */
public class Challenge {
   
    //Instance variables
    private StringProperty chalName;
    private IntegerProperty chalLevel;
    private StringProperty chalGoalDate;
    
    
    /**
     * Default constructor for the creation of a challenge object
     */
    public Challenge(){
        
        chalName = new SimpleStringProperty(this, "chalName", "");
        chalLevel = new SimpleIntegerProperty(this, "chalLevel", 0);
        chalGoalDate = new SimpleStringProperty(this, "chalGoalDate", "");
        
    }
    
    /**
     * Constructor for creating challenge objects
     * @param inChalName, takes in the name of a challenge
     * @param inChalLevel, takes input for the challenge level
     * @param inChalGoalDate, takes in the goal completion date for the challenge
     */
    public Challenge(String inChalName, int inChalLevel, String inChalGoalDate){
        chalName = new SimpleStringProperty(this, "chalName", inChalName);
        chalLevel = new SimpleIntegerProperty(this, "chalLevel", inChalLevel);
        chalGoalDate = new SimpleStringProperty(this, "chalGoalDate", inChalGoalDate);
    }
    
    //Set-up Get, Property, and Set Methods
    
    /**
     * Get Method for the Challenge Name
     * @return chalName, returns the name of the challenge
     */
    public String getChalName(){
        return chalName.get();
    }
    
    /**
     * Property Method to get the entire challenge name property 
     * @return chalName, returns the entire challenge name property
     */
    public StringProperty chalNameProperty(){
        return chalName;
    }
    
    /**
     * Set Method for the Challenge Name
     * @param inChalName, takes input for the challenge name
     */
    public void setChalName(String inChalName){
        chalName.set(inChalName);
    }
    
    /**
     * Get Method for the Challenge Level (1,2 or 3)
     * @return chalLevel, returns the level of the challenge
     */
    public int getChalLevel(){
        return chalLevel.get();
    }
    
    /**
     Property Method to get the entire challenge level property 
     * @return chalLevel, returns the entire challenge level property
     */
    public IntegerProperty chalLevelProperty(){
        return chalLevel;
    }
    
    /**
     * Set Method for the Challenge Level
     * @param inChalLevel, takes input for the challenge level
     */
    public void setChalLevel(int inChalLevel){
        chalLevel.set(inChalLevel);
    }
    
    /**
     * Get Method for the Challenge Goal Completion Date
     * @return chalGoalDate, returns the goal completion date of the challenge
     */
    public String getChalGoalDate(){
        return chalGoalDate.get();
    }
    
    /**
     Property Method to get the entire challenge goal date property 
     * @return chalGoalDate, returns the entire challenge goal completion date property
     */
    public StringProperty goalDateProperty(){
        return chalGoalDate;
    }
    
    /**
     * Set Method for the Challenge Goal Completion Date
     * @param inChalGoalDate, takes input for the challenge goal date
     */
    public void setChalGoalDate(String inChalGoalDate){
        chalGoalDate.set(inChalGoalDate);
    }
    
    /**
     * To String method to get the challenge name and return it as a string
     * @return, returns the challenge name as a string in the list
     */
    @Override
    public String toString(){
        return chalName.getValue();
    }
    
    /**
     * Equals Method, checks if two objects(challenges) are the same
     * @param object, takes in the object to compare
     * @return areEqual, returns true or false depending if the objects are the same
     */
    @Override
    public boolean equals(Object object){
        boolean areEqual;
        
        if (this == object){
            areEqual = true;
        }
        else if (object == null){
            areEqual = false;
        }
        else if (getClass() != object.getClass()){
            areEqual = false;
        }
        else{
            Challenge other = (Challenge) object;
            
            if (getChalName().equals(other.getChalName())
                && getChalGoalDate().equals(other.getChalGoalDate())
                && getChalLevel() == other.getChalLevel()){
                areEqual = true;
            }
            
            else{
                areEqual = false;
            }
        }

        return areEqual;
    }
    
    /**
     * Extracts the challenge name from the challenge object to show in the list view
     */
    public static Callback<Challenge, Observable[]> extractor = p -> new Observable[]{
        p.chalNameProperty()
    };

    
}


