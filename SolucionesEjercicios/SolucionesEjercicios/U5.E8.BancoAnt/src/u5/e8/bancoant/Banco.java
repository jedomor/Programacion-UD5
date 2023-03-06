package u5.e8.bancoant;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Banco {
    private final int MAX_TOKEN = 1000000;
    private Map<Long, CuentaCorriente> cuentasCorrientes;
    private Map<Integer, CuentaCorriente> cuentasConectadas;
    
    public Banco() {
        cuentasCorrientes = new HashMap<>();
        cuentasConectadas = new HashMap<>();
        
        CuentaCorriente cc = new CuentaCorriente(1, 1000, "1234");
        cuentasCorrientes.put(cc.consultaNumeroCuenta(), cc);
        
        cc = new CuentaCorriente(2, 2000, "2345");
        cuentasCorrientes.put(cc.consultaNumeroCuenta(), cc);
        
        cc = new CuentaCorriente(3, 3000, "3456");
        cuentasCorrientes.put(cc.consultaNumeroCuenta(), cc);
        
        cc = new CuentaCorriente(4, 4000, "4567");
        cuentasCorrientes.put(cc.consultaNumeroCuenta(), cc);
    }
    
    public int abreConexion (long numeroCuenta, String pin) throws CuentaOPinIncorrectoException {
        if (cuentasCorrientes.containsKey(numeroCuenta)){
            CuentaCorriente cc = cuentasCorrientes.get(numeroCuenta);
            
            if (cc.intentaAccesoConPin(pin)) {
                Random r = new Random();
                int token = r.nextInt(MAX_TOKEN);
                cuentasConectadas.put(token, cc);
                return token;
            }
        }
        throw new CuentaOPinIncorrectoException("El número de cuenta o el PIN son incorrectos");
    }

    public void realizaPago (int tokenCuenta, double importe) 
            throws TokenIncorrectoException, SaldoInsuficienteException {
        if (cuentasConectadas.containsKey(tokenCuenta)) {
            CuentaCorriente cc = cuentasConectadas.get(tokenCuenta);
            
            if (cc.consultaSaldo() >= importe) {
                cc.abona(importe);
            } else {
                throw new SaldoInsuficienteException("No hay saldo suficiente para realizar el pago");
            }
        } else {
            throw new TokenIncorrectoException("Error al realizar el pago por token incorrecto");
        }
    }
    
    public void cierraConexion (int tokenCuenta) throws TokenIncorrectoException {
        if (cuentasConectadas.containsKey(tokenCuenta)) {
            cuentasConectadas.remove(tokenCuenta);
        } else {
            throw new TokenIncorrectoException("Error al cerrar la conexión por token incorrecto");
        }
    }
}
