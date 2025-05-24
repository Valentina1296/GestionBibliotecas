import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String documento;
    private String nombre;
    private Set<Libro> librosPrestados;

    public Usuario(String documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
        this.librosPrestados = new HashSet<>();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void agregarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }
}
