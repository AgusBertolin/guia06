package died.guia06;

public class App {

	public static void main(String[] args) {
		Alumno a1 = new Alumno();
		Alumno a2 = new Alumno();
		Alumno a3 = new Alumno();
		Alumno a4 = new Alumno();
		Alumno a5 = new Alumno();
		
		a1.setNombre("Alex");
		a2.setNombre("Delfina");
		a3.setNombre("Matias");
		a4.setNombre("Juan");
		a5.setNombre("Carla");
		
		a1.setNroLibreta(1234);
		a2.setNroLibreta(7852);
		a3.setNroLibreta(8453);
		a4.setNroLibreta(3733);
		a5.setNroLibreta(2443);
		
		Curso c1 = new Curso();
		Curso c2 = new Curso();
		Curso c3 = new Curso();
		Curso c4 = new Curso();
		Curso c5 = new Curso();
		Curso c6 = new Curso();
		
		c1.setCupo(30);
		c2.setCupo(3);
		c3.setCupo(10);
		c4.setCupo(2);
		c5.setCupo(2);
		c6.setCupo(2);
		
		c1.setCreditos(10);
		c2.setCreditos(6);
		c3.setCreditos(8);
		c4.setCreditos(13);
		
		c1.setCreditosRequeridos(5);
		c2.setCreditosRequeridos(0);
		c3.setCreditosRequeridos(0);
		c4.setCreditosRequeridos(14);
		c5.setCreditosRequeridos(0);
		c6.setCreditosRequeridos(0);
		
		c2.inscribirAlumno(a1);
		c2.inscribirAlumno(a2);
		c2.inscribirAlumno(a5);
		c2.inscribirAlumno(a3);
		
		c2.imprimirInscriptosPorNombre();
		
		c3.inscribirAlumno(a2);
		c3.inscribirAlumno(a4);
		c3.inscribirAlumno(a3);
		
		c3.imprimirInscriptosPorNroLibreta();
		
		a2.aprobar(c2);
		a2.aprobar(c3);
		a3.aprobar(c3);
		
		c1.inscribirAlumno(a3);
		c1.inscribirAlumno(a2);
		c4.inscribirAlumno(a2);
		c1.inscribirAlumno(a1);
		c5.inscribirAlumno(a2);
		c6.inscribirAlumno(a2);
		
		c1.imprimirInscriptosPorCreditos();
	}
}
