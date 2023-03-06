package es.tuespiral.extra.colapacientes;

import java.util.ArrayList;
import java.util.List;

public class ColaPacientes {

    private List<Paciente> cola;

    public ColaPacientes() {
        cola = new ArrayList<>();
    }

    public void agregaPaciente(Paciente p) {
        cola.add(p);
    }

    public void vacunaSiguientePaciente() throws ColaVaciaException {
        if(cola.isEmpty()) {
            throw new ColaVaciaException("Ya no quedan pacientes en la cola");
        } else {
            try {
                Paciente p = cola.get(0);
                p.vacunar();
                System.out.println(p.getNombre()+" se ha vacunado");
            } catch (PacienteVacunadoException ex) {
                System.out.println("¡Hay que estar aburrido para querer vacunarse 2 veces!");
            } finally {
                cola.remove(0);
            }
        }
    }

}
