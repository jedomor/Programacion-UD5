package es.tuespiral.u5.e3.apartamento;

public class Apartamento {
    private String direccion;
    private int numHabitaciones;
    private int numCamas;
    private boolean ocupado;

    public Apartamento(String direccion, int numHabitaciones, int numCamas, boolean ocupado) {
        // Cláusulas de guarda
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula");
        } 
        
        if(numHabitaciones <= 0 || numHabitaciones >= 50) {
            throw new IllegalArgumentException("Número de habitaciones inválido");
        }
        
        if(numCamas <= 0 || numCamas >= 50) {
            throw new IllegalArgumentException("Número de camas inválido");
        }
        
        // Código productivo del constructor
        this.direccion = direccion;
        this.numHabitaciones = numHabitaciones;
        this.numCamas = numCamas;
        this.ocupado = ocupado;
        
    }
    
    public void liberar() {
        if (ocupado == false) {
            throw new IllegalStateException("El apartamento ya está libre");
        }
        ocupado = false;

    }
    
    public void ocupar() {
        if (ocupado == true) {
            throw new IllegalStateException("El apartamento ya está ocupado");
        }
        ocupado = true;
    }
}
