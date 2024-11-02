import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputadoraDAO computadoraDAO = new ComputadoraDAO();

        while (true) {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Insertar computadora");
            System.out.println("2. Actualizar computadora");
            System.out.println("3. Eliminar computadora");
            System.out.println("4. Ver todas las computadoras");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertarComputadora(scanner, computadoraDAO);
                    break;
                case 2:
                    actualizarComputadora(scanner, computadoraDAO);
                    break;
                case 3:
                    eliminarComputadora(scanner, computadoraDAO);
                    break;
                case 4:
                    verComputadoras(computadoraDAO);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private static void insertarComputadora(Scanner scanner, ComputadoraDAO computadoraDAO) {
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Marca: ");
        String marca = scanner.next();

        Computadora computadora = new Computadora(0, nombre, precio, cantidad, marca);
        computadoraDAO.insertarComputadora(computadora);
        System.out.println("Computadora insertada exitosamente.");
    }

    private static void actualizarComputadora(Scanner scanner, ComputadoraDAO computadoraDAO) {
        System.out.print("ID de la computadora a actualizar: ");
        int id = scanner.nextInt();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Nueva cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Nueva marca: ");
        String marca = scanner.next();

        Computadora computadora = new Computadora(id, nombre, precio, cantidad, marca);
        computadoraDAO.actualizarComputadora(computadora);
        System.out.println("Computadora actualizada exitosamente.");
    }

    private static void eliminarComputadora(Scanner scanner, ComputadoraDAO computadoraDAO) {
        System.out.print("ID de la computadora a eliminar: ");
        int id = scanner.nextInt();

        computadoraDAO.eliminarComputadora(id);
        System.out.println("Computadora eliminada exitosamente.");
    }

    private static void verComputadoras(ComputadoraDAO computadoraDAO) {
        List<Computadora> computadoras = computadoraDAO.obtenerComputadoras();
        System.out.println("\n--- Lista de Computadoras ---");
        for (Computadora computadora : computadoras) {
            System.out.println("ID: " + computadora.getId() +
                               ", Nombre: " + computadora.getNombre() +
                               ", Precio: " + computadora.getPrecio() +
                               ", Cantidad: " + computadora.getCantidad() +
                               ", Marca: " + computadora.getMarca());
        }
    }
}
