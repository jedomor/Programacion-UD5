package es.tuespiral.u5.ex.facturas;

import java.util.Objects;


public class Producto implements Comparable {
    private String categoria, nombre;
    private double precio;

    public Producto(String categoria, String nombre, double precio) {
        if(categoria == null) {
            throw new NullPointerException("La categoría no puede ser nula");
        }
        
        if(categoria.equals("")) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
        
        if(nombre == null) {
            throw new NullPointerException("El nombre del producto no puede ser nulo");
        }
        
        if(nombre.equals("")) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        
        if(precio <= 0) {
            throw new IllegalArgumentException("El precio no puede ser cero o negativo");
        }
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }


    public String getNombre() {
        return nombre;
    }


    public double getPrecio() {
        return precio;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        Producto p = (Producto) o;
        int result = categoria.compareTo(p.getCategoria());
        if (result == 0) {
            result = -Double.compare(precio, p.getPrecio());
        }
        return result;
    }
    
    
}
