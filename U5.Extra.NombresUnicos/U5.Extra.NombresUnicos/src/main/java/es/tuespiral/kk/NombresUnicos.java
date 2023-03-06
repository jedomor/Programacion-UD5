package es.tuespiral.kk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NombresUnicos {
    private List<String> lista;
    
    public NombresUnicos() {
       lista = new ArrayList<>();
    }
    
    public void agregaNombre(String nombre) throws NombreDuplicadoException {
       if(!contiene(nombre)) {
           lista.add(nombre);
       } else {
           throw new NombreDuplicadoException();
       }
    }
    
    public void ordenaNombres() {
        Collections.sort(lista);
    }
    
    public void imprimeNombres() {
        int cuenta = 1;
        Iterator<String> iter = lista.iterator();
        while(iter.hasNext()) {
            System.out.println(cuenta+". "+iter.next());
            cuenta++;
        }
    }
    
    public boolean contiene(String nombre) { 
        for (String elem : lista) {
            if(elem.equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
