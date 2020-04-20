package died.guia06;

import java.util.Comparator;

public class SortByNombre implements Comparator<Alumno>{
	
	@Override
    public int compare(Alumno a, Alumno b) {
        return a.getNombre().compareTo(b.getNombre());
    }
	
}
