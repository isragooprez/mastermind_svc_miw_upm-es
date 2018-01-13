package controller;

import model.Game;
import util.IO;
import util.LimitedIntDialog;

public class LogicController {
    private Game game;

    private String tocken;

    private StartController startController;

    private ContinueController continueController;

    private PutController putController;

    public LogicController() {
        game = new Game();
        startController = new StartController(game);
        continueController = new ContinueController(game);
        putController = new PutController(Game.FORMATMAX, Game.INTENTMAX);
    }

    public GameController getController() {
        switch (game.getState()) {
        case INITIAL:
            return startController;
        case GAMMING:
            int numberOportunity = 0;
            int users = new LimitedIntDialog("Cuántos usuarios?", 0, 1).read();
            do {
                game.getTurn().getOpportunityMax(numberOportunity);
                for (int i = 0; i < 1; i++) {
                    if (i < users) {
                        tocken = new IO().readToken();
                    } else {
                        tocken = new IO().writeToken();
                    }
                }
                if (!putController.getTockensFail(tocken)) {
                    new IO().error();
                    continue;
                }
                numberOportunity++;
                if (putController.getTockensGood(tocken)) {
                    putController.win();
                    break;
                } else {
                    putController.result();
                }
            } while (!putController.gameOver(numberOportunity, Game.INTENTMAX));
        case FINAL:
            return continueController;
        case EXIT:
        default:
            return null;
        }
    }
}
