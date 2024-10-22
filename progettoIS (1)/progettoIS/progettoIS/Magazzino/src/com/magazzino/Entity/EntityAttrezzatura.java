package com.magazzino.Entity;

public class EntityAttrezzatura {
	private int idAttrezzatura;
	private String categoria;
	private float prezzo;
	private String stato;
	private String lunghezza;
	private String livello;
	private String dimensione;
	private String taglia;
	private int misura;
	
	public EntityAttrezzatura(int idAttrezzatura, String categoria, float prezzo, String stato, 
			String lunghezza, String livello, String dimensione, String taglia, int misura) {
		super();
		this.idAttrezzatura = idAttrezzatura;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.stato = stato;
		this.lunghezza = lunghezza;
		this.livello = livello;
		this.dimensione = dimensione;
		this.taglia = taglia;
		this.misura = misura;
	}
	
	public int getIdAttrezzatura() { return idAttrezzatura; }
	public void setIdAttrezzatura(int idAttrezzatura) { this.idAttrezzatura = idAttrezzatura; } 
	
	public String getCategoria() { return categoria; }
	public void setCategoria(String categoria) { this.categoria = categoria; } 
	
	public float getPrezzo() { return prezzo; }
	public void setPrezzo(float prezzo) { this.prezzo = prezzo; }
	
	public String getStato() { return stato; }
	public void setStato(String stato) { this.stato = stato; }
	
	public String getLunghezza() { return lunghezza; }
	public void setLunghezza(String lunghezza) { this.lunghezza = lunghezza; }
	
	public String getLivello() { return livello; }
	public void setLivello(String livello) { this.livello = livello; }
	
	public String getDimensione() { return this.dimensione; }
	public void setDimensione(String dimensione) { this.dimensione = dimensione; }
	
	public String getTaglia() { return taglia; }
	public void setTaglia(String taglia) { this.taglia = taglia; }
     
	public int getMisura() { return misura; }
	public void setMisura(int misura) { this.misura = misura; }
}
