package com.magazzino.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.magazzino.Entity.EntityCliente;
import com.magazzino.Exception.*;

public class ClienteDAO {
	
	public static EntityCliente readCliente(int idCliente) throws DAOException, DBConnectionException {
		
		EntityCliente eC = null;
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = ?;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, idCliente);
				ResultSet result = stmt.executeQuery();
				if(result.next()) {
					eC = new EntityCliente(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), 
							result.getString(5), result.getString(6), result.getString(7));
				}
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore read cliente");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		} 
		
		return eC;
		
	}

	public static EntityCliente readClienteDocumento(String documento) throws DAOException, DBConnectionException {
		
		EntityCliente eC = null;
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "SELECT * FROM CLIENTE WHERE DOCUMENTO = ?;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, documento);
				ResultSet result = stmt.executeQuery();
				if(result.next()) {
					eC = new EntityCliente(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), 
							result.getString(5), result.getString(6), result.getString(7));
				}
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore read cliente");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
		return eC;
		
	}
	
	public static int createCliente(EntityCliente eC) throws DAOException, DBConnectionException {
		
		int idCliente = -1;
		
		try {
		
			Connection conn = DBManager.getConnection();
			String query = "INSERT INTO CLIENTE (NOME, COGNOME, EMAIL, DOCUMENTO, TELEFONO, RESIDENZA) VALUES (?,?,?,?,?,?);";

			try {

				PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, eC.getNome());
				stmt.setString(2, eC.getCognome());
				stmt.setString(3, eC.getEmail());
				stmt.setString(4, eC.getDocumento());
				stmt.setString(5, eC.getTelefono());
				stmt.setString(6, eC.getResidenza());
				stmt.executeUpdate();
				ResultSet result = stmt.getGeneratedKeys();
				if (result.next()) {
					idCliente = result.getInt(1);
				}
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore create cliente");
			} finally {
				DBManager.closeConnection();
			}

		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}	
		
		return idCliente;
		
	}

}
