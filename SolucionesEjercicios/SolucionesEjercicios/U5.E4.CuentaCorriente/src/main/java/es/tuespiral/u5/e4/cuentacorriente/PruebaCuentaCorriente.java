package es.tuespiral.u5.e4.cuentacorriente;

public class PruebaCuentaCorriente {
    public static void main(String[] args) {
        System.out.println("FLUJO NORMAL");
        CuentaCorriente cc = new CuentaCorriente(12, 300, "1234");
       
        System.out.println("Número Cuenta = "+cc.consultaNumeroCuenta());
        System.out.println("Saldo = "+cc.consultaSaldo());
        
        System.out.println("Probamos el acceso con 4321");
        if (cc.intentaAccesoConPin("4321")) {
            System.out.println("PIN correcto");
        } else {
            System.out.println("PIN incorrecto");
        }
        
        System.out.println("Probamos el acceso con 1234");
        if (cc.intentaAccesoConPin("1234")) {
            System.out.println("PIN correcto");
        } else {
            System.out.println("PIN incorrecto");
        }
        
        System.out.println("Ingresamos 300 euros");
        cc.ingresa(300);
        
        System.out.println("Abonamos 100 euros");
        cc.abona(100);
        
        System.out.println("Número Cuenta = "+cc.consultaNumeroCuenta());
        System.out.println("Saldo = "+cc.consultaSaldo());
            
        System.out.println("");
        System.out.println("FLUJO ERRORES");
        try {
            CuentaCorriente c = new CuentaCorriente(12, 300, "abcd");
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        
        try {
            CuentaCorriente c = new CuentaCorriente(12, 300, "12");
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        
        try {
            CuentaCorriente c = new CuentaCorriente(-1, 300, "1234");
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        
        try {
            CuentaCorriente c = new CuentaCorriente(33, -3000, "1234");
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        
        try {
            CuentaCorriente c = new CuentaCorriente(33, 3000, "1234");
            c.ingresa(-1);
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        
        try {
            CuentaCorriente c = new CuentaCorriente(33, 3000, "1234");
            c.abona(-1);
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
