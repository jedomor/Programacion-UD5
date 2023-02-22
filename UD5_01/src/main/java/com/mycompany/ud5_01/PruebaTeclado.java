package com.mycompany.ud5_01;

public class PruebaTeclado {

    public static void main(String[] args) {

        Teclado sc = new Teclado();
        sc.leeEntero();
        
        System.out.println("numero entre 1 y 5");
        sc.leeEntero(1, 5);
        
        System.out.println("mayor que 3");
        sc.leeEnteroMax(3);
        
        System.out.println("menor que 2");
        sc.leeEnteroMinimo(2);

    }
}
