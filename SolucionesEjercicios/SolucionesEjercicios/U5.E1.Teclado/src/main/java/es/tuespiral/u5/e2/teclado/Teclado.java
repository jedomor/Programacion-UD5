package es.tuespiral.u5.e2.teclado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
    private Scanner sc;
    
    public Teclado() {
        sc = new Scanner(System.in);
    }
    
    public int leeEntero() {
        int entero;
        while(true) {
            try {
                entero = sc.nextInt();
                return entero;
            } catch(InputMismatchException e) {
                System.out.println("El número introducido no tiene el formato correcto");
                sc.next();
            }
        }
    }
    
    public int leeEntero(int minimo, int maximo) {
        int entero;
        while(true) {
            entero = leeEntero();
            if (entero < minimo || entero > maximo) {
                System.out.println("El número debe estar entre "+minimo+" y "+maximo+". Introdúcelo de nuevo: ");
            } else {
                return entero;
            }
        }
        
    }
    
    public int leeEnteroMax(int maximo) {
        int entero;
        while(true) {
            entero = leeEntero();
            if (entero > maximo) {
                System.out.println("El número debe ser menor o igual que "+maximo+". Introdúcelo de nuevo: ");
            } else {
                return entero;
            }
        }
    }
    
    public int leeEnteroMin(int minimo) {
        int entero;
        while(true) {
            entero = leeEntero();
            if (entero < minimo) {
                System.out.println("El número debe ser mayor o igual que "+minimo+". Introdúcelo de nuevo: ");
            } else {
                return entero;
            }
        }
    }
    
}
