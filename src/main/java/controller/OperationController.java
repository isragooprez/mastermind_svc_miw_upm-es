package controller;

import model.Game;

public abstract class OperationController extends ContinueController {
    protected OperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor operationControllerVisitor);

}
