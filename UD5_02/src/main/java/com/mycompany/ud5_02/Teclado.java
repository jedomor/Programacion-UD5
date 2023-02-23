/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ud5_02;

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
            if (entero >= minimo || entero <= maximo) {
                System.out.println("El número debe estar entre: " + maximo + " " + minimo);

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

    public int leerBinario() {
        int entero;
        String linea;
        while (true) {
            try {
                System.out.println("introduce un numero binario: ");
                linea = sc.nextLine();
                entero = Integer.parseInt(linea, 2);
                return entero;
            } catch (NumberFormatException e) {
                System.out.println("El número introducido no es válido");
            }
        }
    }

    public int leerHexadecimal() {
        int entero;
        String linea;
        while (true) {
            try {
                System.out.println("introduce un numero hexadecimal: ");
                linea = sc.nextLine();
                entero = Integer.parseInt(linea, 16);
                return entero;
            } catch (NumberFormatException e) {
                System.out.println("El número introducido no es válido");
            }
        }
    }

    public int leerOctal() {
        int entero;
        String linea;
        while (true) {
            try {
                System.out.println("introduce un numero octal: ");
                linea = sc.nextLine();
                entero = Integer.parseInt(linea, 8);
                return entero;
            } catch (NumberFormatException e) {
                System.out.println("El número introducido no es válido");
            }
        }
    }

}
