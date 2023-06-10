package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Association;
import Beans.Beneficiaire;
import Beans.Don;
import DAO.BeneficiaireInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class BeneficiaireImpl implements BeneficiaireInterf {
	
	private DAOFactory          daoFactory;

    public BeneficiaireImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }


	public void create(Beneficiaire beneficiaire) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static Beneficiaire map( ResultSet resultSet ) throws SQLException {
		Beneficiaire beneficiaire = new Beneficiaire();
		
		 beneficiaire.setIdBeneficiaire( resultSet.getInt("idBeneficiaire"));
		 beneficiaire.setNomBenefi( resultSet.getString( "nomBenefi" ) );
		 beneficiaire.setPrenomBenefi( resultSet.getString( "prenomBenefi" ) );
		 beneficiaire.setLogin( resultSet.getString( "login" ) );
		 beneficiaire.setPassword( resultSet.getString( "password" ) );

		 beneficiaire.setNumTel( resultSet.getInt("numTel"));
		 beneficiaire.setAdresse( resultSet.getString( "adresse" ) );
		 beneficiaire.setGenre( resultSet.getString( "genre" ) );
		 beneficiaire.setDateNaissance( resultSet.getDate( "dateNaissance" ) );
		// beneficiaire.setIdAsso_benef( resultSet.getInt("idAsso_benef"));
		
		
		return beneficiaire;
		}
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public Beneficiaire find(int idBeneficiaire) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT * FROM beneficiaire WHERE idBeneficiaire=?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Beneficiaire beneficiaire = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idBeneficiaire );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	 beneficiaire = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return beneficiaire;
	}

	@Override
	public List<Beneficiaire> getAllBeneficiaire() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Beneficiaire> getAllBeneficiaireAsso() throws DAOException {
		// TODO Auto-generated method stub
		List<Beneficiaire> listallBeneficiaireAsso = new ArrayList<Beneficiaire>();
	    final String SQL_SELECT_All = "select * from beneficiaire ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	//ProdADonnerBean ProdADonnerBean= null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	        while(resultSet.next()) {
	        	//.next() pour aller a la ligne suivante
	        	Beneficiaire beneficiaire = new Beneficiaire();
	   		 beneficiaire.setIdBeneficiaire( resultSet.getInt("idBeneficiaire"));
	   		 beneficiaire.setNomBenefi( resultSet.getString( "nomBenefi" ) );
	   		 beneficiaire.setPrenomBenefi( resultSet.getString( "prenomBenefi" ) );
	   		 beneficiaire.setLogin( resultSet.getString( "login" ) );
	   		 beneficiaire.setPassword( resultSet.getString( "password" ) );
	   		 beneficiaire.setDateNaissance( resultSet.getDate( "dateNaissance" ) );
	   		 beneficiaire.setNumTel( resultSet.getInt("numTel"));
	   		 beneficiaire.setAdresse( resultSet.getString( "adresse" ) );
	   		 beneficiaire.setGenre( resultSet.getString( "genre" ) );
	   		 beneficiaire.setDateNaissance( resultSet.getDate( "dateNaissance" ) );
	   		 
	        	listallBeneficiaireAsso.add(beneficiaire);
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

	    return listallBeneficiaireAsso;
	}
	@Override
	public void addBeneficiaire(String nomBenefi, String prenomBenefi, String login, String password, int numTel,
			String adresse, String genre, String dateNaissance) throws DAOException {
		// TODO Auto-generated method stub
		
		 Connection connexion = null;
		  PreparedStatement preparedStatement= null;
		   
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement= connexion.prepareStatement("insert into Beneficiaire values(?,?,?,?,?,?,?,?,?);");
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
	public void suppBeneficiaire(int idBeneficiaire) throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Delete = "DELETE FROM beneficiaire WHERE idBeneficiaire=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Delete, idBeneficiaire);
	        preparedStatement.executeUpdate();
	        
	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
	}

	@Override
	public void modifBeneficiaire(String nomBenefi, String prenomBenefi, String login, String password, int numTel,
			String adresse, String genre, String dateNaissance, int idAsso_benef, int idBeneficiaire) throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Update = "UPDATE beneficiaire SET nomBenefi=?, prenomBenefi=?, login=?, password=?, numTel=? ,adresse=?,genre=?,dateNaissance=? WHERE idBeneficiaire=? ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Update, nomBenefi, prenomBenefi, login, password, numTel,adresse,genre,dateNaissance,idBeneficiaire);
	        preparedStatement.executeUpdate();
//	        preparedStatement= connexion.prepareStatement("UPDATE ProdADonner SET nom=?, prenom=?, job=?, skills=? WHERE CIN=?;");
//	        
//	        preparedStatement.setString(1, nom);
//	        preparedStatement.setString(2, prenom);
//	        preparedStatement.setString(3,job);
//	        preparedStatement.setString(4, skills);
//	        preparedStatement.setString(5, CIN);
	        
	        
	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	}

	@Override
	public boolean Check_login_benef(String login, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
	    final String SQL_SELECT_PAR_NOM = "SELECT idBeneficiaire, nomBenefi FROM beneficiaire WHERE  login=? AND password=?";
		
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
	public Beneficiaire getBeneficiaireByLogin(String login) {
		// TODO Auto-generated method stub
		 final String SQL_SELECT_By_Email = "SELECT * FROM beneficiaire WHERE login=? ";
		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultSet = null;
		  Beneficiaire beneficiaire = null;
		    System.out.println(login);
	  	try {
	  		
	  		connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_By_Email, login );
	        resultSet = preparedStatement.executeQuery();
	  		if ( resultSet.next() ) {
	  			beneficiaire = map( resultSet );
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  	System.out.println(beneficiaire.getIdBeneficiaire());
	  	return beneficiaire;
	}


	
}
