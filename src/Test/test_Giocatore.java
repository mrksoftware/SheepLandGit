package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Logica_Gioco.E_Tipo_Terreno;
import Logica_Gioco.Giocatore;
import Logica_Gioco.Pedina_Pastore;

public class test_Giocatore 
{

	@SuppressWarnings("deprecation")
	@Test
	public void test_Costruttore ()
	{
		Pedina_Pastore[] pastori = new Pedina_Pastore[1];
		pastori[0]=new Pedina_Pastore();
		
		Giocatore wv_g1= new Giocatore("Mirko", 1, 20, pastori, E_Tipo_Terreno.Bosco);
		
		assertEquals("Nome: Mirko Numero: 1", wv_g1.toString());
		assertEquals(wv_g1.get_Pedina_Pastore(),pastori);
		assertEquals(E_Tipo_Terreno.Bosco, wv_g1.get_Tipo_Terreni_Posseduti().get(0));
	}
	
	@Test
	public void test_Aggiungi_Tessera_Terreno()
	{
		Pedina_Pastore[] pastori = new Pedina_Pastore[1];
		pastori[0]=new Pedina_Pastore();
		
		Giocatore wv_g1= new Giocatore("Mirko", 1, 20, pastori, E_Tipo_Terreno.Bosco);
		wv_g1.Aggiungi_Tessera_Terreno(E_Tipo_Terreno.Deserto);
		wv_g1.Aggiungi_Tessera_Terreno(E_Tipo_Terreno.Lago);
		
		ArrayList<E_Tipo_Terreno>terreniExpected = new ArrayList<E_Tipo_Terreno>();
		terreniExpected.add(E_Tipo_Terreno.Bosco);
		terreniExpected.add(E_Tipo_Terreno.Deserto);
		terreniExpected.add(E_Tipo_Terreno.Lago);
		
		assertEquals(wv_g1.get_Tipo_Terreni_Posseduti(), terreniExpected);
	}
	
}
