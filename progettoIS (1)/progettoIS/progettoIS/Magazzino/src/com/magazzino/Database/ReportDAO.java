package com.magazzino.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.magazzino.Exception.*;

public class ReportDAO {
	
	public static void createReport() throws DAOException, DBConnectionException {
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query = "INSERT INTO REPORT (NUM_PRENOTAZIONE, NOME_CLIENTE, COGNOME_CLIENTE, EMAIL_CLIENTE, TELEFONO_CLIENTE) "
					+ "SELECT P.NUM_PRENOTAZIONE, C.NOME, C.COGNOME, C.EMAIL, C.TELEFONO FROM CLIENTE C JOIN PRENOTAZIONE P ON "
					+ "P.ID_CLIENTE = C.ID_CLIENTE WHERE P.DATA = CURRENT_DATE AND P.ANDAMENTO = 'CONSEGNATO' AND P.ESITO = "
					+ "'CONFERMATO';";

			try {
				
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.executeUpdate();

			}catch(SQLException e) {
				throw new DAOException("Errore create report");
			} finally {
				DBManager.closeConnection();
			}

		}catch(SQLException e) {
			throw new DBConnectionException("Errore connessione database");
		}
		
	}

}
