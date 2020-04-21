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
		
		c1.setCupo(30);
		c2.setCupo(3);
		c3.setCupo(10);
		c4.setCupo(2);
		
		c1.setCreditos(10);
		c2.setCreditos(6);
		c3.setCreditos(8);
		c4.setCreditos(13);
		
		c1.setCreditosRequeridos(5);
		c2.setCreditosRequeridos(0);
		c3.setCreditosRequeridos(0);
		c4.setCreditosRequeridos(14);
		
		System.out.println(c2.inscribir(a1));
		System.out.println(c2.inscribir(a2));
		System.out.println(c2.inscribir(a5));
		
		c2.imprimirInscriptosPorNombre();
		
		System.out.println(c3.inscribir(a2));
		System.out.println(c3.inscribir(a4));
		System.out.println(c3.inscribir(a3));
		
		c3.imprimirInscriptosPorNroLibreta();
		
		a2.aprobar(c2);
		a2.aprobar(c3);
		a3.aprobar(c3);
		
		System.out.println(c1.inscribir(a3));
		System.out.println(c1.inscribir(a2));
		System.out.println(c4.inscribir(a2));
		System.out.println(c1.inscribir(a1));
		System.out.println(c1.inscribir(a2));
		
		c1.imprimirInscriptosPorCreditos();
		
	}
}
