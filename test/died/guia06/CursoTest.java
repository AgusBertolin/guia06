package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {

	Alumno a1;
	Alumno a2;
	Curso c1;
	
	@BeforeEach
	public void init() {
		a1 = new Alumno();
		a2 = new Alumno();
		c1 = new Curso();
		c1.setCupo(30);
		a1.setNombre("Alex");
		a1.setNroLibreta(2415);
		a2.setNombre("Maria");
		a2.setNroLibreta(1246);
	}
	
	@Test
	void testInscribirExitoso() {
		c1.inscribirAlumno(a1);
		assertTrue(c1.getInscriptos().contains(a1));
	}

	@Test
	void testInscribirNoExitosoCupoLleno() {
		c1.setCupo(0);
		c1.inscribirAlumno(a1);
		assertFalse(c1.getInscriptos().contains(a1));
	}
	
	@Test
	void testInscribirNoExitosoCreditosInsuficientes() {
		c1.setCreditosRequeridos(12);
		c1.inscribirAlumno(a1);
		assertFalse(c1.getInscriptos().contains(a1));
	}
	
	@Test
	void testInscribirNoExitosoAlumnoSuperoCantidadCursosMaxima() {
		Curso c2 = new Curso();
		Curso c3 = new Curso();
		Curso c4 = new Curso();
		c2.setCupo(1);
		c3.setCupo(1);
		c4.setCupo(1);
		c2.inscribirAlumno(a1);
		c3.inscribirAlumno(a1);
		c4.inscribirAlumno(a1);
		c1.inscribirAlumno(a1);
		assertFalse(c1.getInscriptos().contains(a1));
	}
	
	@Test
	void testImprimirInscriptosPorNombre() {
		c1.inscribirAlumno(a1);
		c1.inscribirAlumno(a2);
		List<Alumno> aux = c1.getInscriptos();
		Collections.sort(aux, new SortByNombre());
		c1.imprimirInscriptosPorNombre();
		assertEquals(aux, c1.getInscriptos());
	}

	@Test
	void testImprimirInscriptosPorNroLibreta() {
		c1.inscribirAlumno(a1);
		c1.inscribirAlumno(a2);
		List<Alumno> aux = c1.getInscriptos();
		Collections.sort(aux, new SortByLibreta());
		c1.imprimirInscriptosPorNroLibreta();
		assertEquals(aux, c1.getInscriptos());
	}

	@Test
	void testImprimirInscriptosPorCreditos() {
		c1.inscribirAlumno(a1);
		c1.inscribirAlumno(a2);
		List<Alumno> aux = c1.getInscriptos();
		Collections.sort(aux, new SortByCreditos());
		c1.imprimirInscriptosPorCreditos();
		assertEquals(aux, c1.getInscriptos());
	}

}
