package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Don;
import Beans.ProdADonnerBean;
import DAO.DonInterf;

import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class DonImpl implements DonInterf {
	
	private DAOFactory          daoFactory;

    public DonImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    

	@Override
	public void create(Don don) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static Don map( ResultSet resultSet ) throws SQLException {
		 Don don = new Don();
		 don.setIdDon( resultSet.getInt("idDon"));
		 don.setTypeDon( resultSet.getString( "typeDon" ) );
		 don.setNbrProd( resultSet.getString( "nbrProd" ) );
		 don.setCategories( resultSet.getString( "categories" ) );
		 don.setDescription( resultSet.getString( "description" ) );
		 don.setDateDon( resultSet.getDate( "dateDon" ) );
		
		
		return don;
		}
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public Don find(int idDon) throws DAOException {
		// TODO Auto-generated method stub
		
		
		final String SQL_SELECT_PAR_NOM = "SELECT idDon,typeDon,nbrProd,categories,description,dateDon FROM don WHERE idDon=?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Don don = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idDon );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	            don = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return don;
	}

	@Override
	public List<Don> getAllDon() throws DAOException {
		// TODO Auto-generated method stub
		List<Don> listallDon = new ArrayList<Don>();
	    final String SQL_SELECT_All = "select * from don;";
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
	        	Don don = new Don();
	        	don.setIdDon( resultSet.getInt( "idDon" ) );
	        	don.setTypeDon( resultSet.getString( "typeDon" ) );
	        	don.setNbrProd( resultSet.getString( "nbrProd" ) );
	        	don.setCategories( resultSet.getString( "categories" ) );
	        	don.setDescription( resultSet.getString( "description" ) );
	        	don.setDateDon( resultSet.getDate( "dateDon" ) );
				listallDon.add(don);
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

	    return listallDon;
	}
	
	@Override
	public List<Don> getAllDonClient(int idClient_don) throws DAOException {
		// TODO Auto-generated method stub
		List<Don> listallDonClient = new ArrayList<Don>();
	    final String SQL_SELECT_All = "select * from don WHERE idClient_don=? ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	//ProdADonnerBean ProdADonnerBean= null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All , idClient_don);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	        while(resultSet.next()) {
	        	//.next() pour aller a la ligne suivante
	        	Don don = new Don();
	        	don.setIdDon( resultSet.getInt( "idDon" ) );
	        	don.setTypeDon( resultSet.getString( "typeDon" ) );
	        	don.setNbrProd( resultSet.getString( "nbrProd" ) );
	        	don.setCategories( resultSet.getString( "categories" ) );
	        	don.setDescription( resultSet.getString( "description" ) );
	        	don.setDateDon( resultSet.getDate( "dateDon" ) );
	        	listallDonClient.add(don);
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

	    return listallDonClient;
	}


	@Override
	public List<Don> getAllDonAssociation(int idAsso_don) throws DAOException {
		// TODO Auto-generated method stub
		List<Don> listallDonAssociation = new ArrayList<Don>();
	    final String SQL_SELECT_All = "select * from don WHERE idAsso_don=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	//ProdADonnerBean ProdADonnerBean= null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idAsso_don);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	        while(resultSet.next()) {
	        	//.next() pour aller a la ligne suivante
	        	Don don = new Don();
	        	don.setIdDon( resultSet.getInt( "idDon" ) );
	        	don.setTypeDon( resultSet.getString( "typeDon" ) );
	        	don.setNbrProd( resultSet.getString( "nbrProd" ) );
	        	don.setCategories( resultSet.getString( "categories" ) );
	        	don.setDescription( resultSet.getString( "description" ) );
	        	don.setDateDon( resultSet.getDate( "dateDon" ) );
	        	listallDonAssociation.add(don);
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

	    return listallDonAssociation;
	}

	@Override
	public void addDon(String typeDon,String nbrProd, String categories, String description, String dateDon, int idClient_don, int idAsso_don) throws DAOException {
		// TODO Auto-generated method stub
		
		  Connection connexion = null;
		  PreparedStatement preparedStatement= null;
		   
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement= connexion.prepareStatement("insert into don values(?,?,?,?,?,?,?,?);");
		        preparedStatement.setString(1, null);
		        preparedStatement.setString(2, typeDon);
		        preparedStatement.setString(3,nbrProd);
		        preparedStatement.setString(4,categories);
		        preparedStatement.setString(5,description);
		        preparedStatement.setString(6,  dateDon);
		        preparedStatement.setInt(7, idClient_don);
		        preparedStatement.setInt(8, idAsso_don);
//		        preparedStatement = initRequestPrepare( connexion, SQL_INSERT_INTO, CIN,nom, prenom, job, skills );
		        preparedStatement.executeUpdate();
		        
		        
		       
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		
	}

	@Override
	public void suppDon(int idDon) throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Delete = "DELETE FROM don WHERE idDon=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Delete, idDon);
	        preparedStatement.executeUpdate();
	        
	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
		
	}

	@Override
	public void modifDon(String typeDon, String nbrProd, String categories, String description, String dateDon, int idDon)
			throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Update = "UPDATE don SET typeDon=?, nbrProd=?, categories=?, description=?, dateDon=? ,idClient_don=?,idAsso_don=? WHERE idDon=? ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Update, typeDon, nbrProd, categories, description, dateDon,1,1,idDon);
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


	


	


	

	

}
