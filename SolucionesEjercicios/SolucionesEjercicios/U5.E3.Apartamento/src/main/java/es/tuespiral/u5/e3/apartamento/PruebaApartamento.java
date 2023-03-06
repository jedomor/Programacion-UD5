package es.tuespiral.u5.e3.apartamento;

public class PruebaApartamento {
    public static void main(String[] args) {

        try {
            Apartamento a = new Apartamento(null, 1, 1, true);
        } catch(NullPointerException e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
        
        try {
            Apartamento a = new Apartamento("Calle trece", 1000, 1, true);
            
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
        
        try {
            Apartamento a = new Apartamento("Calle trece", 1, 1000, true);
            
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
        
        try {
            Apartamento a = new Apartamento("Calle trece", 2, 1, true);
            a.ocupar();
            
        } catch(IllegalStateException e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
        
        try {
            Apartamento a = new Apartamento("Calle trece", 2, 1, false);
            a.liberar();
        } catch(IllegalStateException e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
