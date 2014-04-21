package Logica_Gioco;

import java.util.ArrayList;

public class Strada 
{
	
	/*
	 * Codice ID: ZTxTyNs
	 * 
	 * Z:
	 * Tx: Tipo numerico di uno dei 2 terreni adiacenti
	 * Ty: Tipo numerico dell'altro dei 2 terreni adiacenti
	 * 
	 * Ns: Numero strada, compreso tra 1-6
	 * 
	 * (primo in alto sinistra nella mappa di gioco)
	 * 	Z622
	 * 
	 */
	private Integer at_ID;
	private Regione[] at_regioni_limitrofe;
	private ArrayList<Strada> at_strade_collegate;
	private I_Occupante at_occupante;
	
	//Eccezioni
	/**
	 * 
	 * @author Mirko
	 * @exception thown when a street is enroached by a Recinto object
	 *
	 */
	public class Occupata_Da_Recinto_Exception extends Exception 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Occupata_Da_Recinto_Exception() {super();}
		public Occupata_Da_Recinto_Exception(String s) {super(s);}
	}
	/**
	 * 
	 * @author Mirko
	 * @exception thown when a street is enroached by a Pedina_Pastore object while you trying to put another Pedina_Pastore on that street
	 *
	 */
	public class Occupata_Da_Pastore_Exception extends Exception 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Occupata_Da_Pastore_Exception() {super();}
		public Occupata_Da_Pastore_Exception(String s) {super(s);}
	}
	
	
	
	/**
	 * 
	 * @param ID
	 * @param Regioni_Limitrofe
	 */
	public Strada (Integer ID, Regione[] Regioni_Limitrofe)
	{
		at_ID = ID;
		at_regioni_limitrofe = Regioni_Limitrofe.clone();
		at_occupante=null;
	}
	
	/**
	 * 
	 * @param ID
	 * @param Regioni_Limitrofe
	 * @param Strade_Collegate
	 */
	@SuppressWarnings("unchecked")
	public Strada (Integer ID, Regione[] Regioni_Limitrofe, ArrayList<Strada> Strade_Collegate)
	{
		at_ID = ID;
		at_regioni_limitrofe = Regioni_Limitrofe.clone();
		at_strade_collegate = (ArrayList<Strada>)Strade_Collegate.clone();
		at_occupante=null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer get_ID ()
	{
		return at_ID;
	}
	
	/**
	 * 
	 * @return
	 */
	public Regione[] Regioni_Limitrofe ()
	{
		return at_regioni_limitrofe.clone();
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Strada> get_Strade_Collegate()
	{
		return (ArrayList<Strada>)at_strade_collegate.clone();
	}
	
	/**
	 * 
	 * @param Strade_Collegate
	 */
	@SuppressWarnings("unchecked")
	public void set_Strade_Collegate(ArrayList<Strada> Strade_Collegate)
	{
		at_strade_collegate = (ArrayList<Strada>)Strade_Collegate.clone();
	}
	
	/**
	 * @return return the at_occupante attribute
	 */
	public I_Occupante get_Occupante() {
		return at_occupante;
	}

	/**
	 * @param at_occupante is the I_Occupante object that encroaches a street
	 */
	public void set_Occupante(I_Occupante at_occupante) throws Occupata_Da_Recinto_Exception, Occupata_Da_Pastore_Exception
	{
		if(this.at_occupante instanceof Pedina_Recinto)
			throw new Occupata_Da_Recinto_Exception("Qui c'e' un recinto! Non puoi occuparlo con altri oggetti!");
		else if(this.at_occupante instanceof Pedina_Pastore && at_occupante instanceof Pedina_Pastore)
			throw new Occupata_Da_Pastore_Exception("Stai tentando di posizionare un pastore sopra un altro pastore!");
		this.at_occupante = at_occupante;
	}
	
	
	@Override
	public String toString()
	{
		String wv_ritorno = "ID: ";
		wv_ritorno += at_ID;
		wv_ritorno += "\nRegioni Limitrofe:\n";
		
		
		if(at_regioni_limitrofe!=null)
		{
			for (Regione item : at_regioni_limitrofe)
			{
				wv_ritorno += (item.toString() + "|");
			}
		}
		else 
		{
			wv_ritorno+="Nessuna";
		}
		
		wv_ritorno += "\nStrade collegate:\n";
		
		if(at_strade_collegate != null)
		{
			for (Strada item : at_strade_collegate)
			{
				wv_ritorno += item.get_ID();
			}
		}
		else 
		{
			wv_ritorno+="Nessuna";
		}
		
		return wv_ritorno;
	}
}
