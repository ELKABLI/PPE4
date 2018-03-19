package maquettes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.mysql.jdbc.Statement;


public class Connect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 try {

		      Class.forName("org.postgresql.Driver");

		      System.out.println("Driver O.K.");
		      String url = "jdbc:postgresql://localhost:5432/Ecole";
		      String user = "postgres";
		      String passwd = "ali";

		      Connection conn = DriverManager.getConnection(url, user, passwd);

		      System.out.println("Connexion effective !");         
		      //afficher dans la bdd Ecole, dans la table classe, les colonnes cls_ID et CLS_NOM
		      // 1) Création d'un objet Statement
		      java.sql.Statement state = conn.createStatement();
		      // 2) L'objet ResultSet contient le résultat de la requête SQL
		      ResultSet result = state.executeQuery("SELECT * FROM classe");
		      // 3) On récupère les MetaData
		      ResultSetMetaData resultMeta = result.getMetaData();
		         
		      System.out.println("\n**********************************");
		      //On affiche le nom des colonnes
		      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t ");
		         
		      System.out.println("\n**********************************");
		         
		      while(result.next()){         
		        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		          System.out.print("\t" + result.getObject(i).toString() + "\t |");
		            
		        System.out.println("\n---------------------------------");

		      }

		      result.close();
		      state.close();
	         

		    } catch (Exception e) {

		      e.printStackTrace();

		    }      

		  }

}
