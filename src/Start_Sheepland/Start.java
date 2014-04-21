package Start_Sheepland;

import Logica_Gioco.E_Tipo_Terreno;
import Logica_Gioco.Regione;
import Logica_Gioco.Strada;

public class Start 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Regione[] regioniRegiones = new Regione[2];
		regioniRegiones[0]= new Regione(E_Tipo_Terreno.Pianura, 3);
		regioniRegiones[1] = new Regione(E_Tipo_Terreno.Sheepsburg, 6);
		Strada s1 = new Strada(1722, regioniRegiones);
		
		System.out.print("Sono partiro\n");
		System.out.println(s1);
	}

}
