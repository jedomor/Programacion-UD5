package com.mycompany.ud5_08;

public class SaldoInsuficienteException extends Exception {

    /**
     * Creates a new instance of <code>SaldoInsuficienteException</code> without
     * detail message.
     */
    public SaldoInsuficienteException() {
    }

    /**
     * Constructs an instance of <code>SaldoInsuficienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
