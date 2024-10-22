package com.magazzino.Entity;

import com.magazzino.Database.ClienteDAO;
import com.magazzino.Exception.*;

public class EntityCliente {
	private int idCliente;
	private String nome;
	private String cognome;
	private String email;
	private String documento;
	private String telefono;
	private String residenza;
	
	public EntityCliente(int idCliente, String nome, String cognome, String email, 
			String documento, String telefono, String residenza) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.documento = documento;
		this.telefono = telefono;
		this.residenza = residenza;
	}
	
	public int getIdCliente() { return idCliente; }
	public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public String getCognome() { return cognome; }
	public void setCognome(String cognome) { this.cognome = cognome; } 
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; } 
	
	public String getDocumento() { return documento; }
	public void setDocumento(String documento) { this.documento = documento; }
	
	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }
	
	public String getResidenza() { return residenza; }
	public void setResidenza(String residenza) { this.residenza = residenza; }
	
	public int saveCliente() throws DAOException, DBConnectionException {
		
		return ClienteDAO.createCliente(this);
		
	}

}
