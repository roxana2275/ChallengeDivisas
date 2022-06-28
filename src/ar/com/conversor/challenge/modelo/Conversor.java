package ar.com.conversor.challenge.modelo;

import java.util.ArrayList;

public class Conversor {

	private String nombre;
	private String unidadBase;
	private ArrayList<TipoDeconversion> listaUnidades;

	public Conversor(String nombre, Unidad[] lista, String unidadBase) {

		ArrayList<TipoDeconversion> listaConversiones = new ArrayList<>();

		for (Unidad unidad : lista) {
			listaConversiones.add(new TipoDeconversion(unidad,"De " + unidadBase + " a " + unidad.getNombre(), 1));
		}

		for (Unidad unidad : lista) {
			listaConversiones.add(new TipoDeconversion(unidad,"De " + unidad.getNombre() + " a " + unidadBase, -1));
		}

		this.listaUnidades = listaConversiones;
		this.nombre = nombre;
		this.unidadBase = unidadBase;
	}
	
	
	public float convertir(String unidadDeCambio, float monto) {

		for (TipoDeconversion conversion : this.listaUnidades) {
			if (conversion.getTipoDeconversion() == unidadDeCambio) {
				return (float) conversion.convertir(monto);
			}
		}

		return 0;

	}
 
	public String[] getListaConversiones() {
 
		ArrayList<String> nombres = new ArrayList<String>();
		for (TipoDeconversion m : this.listaUnidades) {
			nombres.add(m.getTipoDeconversion());
		}
 
		String[] s = new String[nombres.size()];
		return s = nombres.toArray(s);
	}

	public String getNombre() {
		return this.nombre;
	}
	
	
	public String getNombreMoneda (String tipoDeCambio) {
		
		String retorno = "";
		for(TipoDeconversion conversion: listaUnidades) {
			if(conversion.getTipoDeconversion() == tipoDeCambio)
				if(conversion.getDireccion() < 1) {
					retorno = this.unidadBase;
				}else {
					retorno = conversion.getNombreUnidad();
				}
		}
		
		return retorno;
	}

}
