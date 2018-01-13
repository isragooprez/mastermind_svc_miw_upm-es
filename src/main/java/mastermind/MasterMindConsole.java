package mastermind;

import controller.GameController;
import controller.LogicController;

public class MasterMindConsole {

    private LogicController logicController;

    public MasterMindConsole() {

        logicController = new LogicController();
    }

    public void play() {

        GameController gameController;
        do {
            gameController = logicController.getController();
            if (gameController != null) {
                gameController.control();
            }
        } while (gameController != null);

    }

    public static void main(String[] args) {
        new MasterMindConsole().play();
    }

}
