
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
        BDEmpleado bd = new BDEmpleado();
        boolean repetir = false;

        do {
            try {
                bd.connect();
                for (Empleado e : bd.selectAll()) {
                    System.out.println(e);
                }
                repetir = false;
            } catch (SQLException e) {
                System.out.println("Parece que la BD está sobrecargada... ¿Quieres reintentar la operación? (S/N)");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    repetir = true;
                }

            } finally {
                bd.disconnect();
            }

        } while (repetir);
    }

    private static void listarEmpleadosOrdenadosPorCategoria() {
        BDEmpleado bd = new BDEmpleado();
        boolean repetir = false;

        do {
            try {
                bd.connect();
                for (Empleado e : bd.selectAllOrderByCategoria()) {
                    System.out.println(e);
                }
                repetir = false;
            } catch (SQLException e) {
                System.out.println("Parece que la BD está sobrecargada... ¿Quieres reintentar la operación? (S/N)");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    repetir = true;
                }

            } finally {
                bd.disconnect();
            }

        } while (repetir);
    }

    private static void buscarEmpleadoPorCodigo() {
        BDEmpleado bd = new BDEmpleado();
        boolean repetir = false;

        do {
            try {
                Teclado t = new Teclado();
                System.out.println("Dime el código del empleado a buscar: ");
                int cod = t.leeEnteroMin(1);
                bd.connect();
                List<Empleado> lista = bd.selectByCodigo(cod);
                if(lista.isEmpty()) {
                    System.out.println("No se ha encontrado ningún empleado con el código "+cod);
                } else {
                    System.out.println(lista.get(0));
                }
                
                repetir = false;
            } catch (SQLException e) {
                System.out.println("Parece que la BD está sobrecargada... ¿Quieres reintentar la operación? (S/N)");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    repetir = true;
                }

            } finally {
                bd.disconnect();
            }

        } while (repetir);
    }

    private static void buscarEmpleadosPorCategoria() {
        BDEmpleado bd = new BDEmpleado();
        boolean repetir = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Dime la categoría de empleados a buscar: ");
                String categoria = sc.next();
                bd.connect();
                List<Empleado> lista = bd.selectByCategoria(categoria);
                if(lista.isEmpty()) {
                    System.out.println("No se ha encontrado ningún empleado con categoría "+categoria);
                } else {
                    for(Empleado e : lista) {
                        System.out.println(e);
                    }
                }
                
                repetir = false;
            } catch (SQLException e) {
                System.out.println("Parece que la BD está sobrecargada... ¿Quieres reintentar la operación? (S/N)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    repetir = true;
                }

            } finally {
                bd.disconnect();
            }

        } while (repetir);
    }

    private static void buscarEmpleadosPorNombreApellidos() {
        BDEmpleado bd = new BDEmpleado();
        boolean repetir = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Dime el nombre del empleado a buscar: ");
                String nombre = sc.nextLine();
                System.out.println("Dime los apellidos del empleado a buscar: ");
                String apellidos = sc.nextLine();
                bd.connect();
                List<Empleado> lista = bd.selectByNombreApellidos(nombre, apellidos);
                if(lista.isEmpty()) {
                    System.out.println("No se ha encontrado ningún empleado llamado "+nombre+" "+apellidos);
                } else {
                    for(Empleado e : lista) {
                        System.out.println(e);
                    }
                }
                
                repetir = false;
            } catch (SQLException e) {
                System.out.println("Parece que la BD está sobrecargada... ¿Quieres reintentar la operación? (S/N)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    repetir = true;
                }

            } finally {
                bd.disconnect();
            }

        } while (repetir);
    }

    private static void buscarEmpleadosConSalarioMinimo() {
        BDEmpleado bd = new BDEmpleado();
        boolean repetir = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Dime el salario mínimo que tendrán los empleados: ");
                double salarioMin = sc.nextDouble();
                bd.connect();
                List<Empleado> lista = bd.selectByMinSalarioOrdered(salarioMin);
                if(lista.isEmpty()) {
                    System.out.println("No se ha encontrado ningún empleado con un salario mínimo de "+salarioMin+"€");
                } else {
                    for(Empleado e : lista) {
                        System.out.println(e);
                    }
                }
                
                repetir = false;
            } catch (SQLException e) {
                System.out.println("Parece que la BD está sobrecargada... ¿Quieres reintentar la operación? (S/N)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    repetir = true;
                }

            } finally {
                bd.disconnect();
            }

        } while (repetir);
    }
}
