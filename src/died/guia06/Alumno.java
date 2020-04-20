package died.guia06;

import java.util.List;

public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public int creditosObtenidos() {
		int aux = 0;
		for(Curso c: this.aprobados) {
			aux += (int) c.getCreditos();
		}
		return aux;
	}

	public void aprobar(Curso c) {
		this.cursando.remove(c);
		this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	public boolean equals(Alumno a) {
		return (this.nroLibreta == a.getLibreta());
	}
	
	@Override
    public int compareTo(Alumno a) {
        return this.nombre.compareTo(a.getNombre());
    }
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getLibreta() {
		return this.nroLibreta;
	}
}
