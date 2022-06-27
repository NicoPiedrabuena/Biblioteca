package ar.edu.unlam.biblioteca;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBiblioteca {

	@Test
	public void queSePuedaCrearLaBiblioteca() {
		Biblioteca unlam = new Biblioteca ("UNLaM");
		assertNotNull(unlam);
		assertEquals("UNLaM",unlam.getNombre());
	}
	@Test
	public void queSePuedaAgregarDistintosLibros() {
		Biblioteca unlam = new Biblioteca ("UNLaM");
		Fotocopiables libroDeHistoria = new LibroDeHistoria(1,"historia argentina","felipe pigna");
		Fotocopiables libroDeGeografia = new LibroDeGeografia(2,"Europa","Ibai Llanos");
		Libro libroDeMatematica = new LibroDeMatematicas (3,"teorema de pitagoras", "Mauricio  contreras");
		
		unlam.agregarLibroDisponible((Libro) libroDeHistoria);
		unlam.agregarLibroDisponible((Libro) libroDeGeografia);
		unlam.agregarLibroDisponible(libroDeMatematica);
		assertEquals((Integer)3,unlam.cantidadLibrosDisponibles());
	}
	@Test
	public void queSePuedaPrestarUnLibro() throws SoloPuedeRentarDosLibros {
		Biblioteca unlam = new Biblioteca ("UNLaM");
		Fotocopiables libroDeHistoria = new LibroDeHistoria(1,"historia argentina","felipe pigna");
		Alumno estudiante = new Alumno (2131,"nicolas", "piedrabuena");
		unlam.agregarLibroDisponible((Libro) libroDeHistoria);
		
		unlam.prestarLibro(1,estudiante,(Libro) libroDeHistoria);
		assertEquals((Integer)0 , unlam.cantidadLibrosDisponibles());
		assertEquals((Integer)1, (Integer)unlam.getLibrosPrestados().size());
	}
	@Test (expected = SoloPuedeRentarDosLibros.class)
	public void queNoSePuedaPrestarMasdeDosLibrosPorAlumno() throws SoloPuedeRentarDosLibros {
		Biblioteca unlam = new Biblioteca ("UNLaM");
		Fotocopiables libroDeHistoria = new LibroDeHistoria(1,"historia argentina","felipe pigna");
		Fotocopiables libroDeGeografia = new LibroDeGeografia(2,"Europa","Ibai Llanos");
		Libro libroDeMatematica = new LibroDeMatematicas (3,"teorema de pitagoras", "Mauricio  contreras");
		Alumno estudiante = new Alumno (2131,"nicolas", "piedrabuena");
		unlam.agregarLibroDisponible((Libro) libroDeHistoria);
		unlam.agregarLibroDisponible((Libro) libroDeGeografia);
		unlam.agregarLibroDisponible(libroDeMatematica);
		unlam.prestarLibro(1,estudiante,(Libro) libroDeHistoria);
		unlam.prestarLibro(2,estudiante,(Libro) libroDeGeografia);
		unlam.prestarLibro(3,estudiante,(Libro) libroDeMatematica);
		
	}
	@Test
	public void queSePuedaDevolverUnLibroPrestado() throws SoloPuedeRentarDosLibros {
		Biblioteca unlam = new Biblioteca ("UNLaM");
		Fotocopiables libroDeHistoria = new LibroDeHistoria(1,"historia argentina","felipe pigna");
		Fotocopiables libroDeGeografia = new LibroDeGeografia(2,"Europa","Ibai Llanos");
		Libro libroDeMatematica = new LibroDeMatematicas (3,"teorema de pitagoras", "Mauricio  contreras");
		Alumno estudiante = new Alumno (2131,"nicolas", "piedrabuena");
		unlam.agregarLibroDisponible((Libro) libroDeHistoria);
		unlam.agregarLibroDisponible((Libro) libroDeGeografia);
		unlam.agregarLibroDisponible(libroDeMatematica);
		unlam.prestarLibro(1,estudiante,(Libro) libroDeHistoria);
		unlam.prestarLibro(2,estudiante,(Libro) libroDeGeografia);
	
		unlam.libroDevuelto(1,estudiante);
		
		
		assertEquals((Integer)1,(Integer)estudiante.getLibros().size());
		assertEquals((Integer)2,(Integer)unlam.cantidadLibrosDisponibles());
		assertEquals("Europa", estudiante.getLibroEspecifico(2).getNombre());
	}
	@Test
	public void queSePuedanImprimirLibrosFotocopiables() throws SoloPuedeRentarDosLibros {
		Biblioteca unlam = new Biblioteca ("UNLaM");
		Fotocopiables libroDeHistoria = new LibroDeHistoria(1,"historia argentina","felipe pigna");
		Fotocopiables libroDeGeografia = new LibroDeGeografia(2,"Europa","Ibai Llanos");
		Libro libroDeMatematica = new LibroDeMatematicas (3,"teorema de pitagoras", "Mauricio  contreras");
		unlam.agregarLibroDisponible((Libro) libroDeHistoria);
		unlam.agregarLibroDisponible((Libro) libroDeGeografia);
		unlam.agregarLibroDisponible(libroDeMatematica);
		System.out.println(unlam.imprimirLibrosFotocopiables());
		
		}
}
