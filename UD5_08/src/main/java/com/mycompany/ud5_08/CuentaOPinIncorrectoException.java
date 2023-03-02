
package com.mycompany.ud5_08;

public class CuentaOPinIncorrectoException extends Exception{

    /**
     * Creates a new instance of <code>CuentaPinIncorrecto</code> without detail
     * message.
     */
    public CuentaOPinIncorrectoException() {
    }

    /**
     * Constructs an instance of <code>CuentaPinIncorrecto</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CuentaOPinIncorrectoException(String msg) {
        super(msg);
    }
}
