package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class AlumnoTest {

	Alumno a1;
	Curso c1;
	Curso c2;
	
	@Before
	public void init() {
		 a1 = new Alumno();
		 c1 = new Curso();
		 c2 = new Curso();
		 c2.setCreditosRequeridos(10);
	}
	
	@Test
	void testCreditosObtenidosSinCursados() {
		int esperoCero = a1.creditosObtenidos();
		assertEquals(esperoCero, 0);
	}
	
	@Test
	void testCreditosObtenidosConAprobados() {
		c1.setCreditos(3);
		a1.inscripcionAceptada(c1);
		a1.aprobar(c1);
		int esperoTres = a1.creditosObtenidos();
		assertEquals(esperoTres, 3);
	}
	
	@Test
	void testAprobar() {
		a1.inscripcionAceptada(c1);
		a1.aprobar(c1);
		assertTrue(a1.getAprobados().contains(c1));
		assertFalse(a1.getCursando().contains(c1));
	}
	
	@Test
	void testAprobarSinCursar() {
		a1.aprobar(c2);
		assertFalse(a1.getAprobados().contains(c2));
		assertFalse(a1.getCursando().contains(c2));
	}

	@Test
	void testInscripcionAceptada() {
		a1.inscripcionAceptada(c1);
		assertTrue(a1.getCursando().contains(c1));
	}
}
