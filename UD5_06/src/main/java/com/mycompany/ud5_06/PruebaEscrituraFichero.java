package com.mycompany.ud5_06;

import java.io.IOException;
import java.util.*;

public class PruebaEscrituraFichero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreFich;
        String frase;
        int i=1;
        List <String> lista = new ArrayList<>(Arrays.asList("arriba", "abajo","izquierda", "derecha"));
                
        // Recopilar información
        System.out.println("Dime una frase y te la escribo a un fichero: ");
        
        do{
            System.out.println("Dime la frase "+i +":");
            frase = sc.nextLine();
            if(!frase.equalsIgnoreCase("fin")){
                lista.add(frase);
            }
            i++;
        }while (!frase.equalsIgnoreCase("fin"));
        

    }
}