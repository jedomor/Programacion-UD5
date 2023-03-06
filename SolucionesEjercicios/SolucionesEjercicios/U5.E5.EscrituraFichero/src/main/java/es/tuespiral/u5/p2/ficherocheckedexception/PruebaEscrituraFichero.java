package es.tuespiral.u5.p2.ficherocheckedexception;

import java.io.IOException;
import java.util.Scanner;

public class PruebaEscrituraFichero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreFich;
        String frase;

        try {
            // Recopilar información
            System.out.println("Dime una frase y te la escribo a un fichero: ");
            frase = sc.nextLine();
            System.out.println("\nDime el nombre del fichero donde la guardo:");
            nombreFich = sc.nextLine();
            
            // Procesado
            EscrituraFichero fich = new EscrituraFichero(nombreFich);
            fich.abrir();
            fich.escribeTexto(frase);
            fich.cerrar();
            
            // Despedida
            System.out.println("Frase guardada correctamente");
        } catch (IOException ex) {
            System.out.println("Algo falló al abrir o escribir la frase en el fichero");
            //System.out.println(ex);
        }

    }
}
