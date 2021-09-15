import java.util.Scanner;
//This class will represent a single player of the game
// and contains instance varialbes and methods
public class Agent
{ 
    // instance variables
    private char agentChar;
    
    // this method will return whether it is 
    // "Agent X" or "Agent O" 
    public String toString(){
        return "Agent " + agentChar;
    } 
    
    // return variable from current Agent
    public char getPlayerChar(){
        return agentChar;
    }
    
    // constructor
    // this constructor sets agentChar variable to current Agent
    public Agent(char agentChar){
        this.agentChar=agentChar;
    }
    
    public boolean equals(Agent other){
        if(this.getPlayerChar() == other.getPlayerChar()){
            return true;
        }
        else 
            return false;
    }
    //this method will replace nextTurn method functionality in GameManager
    public void nextTurn(TicTacToe board){
        
    }
}
