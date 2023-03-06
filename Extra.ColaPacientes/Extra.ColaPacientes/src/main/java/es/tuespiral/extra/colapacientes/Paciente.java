package es.tuespiral.extra.colapacientes;

public class Paciente {

    private String nombre;

    private boolean vacunado;

    public Paciente(String nombre, boolean vacunado) {
        this.nombre = nombre;
        this.vacunado = vacunado;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void vacunar() throws PacienteVacunadoException {
        if(!vacunado) {
            vacunado = true;
        } else  {
            throw new PacienteVacunadoException("El paciente ya está vacunado");
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
