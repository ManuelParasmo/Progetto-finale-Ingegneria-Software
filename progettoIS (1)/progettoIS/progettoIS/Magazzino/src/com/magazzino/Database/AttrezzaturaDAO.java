package com.magazzino.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.magazzino.Entity.EntityAttrezzatura;
import com.magazzino.Exception.*;

public class AttrezzaturaDAO {
	
	public static EntityAttrezzatura readAttrezzatura(int idAttrezzatura) throws DAOException, DBConnectionException {
		
		EntityAttrezzatura eA = null;
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "SELECT * FROM ATTREZZATURA WHERE ID_ATTREZZATURA = ?;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, idAttrezzatura);
				ResultSet result = stmt.executeQuery();
				if(result.next()) {
					eA = new EntityAttrezzatura(result.getInt(1), result.getString(2), result.getFloat(3), result.getString(4), 
							result.getString(5), result.getString(6), result.getString(7), result.getString(8), result.getInt(9));	
				}
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore read attrezzatura");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
		return eA;
		
	}
	
	public static void updateAttrezzaturaNoleggiata(int idAttrezzatura) throws DAOException, DBConnectionException {
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "UPDATE ATTREZZATURA SET STATO = ? WHERE ID_ATTREZZATURA IN (SELECT ID_ATTREZZATURA "
					+ "FROM ASSOCIAZIONE WHERE NUM_PRENOTAZIONE = ?);";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, "NOLEGGIATO");
				stmt.setInt(2, idAttrezzatura);
				stmt.executeUpdate();
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore update attrezzatura");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
		
	}

}  
