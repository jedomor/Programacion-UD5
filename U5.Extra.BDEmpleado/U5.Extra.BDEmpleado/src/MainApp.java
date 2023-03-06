public class MainApp {

    public static void main(String[] args) {
        int opcion;
        Teclado t = new Teclado();

        do {
            imprimeMenu();
            opcion = t.leeEntero();

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    listarEmpleadosOrdenadosPorCodigo();
                    break;
                case 2:
                    listarEmpleadosOrdenadosPorCategoria();
                    break;
                case 3:
                    buscarEmpleadoPorCodigo();
                    break;
                case 4:
                    buscarEmpleadosPorCategoria();
                    break;
                case 5:
                    buscarEmpleadosPorNombreApellidos();
                    break;
                case 6:
                    buscarEmpleadosConSalarioMinimo();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 0);
    }

    private static void imprimeMenu() {
        System.out.println("\n\n0 - Salir");
        System.out.println("1 - Listar empleados ordenados por código");
        System.out.println("2 - Listar empleados ordenados por categoría");
        System.out.println("3 - Buscar empleado por código");
        System.out.println("4 - Buscar empleados por categoría");
        System.out.println("5 - Buscar empleados por nombre y apellidos");
        System.out.println("6 - Buscar empleados con un salario mínimo");
        
        System.out.print("Escoge una opción: ");
    }

    private static void listarEmpleadosOrdenadosPorCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void listarEmpleadosOrdenadosPorCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void buscarEmpleadoPorCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void buscarEmpleadosPorCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void buscarEmpleadosPorNombreApellidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void buscarEmpleadosConSalarioMinimo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
