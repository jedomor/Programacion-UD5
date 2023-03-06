
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;


public class BDEmpleado {
    private Set<Empleado> bd;
    private boolean abierta;
    private final int TIMEOUT = 3;

    public BDEmpleado() {
        bd = new HashSet<>();
    }
    
    public void connect() throws SQLException {
        randomSobrecargaException();
        
        if(abierta) {
            throw new SQLException("ERROR: La BD ya estaba abierta");
        }
        
        abierta = true;
        int cod = 1;
        bd.add(new Empleado("Juan", "López Haro", "jlopezharo@mycompany.com", "Director", cod++, 4000));
        bd.add(new Empleado("Alberto", "Rodríguez Sanz", "arodriguezsanz@mycompany.com", "Gerente", cod++, 2000));
        bd.add(new Empleado("Ana", "Hueso Baro", "ahuesobaro@mycompany.com", "Desarrollador", cod++, 1500));
        bd.add(new Empleado("Basilio", "Pérez Haya", "bpererzhaya@mycompany.com", "Gerente", cod++, 2500));
        bd.add(new Empleado("María", "Gutiérrez Gamo ", "mgutierrezgamo@mycompany.com", "Desarrollador", cod++, 1800));
        bd.add(new Empleado("Lola", "Garmendia Faenz", "lgarmendiafaenz@mycompany.com", "Comercial", cod++, 1800));
        bd.add(new Empleado("Tomás", "Dans Elk", "tdanselk@mycompany.com", "Desarrollador", cod++, 1400));
        bd.add(new Empleado("Wendy", "Rosa Romero", "wrosaromero@mycompany.com", "Comercial", cod++, 2000));
        bd.add(new Empleado("Alberto", "Jata Romero", "ajataromero@mycompany.com", "Desarrollador", cod++, 1600));
        bd.add(new Empleado("Juana", "Sabinal Horte", "jsabinalhorte@mycompany.com", "Comercial", cod++, 1850));
        bd.add(new Empleado("Yeray", "Isla Canela", "yislacanela@mycompany.com", "Administrativo", cod++, 1400));
        bd.add(new Empleado("Tabita", "Sanz Cabezo", "tsanzcabezo@mycompany.com", "Administrativo", cod++, 1450));
    }
    
    public void disconnect() {
        abierta = false;
        bd.clear();
    }  
    
    
    public List<Empleado> selectAll() throws SQLException {
        randomSobrecargaException();
        List<Empleado> lista = new ArrayList<>(bd);
        Collections.sort(lista);
        return lista;
    }
    
    public List<Empleado> selectByCodigo(int codigo) throws SQLException {
        randomSobrecargaException();
        
        List<Empleado> lista = new ArrayList<>();
        for(Empleado e: bd) {
            if(e.getCodEmpleado() == codigo) {
                lista.add(e);
                break;
            }
        }
        Collections.sort(lista);
        return lista;
    }
    
    public List<Empleado> selectByNombreApellidos(String nombre, String apellidos) throws SQLException {
        randomSobrecargaException();
        
        List<Empleado> lista = new ArrayList<>();
        for(Empleado e: bd) {
            if(e.getNombre().equalsIgnoreCase(nombre) && 
               e.getApellidos().equalsIgnoreCase(apellidos)) {
                lista.add(e);
            }
        }
        Collections.sort(lista);
        return lista;
    }
    
    public List<Empleado> selectByCategoria(String categoria) throws SQLException {
        randomSobrecargaException();
        
        List<Empleado> lista = new ArrayList<>();
        for(Empleado e: bd) {
            if(e.getCategoria().equalsIgnoreCase(categoria)) {
                lista.add(e);
            }
        }
        Collections.sort(lista);
        return lista;
    }
    
    public List<Empleado> selectByMinSalarioOrdered(double salarioMinimo) throws SQLException {
        randomSobrecargaException();
        List<Empleado> lista = new ArrayList<>();
        for(Empleado e: bd) {
            if(e.getSalario() >= salarioMinimo) {
                lista.add(e);
            }
        }
        Collections.sort(lista, new SortbySalarioAsc());
        return lista;
    }
    
    public List<Empleado> selectByMaxSalarioOrdered(double salarioMaximo) throws SQLException {
        randomSobrecargaException();
        List<Empleado> lista = new ArrayList<>();
        for(Empleado e: bd) {
            if(e.getSalario() <= salarioMaximo) {
                lista.add(e);
            }
        }
        Collections.sort(lista, new SortbySalarioAsc());
        return lista;
    }
    
    public List<Empleado> selectAllOrderByCategoria() throws SQLException {
        randomSobrecargaException();
        List<Empleado> lista = new ArrayList<>(bd);
        Collections.sort(lista, new SortbyCategory());
        // Collections.sort(lista, (e1, e2) -> e1.getCategoria().compareToIgnoreCase(e2.getCategoria()));
        return lista;
    }
    
    private void randomSobrecargaException() throws SQLException {
        Random r = new Random();
        int aleatorio = r.nextInt(101); 
        if (aleatorio <= 10) {
            esperaSegundos(TIMEOUT);
            throw new SQLException("ERROR: Se sobrepasó el tiempo de espera. ");
        } 
    }
    
    private void esperaSegundos(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException ex) {
            System.out.println("Falló al hacer la pausa de la APP");
        }
    }

}

class SortbyCategory implements Comparator<Empleado> {
 
    // Method
    // Sorting in ascending order of name
    public int compare(Empleado a, Empleado b)
    {
 
        return a.getCategoria().compareTo(b.getCategoria());
    }
}

class SortbySalarioAsc implements Comparator<Empleado> {
 
    // Method
    // Sorting in ascending order of name
    public int compare(Empleado a, Empleado b)
    {
 
        return Double.compare(a.getSalario(), b.getSalario());
    }
}
