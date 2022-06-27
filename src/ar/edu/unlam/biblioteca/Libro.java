package ar.edu.unlam.biblioteca;

import java.util.Objects;

public class Libro {

	private Integer id;
	private String nombre;
	private String autor;

	public Libro(Integer id, String nombre, String autor) {
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "El libro  con id = " + id + "  nombre = " + nombre + ", del autor = " + autor ;
	}
	

}
