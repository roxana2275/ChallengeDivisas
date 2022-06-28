package ar.com.conversor.challenge.main;

import javax.swing.JOptionPane;
import ar.com.conversor.challenge.modelo.Conversor;
import ar.com.conversor.challenge.modelo.ListaDeConversores;
import ar.com.conversor.challenge.modelo.Unidad;
import ar.com.conversor.challenge.modelo.UnidadTemperaturaFarenheit;
import ar.com.conversor.challenge.modelo.UnidadTemperaturaKelvin;

public class MainConversor {
	public static void main(String[] args) {

		
		Unidad[] monedasPesosUnidadesConversion = { new Unidad("Dolares", 124.30), new Unidad("Euros", 131.19),
				new Unidad("Libra Esterlina", 152.47), new Unidad("Reales", 23.70) };
		Conversor conversorMonedasPesos = new Conversor("Moneda / Pesos Argentinos", monedasPesosUnidadesConversion,
				"Pesos Argentinos");
		
		
		Unidad[] monedasDolaresUnidadesConversion = { new Unidad("Pesos Argentinos", 0.0084), new Unidad("Euros", 0.95),
				new Unidad("Libra Esterlina", 0.82), new Unidad("Reales", 0.39) };
		Conversor conversorMonedasDolares = new Conversor("Moneda / Dolares Estadounidenses", monedasDolaresUnidadesConversion,
				"Dolares Estadounidenses");
		
		
		Unidad[] medidasUnidadesConversion = { new Unidad("Milla", 1609.34), new Unidad("Yarda", 0.9144),
		new Unidad("Pie", 0.3048), new Unidad("Pulgada", 0.0254), new Unidad("Milla N�utica", 1852) };
		new Conversor("Medida", medidasUnidadesConversion, "Metro");

		new UnidadTemperaturaFarenheit();
		new UnidadTemperaturaKelvin();
		
		Conversor[] conversores = { conversorMonedasPesos, conversorMonedasDolares};
		ListaDeConversores listaDeConversores = new ListaDeConversores(conversores);

		
		
		
		boolean finDeEjecucion = false;

		
		
		do {

			boolean menuPrincipal = false;
			
			String conversorElegido = "";

			try {
				conversorElegido = JOptionPane.showInputDialog(null, "Que conversor quiere utilizar?",
						"Tipo de Conversiones", JOptionPane.QUESTION_MESSAGE, null,
						listaDeConversores.getListaConversores(), "opcion 1").toString();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Se cerro el programa");
				break;

			}
			
			
			Conversor conversor = listaDeConversores.getConversor(conversorElegido);
			
			
			
			String stringConversion="";
			
			
			if(!menuPrincipal) try {

				stringConversion = JOptionPane.showInputDialog(null, "Que conversi�n desea realizar?",
						conversor.getNombre(), JOptionPane.QUESTION_MESSAGE, null, // null para icono defecto
						conversor.getListaConversiones(), "opcion 1").toString();
				
			}catch (NullPointerException e) {
				menuPrincipal = true;
			}
			
			
			String valorIngresado= "";
			
			
			float valorIngresadoFloat=0;
			
			
			if(!menuPrincipal) try {
				String error="";
				do {
					try {
						valorIngresado = JOptionPane.showInputDialog("Ingrese valor a convertira " + stringConversion + ":");
						valorIngresadoFloat = Float.parseFloat(valorIngresado);
						error = "";
					}catch(NumberFormatException e) {
						error = e.toString();
						JOptionPane.showMessageDialog(null, "Debe ingresar un numero v�lido! ");
					}
				}while(error != "");
				
				
			}catch(NullPointerException e) {
				menuPrincipal = true;
			}
			
			if(!menuPrincipal) JOptionPane.showMessageDialog(null,"Resultado en " + conversor.getNombreMoneda(stringConversion) + " es: "
					+ conversor.convertir(stringConversion, valorIngresadoFloat),
					stringConversion, JOptionPane.INFORMATION_MESSAGE, null);
	 
			int opcion = 0;
			if (!menuPrincipal) opcion = JOptionPane.showConfirmDialog(null, "¿Quiere continuar?");
			 
			if(opcion == 1 || opcion == 2) {
				JOptionPane.showMessageDialog(null, "Programa cerrado");
				break;
			}
			
			
		} while (!finDeEjecucion);

	}
}
