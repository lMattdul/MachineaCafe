package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Ingrédient;

public class LireIngredients {
	
	public Ingrédient lireEnBase(int ID) {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/machineacafe?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		Ingrédient ingredientbyID;
		String nom = "";
		boolean dispo = true;
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM ingredient where `ingreID` ='"+ ID +"'";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			rs.next();
			nom = rs.getString(2);
			dispo = rs.getBoolean(3);
		
			
			
				
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return ingredientbyID = new Ingrédient(nom, dispo);
	}
		
		public List<Ingrédient> lireTous() {

			// Information d'accès à la base de données
			String url = "jdbc:mysql://localhost/machineacafe?useSSL=false";
			String login = "root";
			String passwd = "";
			Connection cn =null;
			Statement st =null;
			ResultSet rs =null;
			Ingrédient ingredientbyID;
			String nom = "";
			boolean dispo = true;
			List<Ingrédient> maListe = new ArrayList<Ingrédient>();
			
			try {

				// Etape 1 : Chargement du driver
				Class.forName("com.mysql.jdbc.Driver");

				// Etape 2 : récupération de la connexion
				cn = DriverManager.getConnection(url, login, passwd);

				// Etape 3 : Création d'un statement
				st = cn.createStatement();

				String sql = "SELECT * FROM ingredient";

				// Etape 4 : exécution requête
				rs = st.executeQuery(sql);

				// Si récup données alors étapes 5 (parcours Resultset)

				while(rs.next()){
				nom = rs.getString(2);
				dispo = rs.getBoolean(3);
				Ingrédient ingredient = new Ingrédient(nom, dispo);
				maListe.add(ingredient);}
				
					
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
				// Etape 6 : libérer ressources de la mémoire.
					cn.close();
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return maListe;
		}
		
}
