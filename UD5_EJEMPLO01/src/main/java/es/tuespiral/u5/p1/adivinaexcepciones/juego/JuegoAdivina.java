package es.tuespiral.u5.p1.adivinaexcepciones.juego;

import java.util.Scanner;

/* Esta clase da la bienvenida al usuario, explica las reglas del juego 
   y pregunta al usuario si quiere jugar. En caso afirmativo crea la partida
   y la inicia.
*/
public class JuegoAdivina {
    private int MAX_INTENTOS = 5;
    
    public void juega() {
        explicaReglas();
        String respuesta = preguntaQuiereJugar();
        
        while (esAfirmativa(respuesta)) {
            Partida p = new Partida(MAX_INTENTOS);
            p.inicia();
            respuesta = preguntaQuiereJugar();
        } 
    }

    private void explicaReglas() {
        System.out.println("El juego consiste en que yo pienso un número entre "
                +"0 y 10 y tu tienes que adivinarlo en "+MAX_INTENTOS+" intentos");
    }

    private String preguntaQuiereJugar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres jugar? (S=Sí / N=No)");
        return sc.nextLine();
    }
    
    private static boolean esAfirmativa(String respuesta) {
        return respuesta.equalsIgnoreCase("s") ||
                respuesta.equalsIgnoreCase("si") ||
                respuesta.equalsIgnoreCase("sí");
    }
    
}
