import java.util.Scanner;

public class Biblioteca {
    private BibliotecaService bibliotecaService;
    private Scanner scanner;

    public Biblioteca() {
        bibliotecaService = new BibliotecaService();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        agregarLibros(); // Agregar libros al iniciar
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> bibliotecaService.listarLibros();
                case 3 -> solicitarPrestamo();
                case 4 -> devolverLibro();
                case 5 -> registrarUsuario();
                case 6 -> listarLibrosPorUsuario();
                case 7 -> salir = true;
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        System.out.println("¡Gracias por utilizar el sistema de gestión de bibliotecas!");
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú Biblioteca ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Listar disponibilidad libros");
        System.out.println("3. Solicitar préstamo");
        System.out.println("4. Devolver libro");
        System.out.println("5. Registrar usuario");
        System.out.println("6. Listar libros por usuario");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();

        bibliotecaService.agregarLibro(titulo, autor);
    }

    private void solicitarPrestamo() {
        System.out.print("Ingrese su Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese los títulos de los libros que desea solicitar (separados por comas): ");
        String titulos = scanner.nextLine();
        bibliotecaService.solicitarPrestamo(documento, titulos);
    }

    private void devolverLibro() {
        System.out.print("Ingrese su Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese el título del libro que desea devolver: ");
        String titulo = scanner.nextLine();
        bibliotecaService.devolverLibro(documento, titulo);
    }

    private void registrarUsuario() {
        System.out.print("Ingrese su Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        bibliotecaService.registrarUsuario(documento, nombre);
    }

    private void listarLibrosPorUsuario() {
        System.out.print("Ingrese su Documento: ");
        String documento = scanner.nextLine();
        bibliotecaService.listarLibrosPorUsuario(documento);
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.iniciar();
    }

    private void agregarLibros() {
        bibliotecaService.agregarLibro("Cien años de soledad", "Gabriel García Márquez");
        bibliotecaService.agregarLibro("Don Quijote de la Mancha", "Miguel de Cervantes");
        bibliotecaService.agregarLibro("1984", "George Orwell");
        bibliotecaService.agregarLibro("El gran Gatsby", "F. Scott Fitzgerald");
        bibliotecaService.agregarLibro("Crimen y castigo", "Fiódor Dostoyevski");
        bibliotecaService.agregarLibro("Moby Dick", "Herman Melville");
    }
}
