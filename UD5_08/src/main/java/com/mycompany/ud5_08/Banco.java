package com.mycompany.ud5_08;

import java.io.*;
import java.util.*;

public class Banco {

    private Map<Long, CuentaCorriente> cuentasCorrientes;
    private Map<Integer, CuentaCorriente> cuentasConectadas;

    public Banco() {
        cuentasCorrientes = new HashMap<>();
        cuentasConectadas = new HashMap<>();
        CuentaCorriente c1 = new CuentaCorriente(123456789L, "1234", 1000);
        CuentaCorriente c2 = new CuentaCorriente(987654321L, "4321", 2000);
        CuentaCorriente c3 = new CuentaCorriente(111111111L, "1111", 3000);
        CuentaCorriente c4 = new CuentaCorriente(222222222L, "2222", 4000);
        cuentasCorrientes.put(c1.getNumeroCuenta(), c1);
        cuentasCorrientes.put(c2.getNumeroCuenta(), c2);
        cuentasCorrientes.put(c3.getNumeroCuenta(), c3);
        cuentasCorrientes.put(c4.getNumeroCuenta(), c4);
    }

    public int abreConexion(long numeroCuenta, String pin) throws CuentaOPinIncorrectoException {
        CuentaCorriente cuenta = cuentasCorrientes.get(numeroCuenta);
        if (cuenta == null || !cuenta.validarPin(pin)) {
            throw new CuentaOPinIncorrectoException("el codigo pin introducido no es correcto");
        }
        int token = new Random().nextInt(1000000);
        cuentasConectadas.put(token, cuenta);
        return token;
    }

    public void realizaPago(int tokenCuenta, double importe) throws TokenIncorrectoException, SaldoInsuficienteException {
        CuentaCorriente cuenta = cuentasConectadas.get(tokenCuenta);
        if (cuenta == null) {
            throw new TokenIncorrectoException("La conexión no se ha realizado");
        }
        if (cuenta.getSaldo() < importe) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el pago");
        }
        cuenta.setSaldo(cuenta.getSaldo() - importe);
    }

    public void cierraConexion(int tokenCuenta) throws TokenIncorrectoException {
        CuentaCorriente cuenta = cuentasConectadas.remove(tokenCuenta);
        if (cuenta == null) {
            throw new TokenIncorrectoException("La conexión no se ha realizado");
        }
    }

}
