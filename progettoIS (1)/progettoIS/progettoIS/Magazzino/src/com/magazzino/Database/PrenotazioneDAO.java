package com.magazzino.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.magazzino.Entity.EntityPrenotazione;
import com.magazzino.Exception.*;

public class PrenotazioneDAO {
	
	public static int createPrenotazione(EntityPrenotazione eP) throws DAOException, DBConnectionException {
		
		int numPrenotazione = -1;
		
		try {
		
			Connection conn = DBManager.getConnection();
			String query = "INSERT INTO PRENOTAZIONE (ID_CLIENTE) VALUES (?);";

			try {

				PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, eP.getIdCliente());
				stmt.executeUpdate();
				ResultSet result = stmt.getGeneratedKeys();
				if (result.next()) {
					numPrenotazione = result.getInt(1);
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
		
		return numPrenotazione;
		
	}

	public static EntityPrenotazione readPrenotazione(int numPrenotazione) throws DAOException, DBConnectionException {
		
		EntityPrenotazione eP = null;
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "SELECT * FROM PRENOTAZIONE WHERE NUM_PRENOTAZIONE = ?;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, numPrenotazione);
				ResultSet result = stmt.executeQuery();
				if(result.next()) {
					eP = new EntityPrenotazione(result.getInt(1), result.getDate(2), result.getString(3), result.getBoolean(4), 
							result.getString(5), result.getInt(6));	
				}
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore read prenotazione");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
		return eP;
		
	}

	public static void updatePrenotazioneEsito(int numPrenotazione, String esito) throws DAOException, DBConnectionException {
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "UPDATE PRENOTAZIONE SET ESITO = ? WHERE NUM_PRENOTAZIONE = ?;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, esito);
				stmt.setInt(2, numPrenotazione);
				stmt.executeUpdate();
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore update esito prenotazione");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
	}
	
	public static void updatePrenotazioneAndamento(int numPrenotazione, String andamento) throws DAOException, DBConnectionException {
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "UPDATE PRENOTAZIONE SET ANDAMENTO = ? WHERE NUM_PRENOTAZIONE = ?;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, andamento);
				stmt.setInt(2, numPrenotazione);
				stmt.executeUpdate();
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore update andamento in prenotazione");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
	}

	public static ArrayList<Integer> readAttrezzatureInPrenotazione(int numPrenotazione) throws DAOException, DBConnectionException {
		
		ArrayList<Integer> attrezzatureInPrenotazione = new ArrayList<Integer>();
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "SELECT ID_ATTREZZATURA FROM ASSOCIAZIONE WHERE NUM_PRENOTAZIONE = ?;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, numPrenotazione);
				ResultSet result = stmt.executeQuery();
				while(result.next()) {
					attrezzatureInPrenotazione.add(result.getInt(1));
				}
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore read attrezzature in prenotazione");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
		return attrezzatureInPrenotazione;
		
	}
	
	public static void updatePrenotazioneAssociazione(int numPrenotazione, ArrayList<Integer> idAttrezzaure) throws DAOException, DBConnectionException {
		
		try {

			Connection conn = DBManager.getConnection();
			String query = "INSERT INTO ASSOCIAZIONE (NUM_PRENOTAZIONE, ID_ATTREZZATURA) VALUES (?,?);";

			try {
				
				for(int i = 0; i < idAttrezzaure.size(); i++) {
					PreparedStatement stmt = conn.prepareStatement(query);
					stmt.setInt(1, numPrenotazione);
					stmt.setInt(2, idAttrezzaure.get(i));
					stmt.executeUpdate();
				}
				DBManager.closeConnection();

			}catch(SQLException e) {
				throw new DAOException("Errore create prenotazione");
			} finally {
				DBManager.closeConnection();
			}

		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
	}	

	public static int readUltimaPrenotazione() throws DAOException, DBConnectionException {
		
		int numPrenotazione = 0;
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "SELECT NUM_PRENOTAZIONE FROM PRENOTAZIONE;";
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet result = stmt.executeQuery();
				if(result.next()) {
					numPrenotazione = result.getInt(1);
				}
				DBManager.closeConnection();
				
			}catch(SQLException e) {
				throw new DAOException("Errore read prenotazione");
			} finally {
				DBManager.closeConnection();
			}
		
		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
		return numPrenotazione;
		
	}
	
}
