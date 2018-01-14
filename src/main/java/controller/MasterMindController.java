package controller;

import java.util.ArrayList;
import java.util.List;
import util.IO;
import util.Message;

public class MasterMindController {
    private ValidateController validateToken;

    private int limitRandoMax = 6;

    private int points = 40;

    private List<Integer> codeToken;

    private List<Integer> readToken;

    protected MasterMindController(Integer tokenLength, Integer intentMax) {
        generateCodeSecret(tokenLength);
        validateToken = new ValidateController(tokenLength);
    }

    protected void generateCodeSecret(int tokenLength) {
        this.codeToken = new ArrayList<Integer>(tokenLength);
        do {
            int randomNumber = (int) (Math.random() * limitRandoMax) + 1;
            if (!this.codeToken.contains(randomNumber)) {
                this.codeToken.add(randomNumber);

            }
        } while (this.codeToken.size() < tokenLength);
    }

    public String getCode() {
        return String.format(Message.FORMAT_TOKEN.toString(), codeToken.toArray());
    }

    public int getHeridos() {
        int counter = 0;
        boolean[] checked = new boolean[codeToken.size()];
        for (int i = 0; i < codeToken.size(); i++) {
            for (int j = 0; j < codeToken.size(); j++) {
                if (readToken.get(i) == codeToken.get(i)) {
                    break;
                }
                if (readToken.get(i) == codeToken.get(j) && checked[j] == false && i != j) {
                    counter++;
//                    points=points-10;
                    checked[j] = true;
                    break;
                }
            }
        }
        return counter;
    }

    public int getMuertos() {
        int counter = 0;
        for (int i = 0; i < codeToken.size(); i++) {
            if (readToken.get(i) == codeToken.get(i))
            {                
                counter++;
//                points=points-5;
            }
        }
        return counter;
    }

    public boolean getTockensFail(String tocken) {
        return validateToken.tokenIsValidate(tocken);
    }

    public boolean getTockensGood(String tocken) {
        IO io = new IO();
        this.readToken = io.convertStringToArrayList(tocken);
        return (getMuertos() == codeToken.size());
    }

    public void result() {
        IO io = new IO();
        io.writeln(Message.RESULT_R.toString() + getMuertos() + Message.RESULT_M.toString() + getHeridos() + Message.RESULT_H.toString());
        io.writeln("Te queda "+getPoints() +"puntos!!");
    }

    public void win() {
        IO io = new IO();
        io.writeln(getMuertos() + Message.GAME_WIN.toString());
    }

    public boolean gameOver(Integer numberOportunity, Integer oportunityMax) {
        if (numberOportunity == oportunityMax) {
            IO io = new IO();
            io.writeln(Message.GAME_OVER.toString() + "[" + getCode() + "]");
            return true;
        }
        return false;
    }
    
    public int getPoints() {
        int result;
        result= (points-((getMuertos()*10)+(getHeridos()*5)));
        return result;
        
    }

}
