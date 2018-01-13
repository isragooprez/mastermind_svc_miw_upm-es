package controller;

import model.Game;
import model.State;

public class StartController extends GameController {

    public StartController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        assert this.getState() == State.INITIAL;
        this.getConsoleBoardView().menu(Game.FORMATMAX, Game.INTENTMAX);
        this.setState(State.GAMMING);

    }

}
