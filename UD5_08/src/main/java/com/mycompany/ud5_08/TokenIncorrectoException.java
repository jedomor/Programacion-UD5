
package com.mycompany.ud5_08;

public class TokenIncorrectoException extends Exception{

    /**
     * Creates a new instance of <code>TokenIncorrectoException</code> without
     * detail message.
     */
    public TokenIncorrectoException() {
    }

    /**
     * Constructs an instance of <code>TokenIncorrectoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TokenIncorrectoException(String msg) {
        super(msg);
    }
}
