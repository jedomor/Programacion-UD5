package es.tuespiral.u5.e2.teclado;

public class PruebaTeclado {
    public static void main(String[] args) {
        int entero;
        Teclado t = new Teclado();
        
        System.out.println("ENTERO CUALQUIERA");
        System.out.println("Introduce un número entero: ");
        entero = t.leeEntero();  
        
        System.out.println("ENTERO EN RANGO 1-10");
        System.out.println("Introduce un número entero dentro del rango: ");
        entero = t.leeEntero(1, 10);
        
        System.out.println("ENTERO CON MÁXIMO 100");
        System.out.println("Introduce un número entero dentro del rango: ");
        entero = t.leeEnteroMax(100);
        
        System.out.println("ENTERO CON MÍNIMO 10");
        System.out.println("Introduce un número entero dentro del rango: ");
        entero = t.leeEnteroMin(10);
        
    }
}


