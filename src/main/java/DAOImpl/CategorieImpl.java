package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Categorie;
import Beans.Don;
import DAO.CategorieInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class CategorieImpl implements CategorieInterf {
	
	private DAOFactory          daoFactory;

    public CategorieImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    @Override
	public void create(Categorie categorie) throws DAOException {
		// TODO Auto-generated method stub
		
	}
    
    private static Categorie map( ResultSet resultSet ) throws SQLException {
    	Categorie categorie = new Categorie();
    	categorie.setIdCategorie( resultSet.getInt("idCategorie"));
    	categorie.setLib_Categorie( resultSet.getString( "lib_Categorie") );
		
		
		
		return categorie;
		}
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public Categorie find(int idCategorie) throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_SELECT_PAR_NOM = "SELECT idCategorie,lib_Categorie FROM don WHERE idCategorie=?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Categorie Categorie = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idCategorie );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	Categorie = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return Categorie;
	}

	@Override
	public List<Categorie> getAllCategorie() throws DAOException {
		// TODO Auto-generated method stub
		List<Categorie> listallCategorie = new ArrayList<Categorie>();
	    final String SQL_SELECT_All = "select * from categorie;";
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
	        	Categorie categorie = new Categorie();
	        	categorie.setIdCategorie( resultSet.getInt( "idCategorie" ) );
	        	categorie.setLib_Categorie( resultSet.getString( "lib_Categorie" ) );
	        	
				listallCategorie.add(categorie);
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

	    return listallCategorie;
	}

	@Override
	public void addCategorie(String lib_Categorie) throws DAOException {
		// TODO Auto-generated method stub
		
		 Connection connexion = null;
		  PreparedStatement preparedStatement= null;
		   
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement= connexion.prepareStatement("insert into don values(?,?);");
		        preparedStatement.setString(1, null);
		        preparedStatement.setString(2, lib_Categorie);
		        
//		        preparedStatement = initRequestPrepare( connexion, SQL_INSERT_INTO, CIN,nom, prenom, job, skills );
		        preparedStatement.executeUpdate();
		        
		        
		       
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		
	}

	@Override
	public void suppCategorie(int idCategorie) throws DAOException {
		// TODO Auto-generated method stub
		
		
		final String SQL_Delete = "DELETE FROM categorie WHERE idCategorie=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Delete, idCategorie);
	        preparedStatement.executeUpdate();
	        
	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	}

	@Override
	public void modifCategorie(String lib_Categorie, int idCategorie) throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Update = "UPDATE categorie SET lib_Categorie=? WHERE idCategorie=? ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Update, lib_Categorie, idCategorie);
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
