package es.tuespiral.u5.p2.ficherocheckedexception;

import java.util.Scanner;

public class PruebaFicheroCheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dime el nombre del fichero a mostrar. Ejemplo: prueba.txt");
        String nombre = sc.nextLine();
        Fichero fich = new Fichero(nombre);
        
        fich.abrir();
        fich.imprimeContenido();
        fich.cerrar();
    }
}
