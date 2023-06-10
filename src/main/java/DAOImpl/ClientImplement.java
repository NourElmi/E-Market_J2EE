package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Association;
import Beans.Client;
import Beans.Client;
import DAO.ClientInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class ClientImplement implements ClientInterf{
	
	
	private DAOFactory daoFactory;

	public ClientImplement( DAOFactory daoFactory ) 
	{
		
        this.daoFactory = daoFactory;
    }
	
	private static Client map( ResultSet resultSet ) throws SQLException 
	{
		 Client client = new Client();
		 
		 	client.setIdClient(resultSet.getInt("idClient"));
			client.setNomClient(resultSet.getString("nomClient"));
			client.setPrenomClient(resultSet.getString("PrenomClient"));
			client.setLogin(resultSet.getString("login"));
			client.setPassword(resultSet.getString("password"));
			client.setNumTel(resultSet.getInt("numTel"));
			client.setAdresse(resultSet.getString("adresse"));
			client.setGenre(resultSet.getString("genre"));
			client.setDateNaissance(resultSet.getString("dateNaissance"));			
		return client;
	}
    
    public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public void insertClient(String nomAsso, String secteur, String nomRespo, String prenomRespo, String email,
			String password, String telephoneAsso, String ville, String localisation, int nbrJourRecuProd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Check_login_Client(String login, String password) {
		boolean flag=false;
		
	    final String SQL_SELECT_PAR_NOM = "SELECT idClient FROM client WHERE login=? AND password=?";
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

		try{
			/* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, login, password );
	        resultSet = preparedStatement.executeQuery();
	    	 
	         if(resultSet.next()) {
	    		flag=true; 
	         }
	         preparedStatement.close();
	         
	     }catch(SQLException e){
	         e.printStackTrace();
	     }
		return flag;
	}
	 @Override
	  public Client getClientByEmail(String login) {
		  
		  final String SQL_SELECT_By_Email = "SELECT * FROM client WHERE login=? ";
		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultSet = null;
		  Client client = null;
		    
	  	try {
	  		
	  		connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_By_Email, login );
	        resultSet = preparedStatement.executeQuery();
	  		if ( resultSet.next() ) {
	  			client = map( resultSet );
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  	return client;
	  }

	@Override
	public boolean updateClient(ClientInterf ass) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ClientInterf getClientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addClient(String nomBenefi, String prenomBenefi, String login, String password, int numTel,
			String adresse, String genre, String dateNaissance) throws DAOException {
		Connection connexion = null;
		  PreparedStatement preparedStatement= null;
		   
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement= connexion.prepareStatement("insert into client values(?,?,?,?,?,?,?,?,?);");
		        preparedStatement.setString(1, null);
		        preparedStatement.setString(2, nomBenefi);
		        preparedStatement.setString(3,prenomBenefi);
		        preparedStatement.setString(4,login);
		        preparedStatement.setString(5,password);
		        preparedStatement.setInt(6,  numTel);
		        preparedStatement.setString(7, adresse);
		        preparedStatement.setString(8, genre);
		        preparedStatement.setString(9,  dateNaissance);
//		        preparedStatement.setInt(10, idAsso_benef);
		        
//		        preparedStatement = initRequestPrepare( connexion, SQL_INSERT_INTO, CIN,nom, prenom, job, skills );
		        preparedStatement.executeUpdate();
		        
		        
		       
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
	}
	@Override
	public List<Client> getAllClient() throws DAOException {
		// TODO Auto-generated method stub
		List<Client> listallClient = new ArrayList<Client>();
	    final String SQL_SELECT_All = "select * from client;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	//ProdADonnerBean ProdADonnerBean= null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	        while(resultSet.next()) {
	        	//.next() pour aller a la ligne suivante
	        	Client client = new Client();
	        	
	        	
	        	client.setIdClient(resultSet.getInt("idClient"));
				client.setNomClient(resultSet.getString("nomClient"));
				client.setPrenomClient(resultSet.getString("PrenomClient"));
				client.setLogin(resultSet.getString("login"));
				client.setPassword(resultSet.getString("password"));
				client.setNumTel(resultSet.getInt("numTel"));
				client.setAdresse(resultSet.getString("adresse"));
				client.setGenre(resultSet.getString("genre"));
				client.setDateNaissance(resultSet.getString("dateNaissance"));
	        	
				listallClient.add(client);
			}
//	        while ( resultSet.next() ) {
//	            ProdADonnerBean = map( resultSet );
//	            listallUser.add(ProdADonnerBean);
//	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return listallClient;
	}
   
}
