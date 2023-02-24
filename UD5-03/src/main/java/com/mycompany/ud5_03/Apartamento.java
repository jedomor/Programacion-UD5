package com.mycompany.ud5_03;

import java.util.*;

public class Apartamento {

    private String direccionPostal;
    private int numeroHabitaciones, numeroCamas;
    private boolean estaOcupado;

    public Apartamento(String direccionPostal, int numeroHabitaciones, int numeroCamas, boolean estaOcupado) {
        if (direccionPostal == null) {
            throw new NullPointerException("La dirección postal no puede ser null");
        }
        if (numeroHabitaciones < 1 || numeroHabitaciones > 100) {
            throw new IllegalArgumentException("El numero de habitaciones debe estar entre 1 y 100");
        }
        if (numeroCamas < 1 || numeroCamas > 100) {
            throw new IllegalArgumentException("El numero de habitaciones debe estar entre 1 y 100");
        }
        
        this.direccionPostal = direccionPostal;
        this.estaOcupado = estaOcupado;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroCamas = numeroCamas;
    }

    public void ocupar() {
        if (estaOcupado) {
            throw new IllegalStateException("Error La habitación ya estaba ocupada");
        }
        estaOcupado = true;
    }

    public void liberar() {
        if (!estaOcupado) {
            throw new IllegalStateException("Error La habitación ya estaba vacía");
        }
        estaOcupado = false;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    
    
    
}
