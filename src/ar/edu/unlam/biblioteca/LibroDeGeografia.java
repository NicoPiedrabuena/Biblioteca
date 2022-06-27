package ar.edu.unlam.biblioteca;

public class LibroDeGeografia extends Libro implements Fotocopiables {
	

	public LibroDeGeografia(Integer id, String nombre, String autor) {
		super(id,nombre,autor);
	}

	@Override
	public String fotocopiable() {
		// TODO Auto-generated method stub
		return null;
	}

}
