package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Beans.ProdADonnerBean;
//import Beans.Panier;
import Beans.ProduitVente;
import DAO.ProduitVenteInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class ProduitVenteImpl implements ProduitVenteInterf {
	
	private DAOFactory          daoFactory;

    public ProduitVenteImpl ( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	@Override
	public void create(ProduitVente prodVente) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static ProduitVente map( ResultSet resultSet ) throws SQLException {
		ProduitVente produitVente = new ProduitVente();
		 produitVente.setIdProdVente( resultSet.getInt("idProdVente"));
		 produitVente.setLib_Prod( resultSet.getString( "lib_Prod" ) );
		 produitVente.setDescProd( resultSet.getString( "descProd" ) );
		 produitVente.setIdAsso_ProdVente( resultSet.getInt("idAsso_ProdVente"));
		 produitVente.setDateAjout( resultSet.getDate( "dateAjout" ) );
		 produitVente.setImage( resultSet.getString( "image" ) );
		 produitVente.setPrix( resultSet.getInt( "prix" ) );
		 produitVente.setCouleur( resultSet.getString( "couleur" ) );
		 produitVente.setTaille( resultSet.getString( "taille" ) );
		 produitVente.setNbrprodstock( resultSet.getString( "nbrprodstock" ) );
		 produitVente.setIdCategorie_ProdVen( resultSet.getInt("idCategorie_ProdVen"));
		 produitVente.setReferenceProd( resultSet.getInt("referenceProd"));
		
		return produitVente;
		}
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}


	@Override
	public List<ProduitVente> getAllProduitVenteByAsso(int idAssociation) throws DAOException {
		
		
	    final String SQL_SELECT_All = "select * from produitVente where  idAsso_ProdVente=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	    
	    ProduitVente produitVente = new ProduitVente();
	    List<ProduitVente> listProduitVente = new ArrayList<ProduitVente>();
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idAssociation);
	        resultSet = preparedStatement.executeQuery();
	        
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	  
	        while ( resultSet.next() ) {
	        		//.next() pour aller a la ligne suivante
	            produitVente = map( resultSet );
	            listProduitVente.add(produitVente);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	    return listProduitVente;
	}

	@Override
	public List<ProduitVente> getAllProduitVenteByCat(int idCategorie_ProdVen) throws DAOException {
			
		   
		    List<ProduitVente> listProduitVenteOneforeachRef = new ArrayList<ProduitVente>();
		    List<Integer> listeReferences= new ArrayList<Integer>();
		    
			
			final String SQL_SELECT_All_REF = "select DISTINCT referenceProd from produitVente where  idCategorie_ProdVen=? ;";
		    Connection connexion = null;
		    PreparedStatement preparedStatement= null;
		    ResultSet resultSet = null;
		    
		    ProduitVente produitVente = new ProduitVente();
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		    	
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All_REF, idCategorie_ProdVen);
		        resultSet = preparedStatement.executeQuery();
		        
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		  
		        while ( resultSet.next() ) {		        	
		        	listeReferences.add(resultSet.getInt("referenceProd"));
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
//		    System.out.println(listeReferences.get(0)+"  "+ listeReferences.get(1));
		    
		    for(int referenceProd : listeReferences){
		    	List<ProduitVente> listProduitVenteByRef = new ArrayList<ProduitVente>();
		    	final String SQL_SELECT_All = "select * from produitVente where  idCategorie_ProdVen=? and referenceProd=?;";
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			    	
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idCategorie_ProdVen, referenceProd);
			        resultSet = preparedStatement.executeQuery();
			        
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			  
			        while ( resultSet.next() ) {
			        		//.next() pour aller a la ligne suivante
			            produitVente = map( resultSet );
			            listProduitVenteByRef.add(produitVente);
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        //ClosingAll( resultSet, preparedStatement, connexion );
			    }
			    
//			    if(!listProduitVenteByRef.get(0).getLib_Prod().isEmpty()) {
			    listProduitVenteOneforeachRef.add(listProduitVenteByRef.get(0));
//			    }
//			    System.out.println(listProduitVenteByRef.get(0));
		    }
		    return listProduitVenteOneforeachRef;
	}
	@Override
	public void addProduitVente(String lib_Prod, String descProd, int idAsso_ProdVente, String image, String dateAjout, int prix,
			String couleur, String taille, String nbrprodstock, int idCategorie_ProdVen, int referenceProd) throws DAOException {
		
			final String SQL_Insert = "insert into produitvente values(?,?,?,?,?,?,?,?,?,?,?,?);";
		  	Connection connexion = null;
		    PreparedStatement preparedStatement= null;
		   
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		    	
		    	connexion = daoFactory.getConnection();
			    preparedStatement = initRequestPrepare( connexion, SQL_Insert, null,lib_Prod, descProd, idAsso_ProdVente, dateAjout, image, prix, couleur, taille , nbrprodstock,idCategorie_ProdVen, referenceProd);
			    preparedStatement.executeUpdate();

		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } 

	}
	
	@Override
	public List<ProduitVente> findProdVentByRef(int referenceProd) throws DAOException {
		// TODO Auto-generated method stub
		
		    List<ProduitVente> listProduitVenteByRefer = new ArrayList<ProduitVente>();
		    final String SQL_SELECT = "SELECT * FROM produitVente WHERE referenceProd=?";
		    
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    ProduitVente produitVente = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT, referenceProd);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        
		        while (  resultSet.next() ) {
		        	produitVente = map( resultSet );
		        	listProduitVenteByRefer.add(produitVente);
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
//		    listProduitVenteByRefer.get(0).getTaille()+"    "+
//		    System.out.println(listProduitVenteByRefer.get(0).getTaille());
		    return listProduitVenteByRefer;
		

}

	@Override
	public void suppProduitVente(int idProdVente) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifProduitVente(String lib_Prod, String descProd, String image, String dateAjout, String prix,
			String couleur, String taille, String nbrprodstock, int idProduit) throws DAOException {
		// TODO Auto-generated method stub
		
	}

    


}
