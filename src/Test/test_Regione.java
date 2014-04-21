package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Logica_Gioco.E_Tipo_Terreno;
import Logica_Gioco.Regione;

public class test_Regione {

	@Test
	public void test_Costruttore() {
		Regione regione = new Regione(E_Tipo_Terreno.Bosco, 2);
		assertEquals(regione.Get_Tipo_Terreno(),"B");
	}
	
	//#TODO #JUNIT finire i test case di Regione
}
