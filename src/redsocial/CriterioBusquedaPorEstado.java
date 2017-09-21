package redsocial;

import redsocial.Fanatico.Estado;

public class CriterioBusquedaPorEstado implements Criterio {

	@Override
	public boolean verificar(Fanatico f) {
		return f.getEstado()==Estado.ACTIVO;
	}
}
