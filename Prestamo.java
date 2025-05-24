public class Prestamo {
    private String documentoUsuario; // Documento del usuario que solicita
    private Libro libro;

    public Prestamo(String documentoUsuario, Libro libro) {
        this.documentoUsuario = documentoUsuario;
        this.libro = libro;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public Libro getLibro() {
        return libro;
    }
}
