package es.tuespiral.u5.p1.adivinaexcepciones;

import es.tuespiral.u5.p1.adivinaexcepciones.juego.JuegoAdivina;

/* Esta clase es simplemente un lanzador del juego.
   Simplemente crea la clase JuegoAdivina y lanza el juego.
*/
public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivina jAdivina = new JuegoAdivina();
        jAdivina.juega();
    }
}
