package com.mycompany.ud5_08;

import java.io.*;
import java.util.*;

public class Banco {

    private Map<Long, CuentaCorriente> cuentasCorrientes;
    private Map<Integer, CuentaCorriente> cuentasConectadas;

    public Banco() {
        cuentasCorrientes = new HashMap<Long, CuentaCorriente>();
        cuentasConectadas = new HashMap<Integer, CuentaCorriente>();
        cuentasCorrientes.put(123456789L, new CuentaCorriente(123456789L, "1234", 1000));
        cuentasCorrientes.put(987654321L, new CuentaCorriente(987654321L, "4321", 2000));
        cuentasCorrientes.put(111111111L, new CuentaCorriente(111111111L, "1111", 3000));
        cuentasCorrientes.put(222222222L, new CuentaCorriente(222222222L, "2222", 4000));
    }

    public int abreConexion(long numeroCuenta, String pin) throws CuentaOPinIncorrectoException {
        CuentaCorriente cuenta = cuentasCorrientes.get(numeroCuenta);
        if (cuenta == null || !cuenta.validarPin(pin)) {
            throw new CuentaOPinIncorrectoException();
        }
        int token = new Random().nextInt(1000000);
        cuentasConectadas.put(token, cuenta);
        return token;
    }

    public void realizaPago(int tokenCuenta, double importe) throws TokenIncorrectoException, SaldoInsuficienteException {
        CuentaCorriente cuenta = cuentasConectadas.get(tokenCuenta);
        if (cuenta == null) {
            throw new TokenIncorrectoException();
        }
        if (cuenta.getSaldo() < importe) {
            throw new SaldoInsuficienteException();
        }
        cuenta.setSaldo(cuenta.getSaldo() - importe);
    }

    public void cierraConexion(int tokenCuenta) throws TokenIncorrectoException {
        CuentaCorriente cuenta = cuentasConectadas.remove(tokenCuenta);
        if (cuenta == null) {
            throw new TokenIncorrectoException();
        }
    }

}
