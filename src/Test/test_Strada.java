package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Logica_Gioco.E_Tipo_Terreno;
import Logica_Gioco.I_Occupante;
import Logica_Gioco.Pedina_Pastore;
import Logica_Gioco.Pedina_Recinto;
import Logica_Gioco.Pedina_Recinto_Finale;
import Logica_Gioco.Regione;
import Logica_Gioco.Strada;
import Logica_Gioco.Strada.Occupata_Da_Pastore_Exception;
import Logica_Gioco.Strada.Occupata_Da_Recinto_Exception;

@SuppressWarnings("unused")
public class test_Strada {

	@Test
	public void test_toString() 
	{
		Regione[] regioniRegiones = new Regione[2];
		regioniRegiones[0]= new Regione(E_Tipo_Terreno.Deserto, 7);
		regioniRegiones[1] = new Regione(E_Tipo_Terreno.Montagna, 6);
		Strada s1 = new Strada(1722, regioniRegiones);
		
		assertNotEquals("1722",s1.toString());
	}
	
	@Test
	public void test_regioniLimitrofe()
	{
		Regione[] regioniRegiones = new Regione[2];
		regioniRegiones[0]= new Regione(E_Tipo_Terreno.Deserto,7);
		regioniRegiones[1] = new Regione(E_Tipo_Terreno.Collina,7);
		
		Strada wv_strada = new Strada(2334, regioniRegiones);
		
		assertArrayEquals(regioniRegiones, wv_strada.Regioni_Limitrofe());
	}
	
	@Test
	public void test_Posiziona_Oggetto_Corretto()
	{
		Regione[] regioniRegiones = new Regione[2];
		regioniRegiones[0]= new Regione(E_Tipo_Terreno.Deserto,7);
		regioniRegiones[1] = new Regione(E_Tipo_Terreno.Collina,7);
		I_Occupante pastore = new Pedina_Pastore();
		Strada strada = new Strada(2334, regioniRegiones);
		try 
		{
			strada.set_Occupante(pastore);
		} 
		catch (Occupata_Da_Recinto_Exception e) 
		{
			fail("Strada non occupabile da pastore!");
		} 
		catch (Occupata_Da_Pastore_Exception e) 
		{
			fail("Strada occupata gia' da un'altro pastore");
		}
	}
	
	@Test
	public void test_Posiziona_Pastore_Su_Recinto()
	{
		Boolean wv_entrato_in_catch=false;
		Regione[] regioniRegiones = new Regione[2];
		regioniRegiones[0]= new Regione(E_Tipo_Terreno.Deserto,7);
		regioniRegiones[1] = new Regione(E_Tipo_Terreno.Collina,7);
		I_Occupante pastore = new Pedina_Pastore();
		I_Occupante recinto = new Pedina_Recinto_Finale(); //Qui posso mettere un oggetto Pedina_Recinto o Pedina_Recinto_Finale (che implementa il primo)
		Strada strada = new Strada(2334, regioniRegiones);
		try 
		{
			strada.set_Occupante(recinto);
		} 
		catch (Occupata_Da_Recinto_Exception e) 
		{
			fail("Strada non occupabile da recinto!");
		} 
		catch (Occupata_Da_Pastore_Exception e) 
		{
			fail("Strada occupata gia' da un'altro pastore");
		}
		
		try 
		{
			strada.set_Occupante(pastore);
		} 
		catch (Occupata_Da_Recinto_Exception e) 
		{
			wv_entrato_in_catch=true;
		} 
		catch (Occupata_Da_Pastore_Exception e) 
		{
			fail("Strada occupata gia' da un'altro pastore");
		}
		finally
		{
			assertEquals(true, wv_entrato_in_catch);
		}
	}
	
	@Test
	public void test_Posiziona_Pastore_Su_Pastore()
	{
		Boolean wv_entrato_in_catch=false;
		Regione[] regioniRegiones = new Regione[2];
		regioniRegiones[0]= new Regione(E_Tipo_Terreno.Deserto, 7);
		regioniRegiones[1] = new Regione(E_Tipo_Terreno.Montagna, 7);
		Strada wv_s1 = new Strada(1722, regioniRegiones);
		
		I_Occupante wv_pastore1 = new Pedina_Pastore();

		I_Occupante wv_pastore2 = new Pedina_Pastore();
		
		try 
		{
			wv_s1.set_Occupante(wv_pastore1);
		} 
		catch (Occupata_Da_Recinto_Exception | Occupata_Da_Pastore_Exception e) 
		{
			fail("Errore imprevisto mentre aggiungevo su una strada senza occupanti");
		}
		
		try 
		{
			wv_s1.set_Occupante(wv_pastore2);
		} 
		catch (Occupata_Da_Recinto_Exception e) 
		{
			fail("Errore imprevisto, Occupata_Da_Recinto_Exception");
		} 
		catch (Occupata_Da_Pastore_Exception e) 
		{
			wv_entrato_in_catch=true;
		}
		finally
		{
			assertEquals(true, wv_entrato_in_catch);
		}
		
	}


}
