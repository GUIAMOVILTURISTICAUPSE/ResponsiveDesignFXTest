package redsocial;

public class CriterioBusquedaPorAntecedentes implements Criterio {

	@Override
	public boolean verificar(Fanatico f) {
		return f.isAntecedentes();
	}
	
	@Override
	public String toString() {
		return "Criterio Busqueda Por Antecedentes []";
	}

}
