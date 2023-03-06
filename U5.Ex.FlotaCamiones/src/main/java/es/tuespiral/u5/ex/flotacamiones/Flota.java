package es.tuespiral.u5.ex.flotacamiones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Flota {
    private Set<Camion> flota;
    
    public Flota() {
        flota = new HashSet<>();
    }
    
    public void altaCamion(Camion c) {
        if(c==null) {
            throw new NullPointerException("El camión no puede ser nulo");
        }
        flota.add(c);
    }
    
    public boolean contieneCamion(Camion c) {
        return flota.contains(c);
    }
    
    public boolean bajaCamion(Camion c) {
        return flota.remove(c);
    }
    
    public void imprimeFlota() {
        Iterator<Camion> iter = flota.iterator();
        int i = 1;
        while(iter.hasNext()) {
            System.out.println(i+" - "+iter.next());
            i++;
        }
    }
    
    public void ponerFlotaEnRuta() {
        Iterator<Camion> iter = flota.iterator();
        while(iter.hasNext()) {
            Camion c = iter.next();
            try {
                c.realizaRuta();
                System.out.println("En ruta: "+c);
            } catch (IllegalStateException ex) {
                System.out.println("No puede hacer ruta: "+c);
            }
        }
    }
}
