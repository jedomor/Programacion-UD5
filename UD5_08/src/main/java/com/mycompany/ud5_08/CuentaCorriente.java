
package com.mycompany.ud5_08;

public class CuentaCorriente {
    private long numeroCuenta;
    private String pin;
    private double saldo;

    public CuentaCorriente(long numeroCuenta, String pin, double saldo) {
        if (numeroCuenta<=0)
            throw new IllegalArgumentException("Numero de cuenta no válido, es menor que 0");
        if (pin.length()<4 && pin.length()>4)
            throw new IllegalArgumentException("El codigo pin debe tener 4 digitos");
        if (saldo<0)
            throw new IllegalArgumentException("Este banco no permite saldos negativos");
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldo;
    }

    public boolean validarPin(String pin) {
        return this.pin.equals(pin);
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
