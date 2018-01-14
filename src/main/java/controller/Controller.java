package controller;

import model.Game;
import model.State;
import model.Turn;
import view.ConsoleBoardView;

public abstract class Controller {

    private Game game;

    protected Controller(Game game) {
        assert game != null;
        this.game = game;
    }
    
    public abstract void control();
    
    protected State getState(){
        return game.getState();
    }
    
    protected void setState(State state){
        assert state != null;
        game.setState(state);
    }
        
    protected Game getGame(){
        return game;
    }
    
    
    protected ConsoleBoardView getBoard() {
        return game.getBoard();
    }
  
    protected Turn getTurn() {
        return game.getTurn();
    }

  
}
