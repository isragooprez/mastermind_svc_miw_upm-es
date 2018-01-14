package controller;

import model.Game;
import model.State;
import util.IO;
import util.Message;

public class ContinueController extends GameController {

    public ContinueController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        assert this.getState() == State.FINAL;
        char response;
        do {
            response = new IO().readChar(Message.QUESTION_CONTINUE.toString());
        } while (response != 's' && response != 'S' && response != 'n' && response != 'N');
        if (response == 's' || response == 'S') {
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }

    }

}
