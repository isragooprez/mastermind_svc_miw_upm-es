package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IO {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int RANGE_SECRET_CODE = 4;

    public void writeln(String string) {
        System.out.println(string);
    }

    public void write(String string) {
        System.out.print(string);
    }

    public String readToken() {

        String token = null;
        try {
            token = bufferedReader.readLine();
        } catch (IOException e) {
            this.writeError("" + Error.ERROR_TOKEN);
        }
        return token;
    }

    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readToken());
                ok = true;
            } catch (Exception ex) {
                this.writeError(Error.ERROR_INT.toString());
            }
        } while (!ok);
        return input;
    }

    public void writeError(String formato) {
        System.out.println(Error.ERROR_FORMAT.toString() + formato + ".");
    }

    public String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            this.write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                this.writeError(Error.ERROR_CHAR.toString());
            }
        } while (!ok);
        return input;
    }

    public char readChar(String title) {
        char charValue = ' ';
        boolean ok = false;
        do {
            String input = this.readString(title);
            if (input.length() != 1) {
                this.writeError("caracter");
            } else {
                charValue = input.charAt(0);
                ok = true;
            }
        } while (!ok);
        return charValue;
    }

    public void error() {
        IO io = new IO();
        io.writeln(Error.ERROR_RANGE.toString());
    }

    public String writeToken() {
        String result = "";
        int[] secret = new int[4];
        for (int i = 0; i < 4; i++) {
            secret[i] = (int) (Math.random() * 6 + 1);
        }

        result = String.valueOf(secret[0])
                .concat(String.valueOf(secret[1]).concat(String.valueOf(secret[2]).concat(String.valueOf(secret[3]))));
        new IO().writeln("              Ordenador escribe " + result);
        new IO().readString(Message.CONFIRM_MSG.toString());
        return result;
    }

    public List<Integer> convertStringToArrayList(String text) {
        List<Integer> result = new ArrayList<Integer>(text.length());
        for (int i = 0; i < text.length(); i++) {
            result.add(Integer.parseInt(text.substring(i, i + 1)));
        }
        return result;
    }

}
