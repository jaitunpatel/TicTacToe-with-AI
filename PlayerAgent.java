import java.util.Scanner;
public class PlayerAgent extends Agent
{    
    //constructor
    public PlayerAgent(char agentChar){
        super(agentChar);
    }

    //this method Override the nextTurn method in GameManager
    @Override
    public void nextTurn(TicTacToe board){
        //creates scanner object for user input
        Scanner scan=new Scanner(System.in);

        //ask the user to enter row
        System.out.println("Enter Row: ");
        int row=scan.nextInt();

        //ask the user to enter col
        System.out.println("Enter Col: ");
        int col=scan.nextInt();

        //it will set the position in board
        if( row < board.size() && col < board.size()){  
            if(board.getTile(row,col)=='.'){
                board.setTile(row,col,this);
            }   else {
                System.out.println("Invalid Move!!. Space filled");              
                nextTurn(board);
            }                       
        }     
        
        //checks if the entered row or col is out of bound
        if(row>=board.size() || col>=board.size()){
            System.out.println("Index out of Bound: Next Player's Turn!");
        }
    }
}
