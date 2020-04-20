package died.guia06;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno() {
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public int creditosObtenidos() {
		int aux = 0;
		if(this.aprobados != null) {
			for(Curso c: this.aprobados) {
				aux += (int) c.getCreditos();
			}
		}
		return aux;
	}

	public void aprobar(Curso c) {
		if(this.cursando != null && this.cursando.contains(c)) {
			this.cursando.remove(c);
			this.aprobados.add(c);
		}
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	public boolean equals(Alumno a) {
		return (this.nroLibreta == a.getLibreta());
	}
	
	@Override
	public String toString() {
		String aux = this.nombre;
		aux = aux.concat(" " + String.valueOf(this.nroLibreta));
		return aux;
 
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getLibreta() {
		return this.nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

}
