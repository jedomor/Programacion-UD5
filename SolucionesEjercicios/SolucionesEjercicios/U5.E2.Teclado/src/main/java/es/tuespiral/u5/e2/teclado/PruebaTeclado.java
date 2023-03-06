package es.tuespiral.u5.e2.teclado;

public class PruebaTeclado {
    public static void main(String[] args) {
        int entero;
        Teclado t = new Teclado();
        
//        System.out.println("ENTERO CUALQUIERA");
//        System.out.println("Introduce un número entero: ");
//        t.leeEntero();
//        
//        System.out.println("ENTERO EN RANGO 1-10");
//        System.out.println("Introduce un número entero dentro del rango: ");
//        t.leeEntero(1, 10);
//        
//        System.out.println("ENTERO CON MÁXIMO 100");
//        System.out.println("Introduce un número entero dentro del rango: ");
//        t.leeEnteroMax(100);
//        
//        System.out.println("ENTERO CON MÍNIMO 10");
//        System.out.println("Introduce un número entero dentro del rango: ");
//        t.leeEnteroMin(10);
        
        System.out.println("ENTERO UN NÚMERO BINARIO");
        System.out.println("Introduce un número binario: ");
        entero = t.leerBinario();
        System.out.println("El número leído es: "+entero);
        
        System.out.println("ENTERO UN NÚMERO EN OCTAL");
        System.out.println("Introduce un número octal: ");
        entero = t.leerOctal();
        System.out.println("El número leído es: "+entero);
        
        System.out.println("ENTERO UN NÚMERO EN HEXADECIMAL");
        System.out.println("Introduce un número hexadecimal: ");
        entero = t.leerHex();
        System.out.println("El número leído es: "+entero);
    }
}


