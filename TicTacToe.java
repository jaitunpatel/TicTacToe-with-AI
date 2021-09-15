
public class TicTacToe{

    private char[][] board = null;
    private int size;
    public static void main(String[] args){
        TicTacToe ttt = new TicTacToe();
        ttt.initBoard();
        System.out.println(ttt.toString());

    }
    // Basic game. 
    public TicTacToe(){
        board = new char[3][3];
        initBoard();
    }

    public TicTacToe(int size){
        board = new char[size][size];
        initBoard();
    }

    public TicTacToe(char[][] array){
        board = new char[array.length][array.length];
        for(int r = 0; r < array.length; r++){
            for(int c = 0; c < array[r].length; c++){
                board[r][c] = array[r][c];
            }
        }
    }

    // Set all entries in the board array to '.'
    // This will signify an empty tile. 
    private void initBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = '.';
            }
        }
    }

    public boolean isEmpty(int row, int col){
        return (board[row][col] == '.');
    }

    public char getTile(int row, int col){
        return board[row][col];
    }

    public void setTile(int row, int col, Agent player){
        if((row >= 0 && row < board.length) && (col >= 0 && col < board[row].length)){
            board[row][col] = player.getPlayerChar();
        }else{
            System.out.println("Error, invalid location entered:" + row + " " + col);
        }
    }

    //this method returns the size of board
    public int size(){
        return board.length;
    }

    //this method will check if space on board is 'X' or 'O'
    public boolean isTied(){  
        boolean bool=true;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j]=='.'){
                    bool=false;
                }                
            }
        }
        return bool;
    }

    // Is the game over?
    public boolean gameOver(){
        return checkRows() || checkCols() || checkDiagonal();
    }

    public void testGameOver(){
        boolean rows = checkRows();
        boolean cols = checkCols();
        boolean diag = checkDiagonal();

        System.out.println("Rows: " + rows + "  Cols: " + cols + " diag: " + diag);

    }

    private boolean checkRows(){
        // check each row. 
        for(int r = 0; r < board.length; r++){
            char first = board[r][0];
            boolean won = first != '.';
            for(int c = 1; c< board[r].length; c++){
                if(first != board[r][c]){
                    won = false;
                }
            }
            if(won){
                return won;
            }
        }
        return false;
    }

    private boolean checkCols(){
        // check each row. 

        for(int c = 0; c < board[0].length; c++){
            char first = board[0][c];
            boolean won = first != '.';
            for(int r = 1; r < board.length; r++){
                if(first != board[r][c]){
                    won = false;
                }
            }
            if(won){
                return won;
            }
        }
        return false;
    }

    private boolean checkDiagonal(){
        // top left to bottom right
        char first = board[0][0];
        boolean won = first != '.';

        // check top left to bottom right path. 
        for(int i = 0;i < board.length; i++){
            if(first != board[i][i]){
                won = false;
            }
        }

        // dont' need to check if we already won. 
        if(!won){
            // bottom left
            first = board[board.length-1][0];
            won = first != '.';

            //If any don't match, return false
            for(int i = 0; i < board.length; i++){
                if(first != board[board.length - (i+1)][i]){
                    won = false;
                }
            }   
        }

        return won;
    }

    public void playerWon(Agent playerThatWon){
        System.out.println("Player " + playerThatWon + " won the game!");
    }

    public String toString(){
        String output = "Current Board:";
        for(int r = 0; r < board.length; r++){
            output += "\n";
            for(int c = 0; c < board[r].length; c++){
                output += "[" + board[r][c] + "]";
            }
        }
        return output + "\n";
    }
    
    public TicTacToe deepCopy()
    {
        return new TicTacToe(this.board);
    }
}