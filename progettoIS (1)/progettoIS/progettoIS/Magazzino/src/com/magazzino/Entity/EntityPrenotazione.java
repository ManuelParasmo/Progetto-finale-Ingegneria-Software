package com.magazzino.Entity;

import java.util.Date;
import java.util.ArrayList;

import com.magazzino.Database.PrenotazioneDAO;
import com.magazzino.Exception.*;

public class EntityPrenotazione {
	private int numPrenotazione;
	private Date data;
	private String esito;
	private boolean pagato;
	private String andamento;
	private int idCliente;

	
	public EntityPrenotazione(int numPrenotazione, Date data, String esito, boolean pagato,
			String andamento, int idCliente) {
		super();
		this.numPrenotazione = numPrenotazione;
		this.data = data;
		this.esito = esito;
		this.pagato = pagato;
		this.andamento = andamento;
		this.idCliente = idCliente;
	}
	
	public int getNumPrenotazione() { return numPrenotazione; }
	public void setNumPrenotazione(int numPrenotazione) { this.numPrenotazione = numPrenotazione; }
	
	public Date getData() { return data; }
	public void setData(Date data) { this.data = data; }
	
	public String getEsito() { return esito; }
	public void setEsito(String esito) { this.esito = esito; }
	
	public boolean getPagato() { return pagato; }
	public void setPagato(boolean pagato) { this.pagato = pagato; }
	
	public String getAndamento() { return andamento; }
	public void setAndamento(String andamento) { this.andamento = andamento; }
	
	public int getIdCliente() { return idCliente; }
	public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
	
	public boolean savePrenotazione(ArrayList<Integer> idAttrezzature) throws DAOException, DBConnectionException {
		
		boolean success = false;
		int numPrenotazione = PrenotazioneDAO.createPrenotazione(this);
		if(numPrenotazione > 0) {
			success = true;
		}
		PrenotazioneDAO.updatePrenotazioneAssociazione(numPrenotazione, idAttrezzature);
		return success;
	}
	
}
