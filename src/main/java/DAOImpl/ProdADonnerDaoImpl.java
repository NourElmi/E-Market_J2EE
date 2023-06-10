package DAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Beans.Demande;
//import dAO.DAOException;
//import dAO.DAOFactory;
//import dAO.ProdADonnerDAO;
import Beans.ProdADonnerBean;
import DAO.ProdADonnerDAO;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;


public class ProdADonnerDaoImpl implements ProdADonnerDAO {

	private DAOFactory          daoFactory;

    public ProdADonnerDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    


	private static ProdADonnerBean map( ResultSet resultSet ) throws SQLException {
		 ProdADonnerBean ProdADonnerBean = new ProdADonnerBean();
		 ProdADonnerBean.setIdProduit( resultSet.getInt("idProduit"));
		 ProdADonnerBean.setLib_Prod( resultSet.getString( "lib_Prod" ) );
		 ProdADonnerBean.setDescProd( resultSet.getString( "descProd" ) );
		 ProdADonnerBean.setImage( resultSet.getString( "image" ) );
		 ProdADonnerBean.setIdAsso_Prod( resultSet.getInt("idAsso_Prod"));
		 ProdADonnerBean.setDateAjout( resultSet.getDate( "dateAjout" ) );
		
		
		return ProdADonnerBean;
		}
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public ProdADonnerBean find(int idProduit) throws DAOException {
		// TODO Auto-generated method stub
		
		
		    final String SQL_SELECT_PAR_NOM = "SELECT * FROM produit WHERE idProduit=?";
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    ProdADonnerBean ProdADonnerBean = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idProduit );
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		            ProdADonnerBean = map( resultSet );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		    return ProdADonnerBean;
		

}
	@Override
	public List getAllProdADonner(int idAssociation) throws DAOException {
		// TODO Auto-generated method stub
			
			List listallProdADonner_EtatDemande_ByAsso= new LinkedList ();
	//		List<ProdADonnerBean> listallUser = new ArrayList<ProdADonnerBean>();
//			final String SQL_SELECT_All = "select DISTINCT produit.*, demande.* from produit, demande where demande.idBenef_demande=? and produit.idProduit=demande.idProd_Demande ";
			
		    final String SQL_SELECT_All = "select distinct  produit.*, demande.etatDemande from produit left join demande on demande.idProd_Demande= produit.idProduit where idAsso_Prod=? and produit.idProduit not in ( select demande.idProd_Demande from demande where demande.etatDemande in (3, 2));";
		    Connection connexion = null;
		    PreparedStatement preparedStatement= null;
		    ResultSet resultSet = null;
		
		//ProdADonnerBean ProdADonnerBean= null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		    	
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idAssociation);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        
		        while(resultSet.next()) {
		        	//.next() pour aller a la ligne suivante
		        	ProdADonnerBean Produit = new ProdADonnerBean();
		        	Produit.setIdProduit( resultSet.getInt( "idProduit" ) );
		        	Produit.setLib_Prod( resultSet.getString( "lib_Prod" ) );
		        	Produit.setDescProd( resultSet.getString( "descProd" ) );
		        	Produit.setIdAsso_Prod( resultSet.getInt( "idAsso_Prod" ) );
		        	Produit.setImage( resultSet.getString( "image" ) );
		        	Produit.setDateAjout( resultSet.getDate( "dateAjout" ) );
		        	listallProdADonner_EtatDemande_ByAsso.add(Produit);
		        	
		        	Demande demande=new Demande();
//		        	demande.setIdDemande( resultSet.getInt("idDemande"));
		            demande.setEtatDemande( resultSet.getInt( "etatDemande" ) );
		            
		            listallProdADonner_EtatDemande_ByAsso.add(demande);
				}
//		        while ( resultSet.next() ) {
//		            ProdADonnerBean = map( resultSet );
//		            listallUser.add(ProdADonnerBean);
//		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		    return listallProdADonner_EtatDemande_ByAsso;
		}
//	@Override
//	public List<ProdADonnerBean> getFreelancPostu(String offreID)  throws DAOException{
//		List<ProdADonnerBean> listallFreePostu = new ArrayList<ProdADonnerBean>();
//	    final String SQL_SELECT_All = "select * from offre,ProdADonner, postuler where postuler.offfreID=offre.offreID and postuler.freeID=ProdADonner.ProdADonnerID ;";
//	    Connection connexion = null;
//	    PreparedStatement preparedStatement= null;
//	    ResultSet resultSet = null;
//	//ProdADonnerBean ProdADonnerBean= null;
//
//	    try {
//	        /* Récupération d'une connexion depuis la Factory */
//	    	
//	        connexion = daoFactory.getConnection();
//	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All);
//	        resultSet = preparedStatement.executeQuery();
//	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
//	        
//	        while(resultSet.next()) {
//	        	//.next() pour aller a la ligne suivante
//	        	ProdADonnerBean user = new ProdADonnerBean();
//				user.setCIN( resultSet.getString( "CIN" ) );
//				user.setNom( resultSet.getString( "nom" ) );
//				user.setPrenom( resultSet.getString( "prenom" ) );
//				user.setJob( resultSet.getString( "job" ) );
//				user.setSkills( resultSet.getString( "skills" ) );
//				listallFreePostu.add(user);
//			}
////	        while ( resultSet.next() ) {
////	            ProdADonnerBean = map( resultSet );
////	            listallUser.add(ProdADonnerBean);
////	        }
//	    } catch ( SQLException e ) {
//	        throw new DAOException( e );
//	    } finally {
//	        //ClosingAll( resultSet, preparedStatement, connexion );
//	    }
//
//	    return listallFreePostu;
//		
//	};

	@Override

	public void addProdADonner(String lib_Prod, String descProd, String input,String dateAjout, int idAsso_Prod) throws DAOException {
		// TODO Auto-generated method stub
		//final String SQL_INSERT_INTO = "insert into ProdADonner values(?,?,?,?,?);";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement= connexion.prepareStatement("insert into produit values(?,?,?,?,?,?);");
	        preparedStatement.setString(1, null);
	        preparedStatement.setString(2, lib_Prod);
	        preparedStatement.setString(3,descProd);
	        preparedStatement.setString(6,input);
	        preparedStatement.setInt(4, idAsso_Prod);
	        preparedStatement.setString(5,  dateAjout);
//	        preparedStatement = initRequestPrepare( connexion, SQL_INSERT_INTO, CIN,nom, prenom, job, skills );
	        preparedStatement.executeUpdate();
	     
		
	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    
	}
	@Override
	public void suppProdADonner(int idProduit) throws DAOException {
		
		final String SQL_Delete = "DELETE FROM produit WHERE idProduit=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Delete, idProduit);
	        preparedStatement.executeUpdate();
	        
	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
	}
	@Override
	public void modifProdADonner (String lib_Prod ,String descProd, String image, String dateAjout, int idProduit, int idAsso_Prod ) throws DAOException{
		// TODO Auto-generated method stub
		final String SQL_Update = "UPDATE produit SET lib_Prod=?, descProd=?, image=?, idAsso_Prod=?, dateAjout=? WHERE idProduit=? ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	  
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Update, lib_Prod, descProd, image, 1, dateAjout, idProduit);
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
	public List<ProdADonnerBean> getAllProdADonner() throws DAOException {
		List<ProdADonnerBean> listallUser = new ArrayList<ProdADonnerBean>();
	    final String SQL_SELECT_All = "select produit.* from produit where produit.idProduit not in "
	    		+ "( select demande.idProd_Demande from demande "
	    		+ "where demande.etatDemande in (3, 2))";
	    
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
	        	ProdADonnerBean Produit = new ProdADonnerBean();
	        	Produit.setIdProduit( resultSet.getInt( "idProduit" ) );
	        	Produit.setLib_Prod( resultSet.getString( "lib_Prod" ) );
	        	Produit.setDescProd( resultSet.getString( "descProd" ) );
	        	Produit.setIdAsso_Prod( resultSet.getInt( "idAsso_Prod" ) );
	        	Produit.setImage( resultSet.getString( "image" ) );
	        	Produit.setDateAjout( resultSet.getDate( "dateAjout" ) );
				listallUser.add(Produit);
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

	    return listallUser;
	}



	@Override
	public List getProdADonnerDemanderByBenef(int idBeneficiaire) throws DAOException {
		
		List listallProdADonner_EtatDemande= new LinkedList ();

		
	    final String SQL_SELECT_All = "select DISTINCT produit.*, demande.* from produit, demande where demande.idBenef_demande=? and produit.idProduit=demande.idProd_Demande ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	
	    

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idBeneficiaire);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        

	        while ( resultSet.next() ) {
	        	ProdADonnerBean ProdADonnerBean= new ProdADonnerBean();
	            ProdADonnerBean = map( resultSet );
	            
	            listallProdADonner_EtatDemande.add(ProdADonnerBean);
	            
	            Demande demande=new Demande();
	   		    demande.setIdDemande( resultSet.getInt("idDemande"));
	            demande.setEtatDemande( resultSet.getInt( "etatDemande" ) );
	            
	            listallProdADonner_EtatDemande.add(demande);
	            
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
//	        ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return listallProdADonner_EtatDemande;
	}

}
