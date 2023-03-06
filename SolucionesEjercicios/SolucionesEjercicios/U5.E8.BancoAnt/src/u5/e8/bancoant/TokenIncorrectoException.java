/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u5.e8.bancoant;

/**
 *
 * @author mariajesus
 */
public class TokenIncorrectoException extends Exception {

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
