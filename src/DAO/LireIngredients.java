package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Ingr�dient;

public class LireIngredients {
	
	public Ingr�dient lireEnBase(int ID) {

		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://localhost/machineacafe?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		Ingr�dient ingredientbyID;
		String nom = "";
		boolean dispo = true;
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM ingredient where `ingreID` ='"+ ID +"'";

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);

			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

			rs.next();
			nom = rs.getString(2);
			dispo = rs.getBoolean(3);
		
			
			
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	return ingredientbyID = new Ingr�dient(nom, dispo);
	}
		
		public List<Ingr�dient> lireTous() {

			// Information d'acc�s � la base de donn�es
			String url = "jdbc:mysql://localhost/machineacafe?useSSL=false";
			String login = "root";
			String passwd = "";
			Connection cn =null;
			Statement st =null;
			ResultSet rs =null;
			Ingr�dient ingredientbyID;
			String nom = "";
			boolean dispo = true;
			List<Ingr�dient> maListe = new ArrayList<Ingr�dient>();
			
			try {

				// Etape 1 : Chargement du driver
				Class.forName("com.mysql.jdbc.Driver");

				// Etape 2 : r�cup�ration de la connexion
				cn = DriverManager.getConnection(url, login, passwd);

				// Etape 3 : Cr�ation d'un statement
				st = cn.createStatement();

				String sql = "SELECT * FROM ingredient";

				// Etape 4 : ex�cution requ�te
				rs = st.executeQuery(sql);

				// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

				while(rs.next()){
				nom = rs.getString(2);
				dispo = rs.getBoolean(3);
				Ingr�dient ingredient = new Ingr�dient(nom, dispo);
				maListe.add(ingredient);}
				
					
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
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
		return maListe;
		}
		
}
