
package u5.e8.bancoant;

import java.util.Scanner;

public class PruebaBanco {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Banco b = new Banco();
        int numCuenta = 0;
        String pin = "";
        boolean fin = false;
        
        do {
            System.out.println("Dime tu número de cuenta: ");
            numCuenta = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Dime el PIN de tu cuenta:");
            pin = sc.nextLine();
            
            try {
                int token = b.abreConexion(numCuenta, pin);
                System.out.println("Conexión realizada correctamente (token="+token+")");
                System.out.println("Dime el importe del pago a realizar");
                double importe = sc.nextDouble();
                b.realizaPago(token, importe);
                b.cierraConexion(token);
                fin = true;
                
            } catch(CuentaOPinIncorrectoException e) {
                System.out.println("El número de cuenta o PIN son incorrectos");
                System.out.println("Inténtalo de nuevo\n");
            } catch(TokenIncorrectoException e) {
                System.out.println("Conexión inválida. Token incorrecto");
            } catch(SaldoInsuficienteException e) {
                System.out.println("Saldo insuficiente. Operación abortada");
            }
        } while (!fin);
    }
}
