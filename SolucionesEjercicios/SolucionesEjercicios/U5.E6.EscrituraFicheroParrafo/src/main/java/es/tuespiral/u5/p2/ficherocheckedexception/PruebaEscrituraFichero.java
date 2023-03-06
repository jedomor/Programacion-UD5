package es.tuespiral.u5.p2.ficherocheckedexception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaEscrituraFichero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreFich;
        String frase;
        int i = 1;
        List<String> lista = new ArrayList<>();

        // Recopilar información
        System.out.println("Dime las frases que quieras escribir en el fichero (FIN para terminar):");
        do {
            System.out.println("Dime la frase "+i+":");
            frase = sc.nextLine();
            if(!frase.equalsIgnoreCase("fin")) {
                lista.add(frase);
            }
            i++;
        } while(!frase.equalsIgnoreCase("fin"));
            
        System.out.println("\nDime el nombre del fichero donde las guardo:");
        nombreFich = sc.nextLine();
            
        // Procesado
        try {
            EscrituraFichero fich = new EscrituraFichero(nombreFich);
            fich.abrir();

            fich.escribeTexto(lista);
            fich.cerrar();
            System.out.println("Frases guardadas correctamente");
        } catch (IOException ex) {
            System.out.println("Algo falló al abrir o escribir las frases en el fichero");
        }
        

    }
}
