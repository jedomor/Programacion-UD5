package es.tuespiral.u5.ex.flotacamiones;

public class PruebaFlota {
    public static void main(String[] args) {
        try {
            Camion camionKmNegativos = new Camion("0000", true, true, -10);
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println("-----------");
        
        Flota f = new Flota();
        Camion c1 = new Camion("1234", true, true, 0);
        Camion c2 = new Camion("2345", true, true, 500);
        Camion c3 = new Camion("3456", true, false, 1000);
        Camion c4 = new Camion("4567", false, true, 1500);
        Camion c5 = new Camion("5678", true, true, 1500);
        
        f.altaCamion(c1);
        f.altaCamion(c2);
        f.altaCamion(c3);
        f.altaCamion(c4);
        f.altaCamion(c5);
        
        f.imprimeFlota();
        System.out.println("-----------");
        f.ponerFlotaEnRuta();
    }
}
