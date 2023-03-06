package com.mycompany.ud5_08;
import java.util.*;
public class PruebaBanco {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco cxaBnk = new Banco();
        int token = 0;
        long numCuenta;
        String pin;
        boolean fin = false;
        
        do{
            try{
                System.out.println("Introduzca el número de cuenta:");
                numCuenta=sc.nextLong();
                System.out.println("Introduzca el código pin");
                pin=sc.nextLine();
                
            }catch(Exception e){
                System.out.println(e);
                
            }
        }while (!fin);
        
        
        
        
       
        

    }
}
