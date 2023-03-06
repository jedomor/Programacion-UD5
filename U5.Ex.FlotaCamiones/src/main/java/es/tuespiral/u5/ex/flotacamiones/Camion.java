package es.tuespiral.u5.ex.flotacamiones;

import java.util.Objects;

public class Camion {
    private String matricula;
    private boolean revisionPasada, depositoCompleto;
    private int kmRecorridos;

    public Camion(String matricula, boolean revisionPasada, boolean depositoCompleto, int kmRecorridos) {
        if(matricula == null) {
            throw new NullPointerException("La matrícula no puede ser nula");
        }
        if(kmRecorridos < 0) {
            throw new IllegalArgumentException("Los km recorridos no pueden ser negativos");
        }
            
        this.matricula = matricula;
        this.revisionPasada = revisionPasada;
        this.depositoCompleto = depositoCompleto;
        this.kmRecorridos = kmRecorridos;
    }

    public void llenaDeposito() {
        depositoCompleto = true;
    }
    
    public void realizaRuta() {
        if (revisionPasada && depositoCompleto) {
            kmRecorridos += 500;
        } else {
            throw new IllegalStateException("Pendiente de revisión o falta combustible");
        } 
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Camion other = (Camion) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Camion{" + "matricula=" + matricula + ", revisionPasada=" + revisionPasada + ", depositoCompleto=" + depositoCompleto + ", kmRecorridos=" + kmRecorridos + '}';
    }
    
}
