package mastermind;

import java.util.Random;
import java.util.Scanner;

public class MasterMindConsole {
   
    public static void main(String[] args) {
        String clave2;
        Scanner tec = new Scanner(System.in);

        System.out.println(" Bienvenido Jugador1, escriba una clave de 5 numeros no iguales");
        String clave1 = tec.next();
        System.out.println(" Jugador 2 introduzca cinco digitos para acertar la clave del jugador 1");
        int i = 1;
        do {
            clave2 = tec.next();
            System.out.println("TURNO " + i);
            System.out.println("La clave que has puesto es: " + clave2);

            int nmuertos = assertNumAndPosition(clave1, clave2);
            System.out.println("Muertos; " + nmuertos);

            int nheridos = assertOnlyNum(clave1, clave2);
            System.out.println("Heridos: " + nheridos);

            ++i;
        } while ((i <= 10));
        if (i > 10) {
            System.out.println("El jugador 2 ha perdido");
        } else {

            System.out.println("El jugador 2 ha ganado");
        }
        System.out.println("Puntuación= " + i);
    }
    
    public static int assertNumAndPosition(String clave1, String clave2) {
        int comp = 0;
    
        int a = 0;
        for (comp = 0; comp < 5; comp++) { 
            char c2 = clave2.charAt(comp);
            char c1 = clave1.charAt(comp);
            if (c1 == c2) {
                a++;
            }
        }
        return a;
    }
    
    public static int assertOnlyNum(String clave1, String clave2) {
        int n = 0;
        int a, b;
        int h = 0;
        for (int comp = 0; comp < 5; comp++) {
            char c2 = clave2.charAt(comp);
            char c1 = clave1.charAt(comp);
            int clave1l = clave1.length();
            int clave2l = clave2.length();
            n = clave1.indexOf(c2);
            a = clave2.indexOf(c1);
            if (n == a) {
                h += 1;
            }
        }
        return n;
    }
}
