package mastermind;

import controller.GameController;
import controller.LogicController;

public class MasterMindConsole {

    private LogicController logic;

    public MasterMindConsole() {

        logic = new LogicController();
    }

    public void play() {

        GameController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                controller.control();
            }
        } while (controller != null);

    }

    public static void main(String[] args) {
        new MasterMindConsole().play();
    }

}
