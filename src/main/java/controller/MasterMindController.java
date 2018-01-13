package controller;

import java.util.ArrayList;
import java.util.List;
import util.IO;

public class MasterMindController {
    private ValidateController validateToken;

    private int limitRandoMax = 6;

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
        return String.format("%s%s%s%s", codeToken.toArray());
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
                counter++;
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
        io.writeln("Resultado: " + getMuertos() + " muertos y " + getHeridos() + " heridos");
    }

    public void win() {
        IO io = new IO();
        io.writeln(getMuertos() + " muertos!!! Victoria \n");
    }

    public boolean gameOver(Integer numberOportunity, Integer oportunityMax) {
        if (numberOportunity == oportunityMax) {
            IO io = new IO();
            io.writeln("\nPerdiste: El codigo es [" + getCode() + "]");
            return true;
        }
        return false;
    }

}
