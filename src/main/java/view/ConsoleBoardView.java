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
        io.writeln("Intento: ? [cuatro numeros de entre 1-amarillo, 2-rojo, 3-verde, 4-azul, 5-blanco, 6-negro] ");
        io.writeln("Formato example: ARNB");
        io.writeln("Coloca una combinación de " + tokenLength + " numeros, y tienes " + oportunityLength + " oportunidades");
        io.write("Codigo secreto: >");
        for (int i = 0; i < tokenLength; i++) {
            io.write("*");
        }
        io.writeln("<");
    }
}
