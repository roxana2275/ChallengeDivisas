package ar.com.conversor.challenge.modelo;

import java.util.ArrayList;

public class ListaDeConversores {
	
	private ArrayList<Conversor> lista ;
	
	
	
	public ListaDeConversores(Conversor[] lista) {
		this.lista = new ArrayList<>();
		for(Conversor conversor:lista) {
			this.lista.add(conversor);
		}


	}
	
	
	public String[] getListaConversores() {
 
		ArrayList<String> nombres = new ArrayList<String>();
		for (Conversor m : this.lista) {
			nombres.add(m.getNombre());
		}
 
		String[] s = new String[nombres.size()];
		return s = nombres.toArray(s);
	}
	
	public Conversor getConversor(String nombre) {
		
		Conversor retornoConversor = null;
		
		for(Conversor conversor:this.lista) {
			
			if(nombre == conversor.getNombre()) {
				retornoConversor = conversor;
			}

		}
		
		return retornoConversor;
	}
	

}
