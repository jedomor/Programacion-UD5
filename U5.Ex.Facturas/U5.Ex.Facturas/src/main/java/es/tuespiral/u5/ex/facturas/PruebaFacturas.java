package es.tuespiral.u5.ex.facturas;

public class PruebaFacturas {
    public static void main(String[] args) {
        try {
            Producto productoPrecioError = new Producto("X", "X", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        
        try {
            Factura facturaSinFecha = new Factura("");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println("--------");
        
        Factura f = new Factura("12/03/2022");
        
        f.agregarProducto(new Producto("Hogar", "Lavadora", 300));
        f.agregarProducto(new Producto("Hogar", "Frigorífico", 400));
        f.agregarProducto(new Producto("Hogar", "Lavavajillas", 350));
        f.agregarProducto(new Producto("Tecnología", "Router", 50));
        f.agregarProducto(new Producto("Tecnología", "Impresora", 120));
        
        f.imprimirFactura();
        
        System.out.println("--------");
        double importeHogar = f.calcularImporteCategoria("Hogar");
        System.out.println("El importe total de la categoría Hogar es: "+importeHogar);
        
    }
}
