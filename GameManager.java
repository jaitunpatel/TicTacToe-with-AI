import java.util.Random;
import java.util.Scanner;

// Controls the overall flow of the game
// This includes input, checking games states
// and initialization of the board itself. 
public class GameManager{
    // Shorthand for players
    public static final Agent playerX = new AIAgent('X');
    public static final Agent playerO = new PlayerAgent('O');

    // The board object itself. Holds game state. 
    private static TicTacToe board = new TicTacToe();
    private static Agent playersTurn;

    public static void main(String[] args){
        // Create the Game Manager object itself. 
        GameManager man = new GameManager(); 

        // start up game
        man.initGame();

        // Game loop (until game is over). 
        while(!man.isGameOver()){
            playersTurn.nextTurn(board); 
            System.out.println(board.toString());
            if(board.isTied()){
                System.out.println("Game is Draw");
                System.exit(0);
            }   else if(!man.isGameOver())
                man.nextPlayer();
        }
        // Quit.
        board.playerWon(playersTurn);
        System.out.println("Thanks for playing");
        System.exit(0);
    }

    // Initialize Game
    private void initGame(){
        // Get Board size
        int size = 0;
        boolean isValid = false;

        // Wait for input from the user. 
        while(!isValid){
            System.out.println("Enter the board size (default 3):");
            Scanner scan = new Scanner(System.in);
            size = scan.nextInt();

            // Check for valid inputs. 
            if(size <= 100 && size > 1){
                isValid = true;
            }
        }

        // Create the board itself. 
        board = new TicTacToe(size);

        // Create random number object to select first players turn. 
        Random rand = new Random();
        int turn = rand.nextInt(2);

        // Set current players turn. 
        if(turn==0){
            playersTurn=playerO;  
        }else{
            playersTurn=playerX;
        }

        // Print out the board. 
        System.out.println(board.toString());
        System.out.println(playersTurn.toString() + " Goes first");

    }

    /*
    private void nextTurn(){
    System.out.println("It is " + playersTurn + "\'s turn.");
    //if(playersTurn instanceof PlayerAgent){
    System.out.println("Enter the Row and Col: ");
    Scanner scan = new Scanner(System.in);
    int row = scan.nextInt();
    int col = scan.nextInt();
    // playersTurn.nextTurn(board);

    // Error checking here: 
    if(!board.isEmpty(row, col)){
    System.out.println("Illegal move. Space filled");
    return;
    }

    // Set new tile
    board.setTile(row, col, playersTurn);
    // Output board
    System.out.println(board.toString());
    // if game over, last player to move won, otherwise switch players. 
    if(board.gameOver()){
    playerWon(playersTurn);
    }else{
    nextPlayer();
    }
    }*/

    private void nextPlayer(){
        if(playersTurn.equals( playerX))
            playersTurn = playerO;
        else
            playersTurn = playerX;
    }

    private boolean isGameOver(){
        return board.gameOver();
    }

    private void playerWon(Agent playerThatWon){
        System.out.println( playerThatWon.toString() + " won the game!");
        System.exit(0);
    }
}