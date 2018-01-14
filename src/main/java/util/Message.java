package util;

public enum Message {
    FORMAT_TOKEN("%s%s%s%s"),
    GAME_OVER("\nPerdiste: El codigo es"),
    GAME_WIN(" Muertos!!! Victoria \n"),
    RESULT_R("              Resultado: " ),
    RESULT_M(" muertos y " ),
    RESULT_H(" heridos"),
    QUESTION_USER("Cuántos usuarios?"),
    QUESTION_CONTINUE("Desea continuar jugando? (s/n):"),
    CONFIRM_MSG("Enter para continuar!");
    
    
    private String message;

    private Message(String message) {
        this.message = message;
    };
        
    @Override
    public String toString(){
        return message;
    }
    
}
