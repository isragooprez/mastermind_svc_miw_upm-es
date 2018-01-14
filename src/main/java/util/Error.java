package util;


public enum Error {
    
    ERROR_LIMIT("El valor debe estar entre: "),
    ERROR_FORMAT("ERROR DE FORMATO! " + "Introduzca un valor con formato. Ejemplo: s/n"),
    ERROR_TOKEN("de cadena de numeros"),
    ERROR_INT("ingrese un entero"),
    ERROR_CHAR("de cadena de caracteres"),
    ERROR_RANGE("Formato no validos, recuerda son 4 números [1234]");
    
    private String error;

    private Error(String error ) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }

}
