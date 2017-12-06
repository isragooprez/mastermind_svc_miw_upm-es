package model;

import view.ConsoleBoardView;

public class Game {
    public static final int OPPORTUNITY = 10;

    public static final int FORMATMAX = 4;

    private ConsoleBoardView board;

    private State state;

    private Turn turn;

    public Game() {
        state = State.INITIAL;
        board = new ConsoleBoardView(Game.FORMATMAX, Game.OPPORTUNITY);
        turn = new Turn(Game.OPPORTUNITY);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
    
    

}
