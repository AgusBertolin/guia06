package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditosRequeridos = 0;
	}
	

	public void inscribirAlumno(Alumno a){
		try {
			this.inscribir(a);
		}
		catch (CreditosInsuficientes e){
			System.out.println(e.getMessage());
		}
		catch (CupoCubierto e){
			System.out.println(e.getMessage());
		}
		catch (CursoCompleto e) {
			System.out.println(e.getMessage());
		}
		catch (RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 * @throws IOException 
	 */
	public void inscribir(Alumno a) throws RegistroAuditoriaException, CreditosInsuficientes, CupoCubierto, CursoCompleto {
		if(a.creditosObtenidos() >= this.creditosRequeridos && this.inscriptos != null && this.inscriptos.size() < this.cupo && !this.inscriptos.contains(a) && (a.getCursando() == null || a.getCursando().size() < 3)) {
			this.inscriptos.add(a);
			a.inscripcionAceptada(this);
			try{
				log.registrar(this, "inscribir ",a.toString());
			}
			catch (IOException e) {
				throw new RegistroAuditoriaException("Exception thrown  :" + e);
			}
		}
		else {
			if(a.creditosObtenidos() < this.creditosRequeridos) {
				throw new CreditosInsuficientes("Creditos insuficientes");
			}
			if(this.inscriptos != null && this.inscriptos.size() >= this.cupo) {
				throw new CupoCubierto("Curso completo");
			}
			if(a.getCursando() != null && a.getCursando().size() == 3) {
				throw new CursoCompleto("El alumno ya tiene todas las materias de cursado regular");
			}
		}
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptosPorNombre() {
		if(this.inscriptos != null) {
			Collections.sort(this.inscriptos, new SortByNombre());
			System.out.println(this.inscriptos);
			try {
				log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception thrown  :" + e);
			}
		}
	}

	public void imprimirInscriptosPorNroLibreta() {
		Collections.sort(this.inscriptos, new SortByLibreta());
		System.out.println(this.inscriptos);
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception thrown  :" + e);
		}
	}
	
	public void imprimirInscriptosPorCreditos() {
		Collections.sort(this.inscriptos, new SortByCreditos());
		Collections.reverse(this.inscriptos);
		System.out.println(this.inscriptos);
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception thrown  :" + e);
		}
	}
	
	public void eliminarAlumno(Alumno a) {
		this.inscriptos.remove(a);
	}
	
	public Integer getCreditos() {
		return this.creditos;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public List<Alumno> getInscriptos() {
		return this.inscriptos;
	}
}
