package es.tuespiral.u5.p1.adivinaexcepciones.juego;

import java.util.Random;
import java.util.Scanner;

/* Esta clase contiene toda la lógica de una partida así
   como los mensajes que se muestran al usuario en cada caso
*/
class Partida {
    private final int LIMITE_SUPERIOR = 10;
    private final int numMaxIntentos;
    private int numSecreto;
    private int numIntentos = 0;
    private boolean adivinado = false;
    
    public Partida(int numMaxIntentos) {
        this.numMaxIntentos = numMaxIntentos;
    }

    public void inicia() {
        generaNumeroSecreto();
        do {
            int respuesta = preguntaNumeroAlUsuario();
            numIntentos++; 
            if (respuesta == numSecreto) {
                adivinado = true;
            } else {
                muestraMensajeFallo();
            }
        } while(numIntentos < numMaxIntentos && !adivinado);
        
        muestraResultados();
    }

    private void generaNumeroSecreto() {
        Random genera = new Random();
        numSecreto = genera.nextInt(LIMITE_SUPERIOR+1);
    }

    private int preguntaNumeroAlUsuario() {
            Scanner sc = new Scanner(System.in);    
            System.out.println("Dime un número entre 0 y "+LIMITE_SUPERIOR);
            return sc.nextInt();
    }

    private void muestraMensajeFallo() {
        System.out.println("¡Uyy! Ese no es el número que he pensado");
        int intentosRestantes = numMaxIntentos - numIntentos;
        System.out.println("Te quedan "+intentosRestantes+" intentos");
    }

    private void muestraResultados() {
        if (adivinado) {
            muestraMensajeAdivinado();
        } else {
            muestraMensajeNoAdivinado();
        }
    }
    
    private void muestraMensajeAdivinado() {
        System.out.println("¡Bravo! El "+numSecreto+" era el número que había pensado");
        System.out.println("Lo has conseguido en "+numIntentos+" intentos");
    }

    private void muestraMensajeNoAdivinado() {
        System.out.println("¡Lo siento! El número que había pensado era el "+numSecreto);
    }
}
