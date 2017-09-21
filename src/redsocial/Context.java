package redsocial;

public class Context {
	private final static Context instance = new Context();
	
	public static Context getInstance()
	{
		return instance;
	}
	
	private RedSocialHinchada redSocial;
	private Fanatico fanaticoSeleccionado;
	
	public RedSocialHinchada getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(RedSocialHinchada redSocial) {
		this.redSocial = redSocial;
	}

	public Fanatico getFanaticoSeleccionado() {
		return fanaticoSeleccionado;
	}

	public void setFanaticoSeleccionado(Fanatico fanaticoSeleccionado) {
		this.fanaticoSeleccionado = fanaticoSeleccionado;
	}
	
}
