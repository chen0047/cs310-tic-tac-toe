package edu.jsu.mcis;

import edu.jsu.mcis.TicTacToeModel.Mark;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for (int row = 0; row < width; ++row){
            for (int col = 0; col < width; ++col){
                board [row][col]= Mark.EMPTY;
            }
        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
        if (isValidSquare(row,col)){
            
            if (xTurn){
                
                board[row][col] = Mark.X;
            }
            else{
                
                board[row][col] = Mark.O;
            }
            
            xTurn = !xTurn;
            return true;
        }
        return false;
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        if ((row >= 0) && (row < width) && (col >= 0) && (col < width) && (!isSquareMarked(row,col))){
            return true;
        }
        else{
            return false;
        }
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /******* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE 
        
        if(board[row][col] != Mark.EMPTY){
            return true;
        }
        /*if(isValidSquare(row,col)){
            
            return (board[row][col] != Mark.EMPTY);
        }*/
        else{
            return false;
        }
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE

        return board[row][col];
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        
        if (isMarkWin(Mark.X)){
            return Result.X;
        }
        else if (isMarkWin(Mark.O)){
            return Result.O;
        }
        else if (isTie()){
            return Result.TIE;
        }
        else{
            return Result.NONE;
        }
     
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
        int count = 0;
        
        for (int row = 0; row < width; ++row){
            for (int col = 0; col <width; ++col){
                if (getMark(row,col).equals(mark)){
                    ++count;
                }
                
            }
            if (count == width){
                    return true;
                }
                else{
                    count = 0;
                }
        }
        
        count = 0;
        
        for(int col = 0; col < width; ++col){
            for (int row = 0; row < width; ++row){
                if (getMark(row,col).equals(mark)){
                    ++count;
                }
            }
            
            if(count == width){
                return true;
            }
            else{
                count = 0;
            }
        } 
        
        count = 0;
        
        for(int row= 0; row < width; ++row){
            if(board[row][width - row -1].equals(mark)){
                ++count;
            }
        }
        
        if (count == width){
            return true;
        }
        else{
            count = 0;
        }
        
        count = 0;
        
        for(int row = 0; row < width; ++row){
            if (board[row][row].equals(mark)){
                ++count;
            }
        }
        if(count == width){
            return true;
        }
        else{
            count = 0;
        }
        return false; 

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
        boolean tie = true;
        boolean empty = false;
        
        for (int row = 0; row < width; ++row){
            for (int col = 0; col < width; ++col){
                
                if (board[row][col] == Mark.EMPTY){
                    empty = true;
                }
            }
        }
        
        
        if(!empty){
            if(isMarkWin(Mark.X) || (isMarkWin(Mark.O))){
                return false;
            }
            else{
                return true;
            } 
        }
        
        return false;
        
        
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
       
        for(int h = 0; h < width; ++h){
            output.append(h);
        }
        
        output.append("\n");
        for(int row = 0; row < width; ++row){
            
            output.append(row).append(" ");
            
           for (int col = 0; col < width; ++col){

               output.append(board[row][col]);
           }
           output.append("\n");

        }

        return output.toString();        
    }

        
    }
    

