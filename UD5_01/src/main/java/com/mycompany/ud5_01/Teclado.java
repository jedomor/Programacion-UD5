package com.mycompany.ud5_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

    public int leeEntero() {
        int entero;
        while (true) {
            try {
                System.out.println("Introduce un número entero: ");
                entero = sc.nextInt();
                sc.nextLine();
                return entero;
            } catch (InputMismatchException e) {
                System.out.println("Te has equivocado, introduce un número");
                sc.nextLine();
            }
        }
    }

    public int leeEntero(int minimo, int maximo) {
        int entero;
        while (true) {
            entero = leeEntero();
            if (entero >= minimo && entero <= maximo) {
                System.out.println("El número debe estar entre: " + minimo + " y " + maximo);

            } else {
                return entero;
            }
        }
    }

    public int leeEnteroMax(int maximo) {
        int entero;
        while (true) {
            entero = leeEntero();
            if (entero <= maximo) {
                System.out.println("El número debe ser menor o igual que : " + maximo);

            } else {
                return entero;
            }
        }
    }

    public int leeEnteroMinimo(int minimo) {
        int entero;
        while (true) {
            entero = leeEntero();
            if (entero >= minimo) {
                System.out.println("El número debe ser menor o igual que : " + minimo);

            } else {
                return entero;
            }
        }
    }

}
