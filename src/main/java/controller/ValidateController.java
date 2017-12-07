package controller;

public class ValidateController {
    private int tokenLength;

    public ValidateController(int tokenLength) {
        this.tokenLength = tokenLength;
    }

    public boolean tokenIsValidate(String token) {
        boolean result = false;
        if (lengthToken(token, tokenLength) && tokenNumeric(token))
            result = true;
        return result;
    }

    private boolean lengthToken(String token, int tokenLength) {
        return token.length() == tokenLength;
    }

    private boolean tokenNumeric(String token) {
        assert token != null;
        char[] tokenChars = token.toCharArray();
        for (char digitChar : tokenChars) {
            Integer.parseInt(String.valueOf(digitChar));
        }
        return true;
    }

}
