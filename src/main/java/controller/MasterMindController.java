package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.IO;

public class MasterMindController {
    private ValidateController validateToken;

    private List<Integer> codeToken;

    private List<Integer> readToken;

    protected MasterMindController(Integer tokenLength, Integer oportunityMax) {
        generateTokenSecret(tokenLength);
        validateToken = new ValidateController(tokenLength);
    }
    
    protected void generateTokenSecret(int tokenLength) {
        this.codeToken = new ArrayList<Integer>(tokenLength);
        do {
            Random random = new Random();
            int randomNumber = random.nextInt(6);
            if (!this.codeToken.contains(randomNumber)) {
                this.codeToken.add(randomNumber);

            }
        } while (this.codeToken.size() < tokenLength);
    }
    
    public String getCode() {
        return String.format("%s%s%s%s", codeToken.toArray());
    }

    public int getHerido() {
        int white = 0;
        boolean[] checked = new boolean[codeToken.size()];
        for (int i = 0; i < codeToken.size(); i++) {
            for (int j = 0; j < codeToken.size(); j++) {
                if (readToken.get(i) == codeToken.get(i)) {
                    break;
                }
                if (readToken.get(i) == codeToken.get(j) && checked[j] == false && i != j) {
                    white++;
                    checked[j] = true;
                    break;
                }
            }
        }
        return white;
    }

    public int getMuerto() {
        int black = 0;
        for (int i = 0; i < codeToken.size(); i++) {
            if (readToken.get(i) == codeToken.get(i))
                black++;
        }
        return black;
    }

    public boolean getTockensFail(String tocken) {
        return validateToken.tokenIsValidate(tocken);
    }

    public boolean getTockensGood(String tocken) {
        this.readToken = convertStringToArrayList(tocken);
        return (getMuerto() == codeToken.size());
    }

    public void result() {
        IO io = new IO();
        io.writeln(getMuerto() + " muertos y " + getHerido() + " heridos");
    }

    public void win() {
        IO io = new IO();
        io.writeln(getMuerto() + " MUERTOS VICTORIA! \n");
    }

    public boolean gameOver(Integer numberOportunity, Integer oportunityMax) {
        if (numberOportunity == oportunityMax) {
            IO io = new IO();
            io.writeln("\nPerdiste: El codigo es [" + getCode() + "]");
            return true;
        }
        return false;
    }

    private List<Integer> convertStringToArrayList(String text) {
        List<Integer> result = new ArrayList<Integer>(text.length());
        for (int i = 0; i < text.length(); i++) {
            result.add(Integer.parseInt(text.substring(i, i + 1)));
        }
        return result;
    }

    

}
