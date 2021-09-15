import java.util.*;
import java.util.Scanner;
public class AIAgent extends Agent
{    
    //constructor
    public AIAgent(char agentChar){
        super(agentChar);
    }

    //this method Override the nextTurn method in GameManager
    @Override
    public void nextTurn(TicTacToe board){
        // this will search for a move to make
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board.size(); j++){
                //if there is empty spot then it will make a move
                if(board.getTile(i,j)=='.'){
                    board.setTile(i,j,this);    
                    return;
                }
            }
        }

        /*
        int min = 0;
        int finalMin = 1000000;
        int tempR = 0;
        int tempC = 0;

        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board.size(); j++){
                //if there is empty spot then it will make a move
                min = search(board , i , j , 0);

                if(min < finalMin)
                {
                    finalMin = min;
                    tempR = i;
                    tempC = j;
                }
            }
        }
        board.setTile(tempR , tempC , this);*/
    }    

    // recursive method
    private int search(TicTacToe clone, int row, int col, int depth){
        //temporary variable
        int minMoves=100000;
        TicTacToe boardClone = clone.deepCopy();
        boardClone.setTile(row , col , this);

        if(clone.getTile(row , col) != '.')
        {
            minMoves = -1;
        }
        else if(boardClone.isTied())
        {
            minMoves = 100000;
        }
        else if(boardClone.gameOver())
        {
            minMoves = depth;
        }
        else if((row + 1) < clone.size() && (col + 1) < clone.size())
        {
            depth = depth + 1;

            int minMoves1 = search(boardClone , row , col + 1 , depth);
            int minMoves2 = search(boardClone , row + 1 , col + 1 , depth);
            int minMoves3 = search(boardClone , row + 1 , col , depth);

            int minMovesTemp = Math.min(minMoves1 , minMoves2);
            minMoves = Math.min(minMovesTemp , minMoves3); 

        }
        return minMoves;
    }
}