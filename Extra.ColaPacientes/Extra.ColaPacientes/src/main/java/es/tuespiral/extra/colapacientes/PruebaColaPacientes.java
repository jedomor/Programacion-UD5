package es.tuespiral.extra.colapacientes;


public class PruebaColaPacientes {

    public static void main(String[] args) {
        ColaPacientes cola = new ColaPacientes();
        cola.agregaPaciente(new Paciente("Juan", false));
        cola.agregaPaciente(new Paciente("Ana", false));
        cola.agregaPaciente(new Paciente("Pedro", true));
        cola.agregaPaciente(new Paciente("Esteban", false));

        try {
            while (true) {
                cola.vacunaSiguientePaciente();
            }
        } catch (ColaVaciaException ex) {
            System.out.println("Todos los pacientes están vacunados");
        }
    }
}

