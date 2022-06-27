package ar.edu.unlam.biblioteca;

import java.util.HashSet;

public class Alumno {
	private Integer dni;
	private String nombre;
	private String apellido;
	private HashSet<Libro>libros;
	public Alumno(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		libros = new HashSet<Libro>();
		
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public HashSet<Libro> getLibros() {
		return libros;
	}
	public void setLibros(HashSet<Libro> libros) {
		this.libros = libros;
	}
	public void llevarLibro(Libro libro) {
		libros.add(libro);	
	}
	public Libro getLibroEspecifico(Integer id) {
		Libro libroObtenido = null;
		for (Libro libro : libros) {
			if(libro.getId().equals(id)) {
				libroObtenido = libro;
			}
		}
		return libroObtenido;
	}
	
}
