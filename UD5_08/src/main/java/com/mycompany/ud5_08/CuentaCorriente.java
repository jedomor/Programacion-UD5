
package com.mycompany.ud5_08;

public class CuentaCorriente {
    private long numeroCuenta;
    private String pin;
    private double saldo;

    public CuentaCorriente(long numeroCuenta, String pin, double saldo) {
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
