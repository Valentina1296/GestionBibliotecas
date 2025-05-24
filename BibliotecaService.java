import java.util.LinkedList;
import java.util.Queue;

public class BibliotecaService {
    private LinkedList<Libro> libros = new LinkedList<>();
    private Queue<Usuario> colaPrestamos = new LinkedList<>();
    private LinkedList<Usuario> usuarios = new LinkedList<>();

    public void agregarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
        System.out.println("Libro agregado exitosamente.");
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros disponibles.");
            return;
        }
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void registrarUsuario(String documento, String nombre) {
        usuarios.add(new Usuario(documento, nombre));
        System.out.println("Usuario registrado exitosamente.");
    }

    public Usuario buscarUsuario(String documento) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDocumento().equals(documento)) {
                return usuario;
            }
        }
        return null;
    }

    public void solicitarPrestamo(String documento, String titulos) {
        Usuario usuario = buscarUsuario(documento);
        if (usuario == null) {
            System.out.println("Usuario no registrado.");
            return;
        }

        String[] titulosArray = titulos.split(","); // Separar títulos por coma
        for (String titulo : titulosArray) {
            titulo = titulo.trim(); // Limpiar espacios en blanco
            boolean libroPrestado = false; // Variable para verificar si se prestó el libro

            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    if (!libro.isPrestado()) {
                        libro.prestar();
                        usuario.agregarLibro(libro);
                        System.out.println("Préstamo realizado exitosamente para el libro: " + libro.getTitulo());
                        libroPrestado = true;
                    } else {
                        colaPrestamos.add(usuario); // Añadir a la cola si no está disponible
                        System.out.println("El libro " + libro.getTitulo() + " no está disponible. Su solicitud ha sido añadida a la cola.");
                    }
                    break; // Salir del bucle si se encuentra el libro
                }
            }

            if (!libroPrestado) {
                System.out.println("Libro " + titulo + " no encontrado.");
            }
        }
    }


    public void devolverLibro(String documento, String titulo) {
        Usuario usuario = buscarUsuario(documento);
        if (usuario == null) {
            System.out.println("Usuario no registrado.");
            return;
        }

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isPrestado()) {
                    libro.devolver();
                    usuario.devolverLibro(libro);
                    System.out.println("Libro devuelto exitosamente.");

                    // Si hay usuarios en la cola, prestar el libro al siguiente
                    if (!colaPrestamos.isEmpty()) {
                        Usuario siguienteUsuario = colaPrestamos.poll();
                        libro.prestar(); // Prestar el libro al siguiente usuario
                        siguienteUsuario.agregarLibro(libro);
                        System.out.println("El libro ha sido prestado a " + siguienteUsuario.getNombre());
                    }
                } else {
                    System.out.println("El libro ya está devuelto.");
                }
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void listarLibrosPorUsuario(String documento) {
        Usuario usuario = buscarUsuario(documento);
        if (usuario != null) {
            System.out.println("Libros prestados a " + usuario.getNombre() + ":");
            for (Libro libro : usuario.getLibrosPrestados()) {
                System.out.println(libro);
            }
        } else {
            System.out.println("Usuario no registrado.");
        }
    }
}
