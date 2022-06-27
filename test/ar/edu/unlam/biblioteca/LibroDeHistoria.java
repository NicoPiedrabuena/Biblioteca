package ar.edu.unlam.biblioteca;

public class LibroDeHistoria extends Libro implements Fotocopiables {

	public LibroDeHistoria(Integer id, String nombre, String autor) {
		super(id,nombre,autor);
	}

	@Override
	public String fotocopiable() {
		// TODO Auto-generated method stub
		return getId()+"  "+ getNombre() + "  " + getAutor();
	}

}
