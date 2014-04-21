package Logica_Gioco;

public enum E_Tipo_Terreno 
{
	Bosco("B", 1), Collina("C", 2), Deserto("D", 3), Lago("L", 4), Montagna("M", 5), Pianura("P", 6), Sheepsburg("S", 7);
	
	private String at_abbreviazione;
	private Integer at_tipo_numerico_terreno;
	
	private E_Tipo_Terreno(String Abbreviazione, Integer Tipo_Terreno)
	{
		this.at_abbreviazione = Abbreviazione;
		this.at_tipo_numerico_terreno = Tipo_Terreno;
	}
	
	public String get_Abbreviazione()
	{
		return this.at_abbreviazione;
	}
	
	public Integer get_Tipo_Numerico_Terreno()
	{
		return this.at_tipo_numerico_terreno;
	}
	
}
