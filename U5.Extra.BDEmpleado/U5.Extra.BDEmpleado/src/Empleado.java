public class Empleado implements Comparable {
    private String nombre, apellidos, email, categoria;
    private int codEmpleado;
    private double salario;

    public Empleado(String nombre, String apellidos, String email, String categoria, int codEmpleado, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.categoria = categoria;
        this.codEmpleado = codEmpleado;
        this.salario = salario;
    }

    @Override
    public int compareTo(Object o) {
        Empleado emp = (Empleado) o;
        return Integer.compare(codEmpleado, emp.getCodEmpleado());
    }

    @Override
    public String toString() {
        return "CODIGO=" + codEmpleado +", NOMBRE=" + nombre + ", APELLIDOS=" + apellidos + ", EMAIL=" + email + ", CATEGORIA=" + categoria + ", SALARIO=" + salario +"€";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.codEmpleado;
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
        final Empleado other = (Empleado) obj;
        return this.codEmpleado == other.codEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public double getSalario() {
        return salario;
    }
    
    
}
