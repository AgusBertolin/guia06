package died.guia06;

import java.util.Comparator;

public class SortByCreditos implements Comparator<Alumno>{
	
	@Override
    public int compare(Alumno a, Alumno b) {
        return ((Integer)a.creditosObtenidos()).compareTo((Integer)b.creditosObtenidos());
    }
}
