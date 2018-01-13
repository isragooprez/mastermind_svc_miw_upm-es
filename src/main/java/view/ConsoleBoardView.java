package view;

import util.IO;

public class ConsoleBoardView {

    public ConsoleBoardView(int tokenLength, int oportunityLengt) {
        super();
        // TODO Auto-generated constructor stub
    }

    public void menu(int tokenLength, int oportunityLength) {

        IO io = new util.IO();
        io.writeln("------- MASTER MIND GAME----");
        io.writeln("Intento: ? [Cuatro números de entre:  1-Amarillo, 2-Rojo, 3-Verde, 4-Azul, 5-blanco, 6-Negro] ");
        io.writeln("Formato example: 1122");
        io.writeln("Coloca una combinación de " + tokenLength + " numeros, y tienes " + oportunityLength + " oportunidades");
        io.write("Código secreto");
        for (int i = 0; i < tokenLength; i++) {
            io.write("*");
        }
        io.writeln("");
    }
}
