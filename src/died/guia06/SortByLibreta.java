package died.guia06;

import java.util.Comparator;

public class SortByLibreta implements Comparator<Alumno>{
	
	@Override
    public int compare(Alumno a, Alumno b) {
        return a.getLibreta().compareTo(b.getLibreta());
    }
}
