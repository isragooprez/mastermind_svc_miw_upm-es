package controller;

import model.Game;
import model.State;
import view.ConsoleBoardView;

public abstract class GameController {
    private Game game;

    protected GameController(Game game) {
        assert game != null;
        this.game = game;

    }

    public abstract void control();

    protected State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        assert state != null;
        game.setState(state);
    }
    
    protected ConsoleBoardView getConsoleBoardView() {
        return game.getBoard();
    }
    
    
    

}

