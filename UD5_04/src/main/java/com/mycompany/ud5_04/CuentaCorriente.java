package com.mycompany.ud5_04;

public class CuentaCorriente {

    private double saldoActual;
    private long numeroCuenta;
    private String codigoPin;

    public CuentaCorriente(double saldoActual, long numeroCuenta, String codigoPin) {
        if (saldoActual < 0) {
            throw new IllegalArgumentException("En este banco no aceptamos saldos negativos");
        }
        if (numeroCuenta < 1 || numeroCuenta > 99999999) {
            throw new IllegalArgumentException("No puede existir una cuenta con esos números");
        }
        if (codigoPin.length() < 4 || codigoPin.length() > 4) {
            throw new IllegalArgumentException("El codigo pin debe tener 4 digitos");
        }
        this.saldoActual = saldoActual;
        this.numeroCuenta = numeroCuenta;
        this.codigoPin = codigoPin;
    }

    public double consultaSaldo() {
        return saldoActual;
    }

    public boolean ingresaPin() {
        boolean pinCorrecto = false;
        if (this.codigoPin.equals(codigoPin)) {
            System.out.println("Codigo introducido válido");
            pinCorrecto = true;
        } else {
            throw new IllegalStateException("Codigo pin incorrecto");
        }
        return pinCorrecto;
    }
    
    public long getNumeroCuenta(){
        return numeroCuenta;
    }
    
    public void ingresa (double importe){
        
    }

}
