package Logica_Gioco;

import java.util.ArrayList;

public class Giocatore
{
	private String at_nome;
	private Integer at_numero_giocatore;
	private Integer at_danaro_residuo;
	private Integer at_punteggio;
	private E_Tipo_Terreno at_tessera_terreno_iniziale;
	/*
	 * Dato che ogni giocatore può possedere più di una tessera per tipo terreno,
	 * questa possibilità comparirà come un elemento in più nella lista
	 */
	private ArrayList<E_Tipo_Terreno> at_tessere_terreno_possedute;
	
	private final Pedina_Pastore[] at_pedina;
	
	
	public class Spesa_Eccessiva_Exception extends Exception
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Spesa_Eccessiva_Exception ()
		{
			super("Spesa oltre i limiti concessi! Il conto non può scendere sotto zero");
		}
	}
	
	public class Rimozione_Tessera_Exception extends Exception
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public Rimozione_Tessera_Exception (String Messaggio)
		{
			super(Messaggio);
		}
		
	}
	
	
	public Giocatore(String Nome, Integer Numero, Integer Danaro_Iniziale, Pedina_Pastore[] _Pedina_Pastore,
			E_Tipo_Terreno Tessera_Terreno_Iniziale)
	{
		this.at_nome = Nome;
		this.at_numero_giocatore = Numero;
		this.at_danaro_residuo = Danaro_Iniziale;
		this.at_punteggio = 0;
		this.at_tessere_terreno_possedute = null;
		this.at_pedina = _Pedina_Pastore.clone();
		this.at_tessera_terreno_iniziale = Tessera_Terreno_Iniziale;
	}
	
	public String get_Nome()
	{
		return this.at_nome;
	}
	
	public Integer get_Numero_Giocatore()
	{
		return this.at_numero_giocatore;
	}
	
	public Integer get_Danaro_Residuo()
	{
		return this.at_danaro_residuo;
	}
	
	public Integer get_Punteggio()
	{
		return this.at_punteggio;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<E_Tipo_Terreno> get_Terreni_Comprati()
	{
		return (ArrayList<E_Tipo_Terreno>)at_tessere_terreno_possedute.clone();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<E_Tipo_Terreno> get_Tipo_Terreni_Posseduti()
	{
		ArrayList<E_Tipo_Terreno> wv_Lista_Tessere = new ArrayList<>();
		wv_Lista_Tessere.add(this.at_tessera_terreno_iniziale);
		if(this.at_tessere_terreno_possedute != null)
		{
			wv_Lista_Tessere.addAll(at_tessere_terreno_possedute);
		}
		
		return (ArrayList<E_Tipo_Terreno>)wv_Lista_Tessere.clone();
	}
	
	public Pedina_Pastore[] get_Pedina_Pastore()
	{
		return this.at_pedina;
	}
	
	public void set_Punteggo (Integer Punteggio)
	{
		this.at_punteggio = Punteggio;
	}
	public void Spendi_Danaro(Integer Spesa) throws Spesa_Eccessiva_Exception
	{
		if((this.at_danaro_residuo - Spesa)<0)
			throw new Spesa_Eccessiva_Exception();
		
		this.at_danaro_residuo-=Spesa;
	}
	
	public void Aggiungi_Tessera_Terreno(E_Tipo_Terreno Tipo_Terreno)
	{
		if(this.at_tessere_terreno_possedute==null)
		{
			this.at_tessere_terreno_possedute = new ArrayList<E_Tipo_Terreno>();
		}
		
		this.at_tessere_terreno_possedute.add(Tipo_Terreno);
	}
	public void Rimuovi_Tessera_Terreno(E_Tipo_Terreno tipo_Terreno) throws Rimozione_Tessera_Exception
	{
		if(this.at_tessere_terreno_possedute==null)
		{
			throw new Rimozione_Tessera_Exception("Non è presente alcuna tessera");
		}
		
		if(!this.at_tessere_terreno_possedute.contains(tipo_Terreno))
		{
			throw new Rimozione_Tessera_Exception("Tessera/Tipo Terreno non posseduta/o dal giocatore: " +
					this.toString());
		}
		
		this.at_tessere_terreno_possedute.remove(tipo_Terreno);
	}
	
	
	@Override
	public String toString()
	{
		return "Nome: " + this.at_nome + " Numero: " + this.at_numero_giocatore;
	}
}
