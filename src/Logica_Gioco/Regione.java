package Logica_Gioco;

import java.util.ArrayList;

import javax.lang.model.element.VariableElement;

import org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.NON_EXISTENT;

public class Regione 
{
	private final Integer at_ID;
	private E_Tipo_Terreno at_tipo;
	private ArrayList<Animale> at_lista_animali;
	
	//Eccezioni
	public class Lista_Animali_Null extends Exception
	{
		public Lista_Animali_Null(){super();}
		public Lista_Animali_Null(String s){super(s);}
		
	}
	
	/**
	 * thrown if the Animale object is not found
	 * 
	 * @author Mirko
	 *
	 */
	public class Animale_Non_Trovato extends Exception
	{
		public Animale_Non_Trovato(){super();}
		public Animale_Non_Trovato(String s){super(s);}
		
	}
	
	//#TODO #JAVADOC finire la documentazione
	public Regione(E_Tipo_Terreno tipo, Integer ID)
	{
		this.at_tipo=tipo;
		this.at_ID=ID;
	}
	public Regione(E_Tipo_Terreno tipo, ArrayList<Animale> Lista_Pecore, Integer ID)
	{
		this.at_tipo=tipo;
		this.at_lista_animali = Lista_Pecore;
		this.at_ID = ID;
	}
	
	/**
	 * Get Regione's land type
	 * 
	 * @author Mirko
	 * @return an abbrevetion of the Regione's type
	 */
	public String Get_Tipo_Terreno()
	{
		return this.at_tipo.get_Abbreviazione();
	}
	
	/**
	 * This method allow you to add an Animals object to the private ArrayList
	 * which contains all the animals in that Region
	 * 
	 * @param Animale The Animal you want to add
	 */
	public void Aggiungi_Animale(Animale Animale)
	{
		if(at_lista_animali == null)
		{
			at_lista_animali = new ArrayList<Animale>();
		}
		at_lista_animali.add(Animale);
	}
	
	/**
	 * This method allow to <bold>remove</bold> an Animale object from the ArrayList at_lista_animale
	 * which contains all the animal that belong to that Regione
	 * 
	 * @author Mirko
	 * @param Animale the Object that you want to remove
	 * @throws Lista_Animali_Null Thrown if the ArrayList is null, Animale non trovato if the object isn't present
	 */
	public void Rimuovi_Animale(Animale Animale) throws Lista_Animali_Null, Animale_Non_Trovato
	{
		if(at_lista_animali == null)
		{
			throw new Lista_Animali_Null("Non puoi rimuovere elementi da una lista non instanziata");
		}
		Boolean wv_rimosso = at_lista_animali.remove(Animale);
		if(!wv_rimosso)
			throw new Animale_Non_Trovato("Animale passato per oggetto non trovato");
	}
	
	/**
	 * This method allow to <bold>remove</bold> an Animale object from the ArrayList at_lista_animale
	 * which contains all the animal that belong to that Regione
	 * 
	 * @author Mirko
	 * @param ID the Animale's ID of the object that you want to remove
	 * @throws Lista_Animali_Null Thrown if the ArrayList is null, Animale non trovato if the ID isn't present
	 */
	public void Rimuovi_Animale(Integer ID) throws Lista_Animali_Null, Animale_Non_Trovato
	{
		if(at_lista_animali == null)
		{
			throw new Lista_Animali_Null("Non puoi rimuovere elementi da una lista non instanziata");
		}
		Integer index = Trova_Occorrenza(ID);
		if(index==-1)
			throw new Animale_Non_Trovato("ID animale non trovato");
		at_lista_animali.remove(index);
	}
	
	
	/**
	 * Get the index of the object that match id param
	 * 
	 * @author Mirko
	 * @param id
	 * @return a positive index if the object was found, -1 if not found
	 */
	private Integer Trova_Occorrenza(Integer id) {
		for(int i=0; i<at_lista_animali.size();i++)
		{
			if(at_lista_animali.get(i).Get_ID().equals(id))
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Get how many animals are present in Regione,
	 * Lupo is ignored
	 * 
	 * @author Mirko
	 * @return How many Animals
	 */
	public int  Get_Numero_Pecore()
	{
		Integer wv_count=0;
		for (Animale item : at_lista_animali) {
			if(item instanceof Lupo)
				continue;
			else 
				wv_count++;
		}
		return wv_count;
	}
	
	/**
	 * Return true if the region in enroached by at least one Pecora, false otherwise
	 * 
	 * @author Mirko
	 * @return true or false
	 */
	public Boolean Occupata_Da_Pecore()
	{
		for (Animale item : at_lista_animali) {
			if(item instanceof Pecora)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return at_tipo.toString();
	}
}
