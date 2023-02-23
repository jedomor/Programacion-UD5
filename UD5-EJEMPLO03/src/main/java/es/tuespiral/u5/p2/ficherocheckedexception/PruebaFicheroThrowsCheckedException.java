package es.tuespiral.u5.p2.ficherocheckedexception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PruebaFicheroThrowsCheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre ="";
        
        try {
            System.out.println("Dime el nombre del fichero a mostrar. Ejemplo: prueba.txt");
            nombre = sc.nextLine();
            Fichero fich = new Fichero(nombre);
            fich.abrir();
            
            try {
                fich.imprimeContenido();
                fich.cerrar();
            } catch (IOException ex) {
                System.out.println("Algo falló al leer el contenido o al cerrar el fichero");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero " + nombre + " no se pudo abrir porque no se encuentra");
        }
            
    }
}
