import java.util.UUID;

public class Libro {
    private Long id; // Identificador único del libro
    private String titulo;
    private String autor;
    private boolean prestado;
    private static long contador = 0;

    public Libro(String titulo, String autor) {
        this.id =  ++contador; // Genera un ID único
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        this.prestado = true;
    }

    public void devolver() {
        this.prestado = false;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ID: " + id + ", Prestado: " + (prestado ? "Sí" : "No");
    }
}
