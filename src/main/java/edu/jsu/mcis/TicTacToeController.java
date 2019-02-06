package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener{

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this,width);
        
    }
    
    public String getMarkAsString(int row, int col){
        return (model.getMark(row, col).toString());
    }
    
    public TicTacToeView getView(){
        return view;
    }
    
    public void actionPerformed(ActionEvent event){
        //insert your code here
        JButton button = (JButton)(event.getSource());
        String buttonName = button.getName();
        int row = Integer.parseInt(buttonName.substring(6, 7));
        int col = Integer.parseInt(buttonName.substring(7, 8));
        if(model.makeMark(row, col)){
            button.setText(getMarkAsString(row,col));
            if(model.getResult() == model.getResult().X){
                view.showResult("X!");
                view.disableSquares();
            }
            else if (model.getResult() == model.getResult().O){
                view.showResult("O!");
                view.disableSquares();
            }
            else if (model.getResult() == model.getResult().TIE){
                view.showResult("TIE!");
                view.disableSquares();
            }
        }
    }
    
    
    /*@SuppressWarnings("empty-statement")
    public void start() {
    
        /* MAIN LOOP (repeats until game is over) */

        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */

        // INSERT YOUR CODE HERE
        //while (!(model.isGameover())){
            //view.showBoard(model.toString());
            //TicTacToeMove m = view.getNextMove(model.isXTurn());
        
            //boolean result = model.makeMark(m.getRow(),m.getCol());
            
            //if (!result){
       
                //view.showInputError();
            //}
       
        //};
        
        /* After the game is over, show the final board and the winner */

        //view.showResult(model.getResult().toString());
        
    //}
}
