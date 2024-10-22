package com.magazzino.Entity;

import java.util.Date;

import com.magazzino.Database.ReportDAO;
import com.magazzino.Exception.*;

public class EntityReport {
	private int idReport;
	private Date data;
	private int numPrenotazione;
	private String nomeCliente;
	private String cognomeCliente;
	private String emailCliente;
	private String telefonoCliente;
	
	public EntityReport(int _id) {
		super();
		this.idReport = _id;
	}
	
	public EntityReport(int idReport, Date data, int numPrenotazione, String nomeCliente, 
			String cognomeCliente, String emailCliente, String telefonoCliente) {
		super();
		this.idReport = idReport;
		this.data = data;
		this.numPrenotazione = numPrenotazione;
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.emailCliente = emailCliente;
		this.telefonoCliente = telefonoCliente;
	}
	
	public int getIdReport() { return idReport; }
	public void setIdReport(int idReport) { this.idReport = idReport; }
	
	public Date getData() { return data; }
	public void setData(Date data) { this.data = data; }
	
	public int getNumPrenotazione() { return numPrenotazione; }
	public void setNumPrenotazione(int numPrenotazione) { this.numPrenotazione = numPrenotazione; }
	
	public String getNomeCliente() { return nomeCliente; }
	public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
	
	public String getCognomeCliente() { return cognomeCliente; }
	public void setCognomeCliente(String cognomeCliente) { this.cognomeCliente = cognomeCliente; }
	
	public String getEmailCliente() { return emailCliente; }
	public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }
	
	public String getTelefonoCliente() { return telefonoCliente; }
	public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }

	public void saveReport() throws DAOException, DBConnectionException {
		
		ReportDAO.createReport();
		
	}
	
}
