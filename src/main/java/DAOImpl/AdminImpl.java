package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Admin;
import Beans.Beneficiaire;
import DAO.AdminInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class AdminImpl implements AdminInterf {

	private DAOFactory          daoFactory;

    public AdminImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    
    
    @Override
	public void create(Admin admin) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static Admin map( ResultSet resultSet ) throws SQLException {
		Admin admin = new Admin();
		
		 admin.setIdAdmin( resultSet.getInt("idAdmin"));
		 admin.setNomAdmin( resultSet.getString( "nomAdmin" ) );
		 admin.setPrenomAdmin( resultSet.getString( "prenomAdmin" ) );
		 admin.setLogin( resultSet.getString( "login" ) );
		 admin.setPassword( resultSet.getString( "password" ) );

		 admin.setNumTel( resultSet.getInt("numTel"));
		 admin.setAdresse( resultSet.getString( "adresse" ) );
		
		// admin.setIdAsso_benef( resultSet.getInt("idAsso_benef"));
		
		
		return admin;
		}
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public void suppAdmin(int idAdmin) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifAdmin(String nomAdmin, String prenomAdmin, String login, String password, int numTel,
			String adresse, String genre, String dateNaissance, int idAsso_benef, int idadmin)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean Check_login_Admin(String login, String password) {
boolean flag=false;
		
	    final String SQL_SELECT_PAR_NOM = "SELECT idAdmin, nomAdmin FROM admin WHERE  login=? AND password=?";
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

		try{
			/* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM,  login, password );
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
	public Admin getAdminByLogin(String login) {
		final String SQL_SELECT_By_Email = "SELECT * FROM admin WHERE login=? ";
		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultSet = null;
		  Admin admin = null;
		   
	  	try {
	  		
	  		connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_By_Email, login );
	        resultSet = preparedStatement.executeQuery();
	  		if ( resultSet.next() ) {
	  			admin = map( resultSet );
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  
	  	return admin;
	}

}
