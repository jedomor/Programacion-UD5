package u5.e8.bancoant;

public class CuentaCorriente {
    private long numCuenta;
    private double saldo;
    private String pin;

    public CuentaCorriente(long numCuenta, double saldo, String pin) {
        if(numCuenta <= 0)
            throw new IllegalArgumentException("El número de cuenta debe ser mayor que cero");
        
        if(saldo < 0)
            throw new IllegalArgumentException("El saldo  debe ser mayor o igual que cero");
        
        if(pin == null)
            throw new NullPointerException("El pin no puede ser nulo");
        
        if (pin.length() != 4 || !isNumber(pin))
            throw new IllegalArgumentException("El pin debe ser de 4 dígitos");
        
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.pin = pin;
    }

    private boolean isNumber(String pin) {
        try {
            Integer.parseInt(pin);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public long consultaNumeroCuenta() {
        return numCuenta;
    }

    public double consultaSaldo() {
        return saldo;
    }
    
    public boolean intentaAccesoConPin(String pinIntentado) {
        return pin.equals(pinIntentado);
    }
    
    public void ingresa(double importe) {
        if (importe <= 0)
            throw new IllegalArgumentException("El importe debe ser mayor que cero");
        
        saldo = saldo + importe;
    }
    
    public void abona(double importe) {
        if (importe <= 0)
            throw new IllegalArgumentException("El importe debe ser mayor que cero");
        
        if (saldo - importe >= 0) {
            saldo = saldo - importe;
        } else {
            throw new IllegalStateException("No hay saldo suficiente");
        }
    }
    
}
