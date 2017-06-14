package DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import domaine.Boisson;

public class EnqueteBoissonDAO {

	public void sauverEnBase(Boisson maBoissonProposee) {
		
	// Information d'acc�s � la base de donn�es
			String url = "jdbc:mysql://localhost/machineacafe?useSSL=false";
			String login = "root";
			String passwd = "";
			Connection cn =null;
			PreparedStatement st =null;

			try {

				// Etape 1 : Chargement du driver
				Class.forName("com.mysql.jdbc.Driver");

				// Etape 2 : r�cup�ration de la connexion
				cn = DriverManager.getConnection(url, login, passwd);

				// Etape 3 : Cr�ation d'un statement
				String sql = "INSERT INTO `enqueteboisson` (`nom`) VALUES (?)";
				st = cn.prepareStatement(sql);
				st.setString(1, maBoissonProposee.getNom());
			
				

				// Etape 4 : ex�cution requ�te
				st.executeUpdate();

				// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
				// Etape 6 : lib�rer ressources de la m�moire.
					cn.close();
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	}
}
