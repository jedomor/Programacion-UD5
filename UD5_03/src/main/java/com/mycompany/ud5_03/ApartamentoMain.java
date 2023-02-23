package com.mycompany.ud5_03;

public class ApartamentoMain {

    public static void main(String[] args) {

        try {
            Apartamento a = new Apartamento(null, 1, 5, true);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        try {
            Apartamento a = new Apartamento("Sevilla", 0, 5, true);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Apartamento a = new Apartamento("Sevilla", 1, 0, true);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Apartamento a = new Apartamento("Sevilla", 1, 5, true);
            a.ocupar();
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        try {
            Apartamento a = new Apartamento("Sevilla", 1, 5, false);
            a.liberar();
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        
        Apartamento apt1 = new Apartamento("Sevilla", 4, 8, true);
        System.out.println("Datos apartamento 1");
        System.out.println("Dirección: "+apt1.getDireccionPostal());
        System.out.println("Numero de camas: "+apt1.getNumeroCamas());
        System.out.println("Numero de habitaciones: "+apt1.getNumeroHabitaciones());
        System.out.println("Estado de ocupación: " +(apt1.isEstaOcupado() ? "Ocupada" : "Vacía"));
    }
}
