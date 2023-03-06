/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tuespiral.kk;

public class PruebaNombresUnicos {
    public static void main(String[] args) {
        NombresUnicos n = new NombresUnicos();
        try {
            n.agregaNombre("Ana");
            n.agregaNombre("Pedro");
            n.agregaNombre("Juan");
            
            if(n.contiene("PEDRO")) {
                System.out.println("Contiene Pedro");
            } else {
                System.out.println("No contiene Pedro");
            }
            
            if(n.contiene("Arturo")) {
                System.out.println("Contiene Arturo");
            } else {
                System.out.println("No contiene Arturo");
            }
            
            n.imprimeNombres();
            
            n.ordenaNombres();
            
            n.imprimeNombres();
            
            n.agregaNombre("PeDrO");
            
        } catch(NombreDuplicadoException e) {
            System.out.println("No se permiten nombres duplicados");
        }
    }
}
