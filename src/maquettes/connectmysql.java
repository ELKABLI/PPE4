package maquettes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.ResultSetMetaData;

public class connectmysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		 try {
		//boque de connexion
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Driver O.K.");
		      String url = "jdbc:mysql://localhost:3306/ppe";
		      String user = "root";
		      String passwd = "";
		      Connection conn = DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !"); 
		 //connexion effectif    		      	       
	   
		// Afficher dans la bdd ppe, la table client, IDClients, NomClients.
		      
		      //Création d'un objet Statement : L'objet Statement permet d'exécuter des instructions SQL, il interroge la base de données 
		      //et retourne les résultats.
		      //L'objet Statement est fourni par l'objet Connection grâce à l'instruction conn.createStatement(). Ce que j'ai fait, ensuite, 
		       //c'est demander à mon objet Statement d'exécuter une requête SQL
		      java.sql.Statement state = conn.createStatement();
		      //L'objet ResultSet contient le résultat de la requête SQL
		      ResultSet result = state.executeQuery("SELECT * FROM clients");
		      
		      while(result.next()){
		    	  System.out.print("\t" + result.getInt("IDclients") + "\t |");
		    	  System.out.print("\t" + result.getString("NomClients") + "\t |");
		    	  System.out.println("\n---------------------------------");
		    	}
		         
		     

		      result.close();
		      state.close();
		      
		 } catch (Exception e) {
		      e.printStackTrace();
		    } 
	}
	
}
