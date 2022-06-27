package ar.edu.unlam.biblioteca;

import java.util.HashSet;
import java.util.TreeMap;
public class Biblioteca {

	private String nombre;
	private HashSet<Libro>librosDisponibles;
	private TreeMap<Integer,Alumno>librosPrestados;

	public Biblioteca(String string) {
		this.setNombre(string);
		this.librosDisponibles = new HashSet<Libro>();
		setLibrosPrestados(new TreeMap<Integer,Alumno>());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarLibroDisponible(Libro libro) {
		librosDisponibles.add(libro);
	}
	public Integer cantidadLibrosDisponibles() {
		return librosDisponibles.size();
	}

	public TreeMap<Integer,Alumno> getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(TreeMap<Integer,Alumno> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	public void prestarLibro(Integer identificadorPrestamo, Alumno estudiante, Libro libro) throws SoloPuedeRentarDosLibros {
		if(estudiante.getLibros().size() <2) {
		librosPrestados.put(identificadorPrestamo, estudiante);
		librosPrestados.get(identificadorPrestamo).llevarLibro(libro);
		librosDisponibles.remove(libro);
		}else {
			throw new SoloPuedeRentarDosLibros("estas llevando mas de lo que puedes chaval");
		}
		
	}

	public void libroDevuelto(Integer id, Alumno estudiante) {
		librosDisponibles.add(estudiante.getLibroEspecifico(id));
		estudiante.getLibros().remove(estudiante.getLibroEspecifico(id));
	}

	public String imprimirLibrosFotocopiables() {
		String resultado ="";
		for (Libro libro : librosDisponibles) {
			if(libro instanceof Fotocopiables) {
				resultado += libro +"\n";
			}
		}
		return resultado;
		
	}
	
}
