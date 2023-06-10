package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Beans.Beneficiaire;
import Beans.Demande;
import Beans.LigneCommande;
import Beans.ProdADonnerBean;
import Beans.ProduitVente;
import DAO.DemandeInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class DemandeImpl  implements DemandeInterf{

	private DAOFactory          daoFactory;

    public DemandeImpl ( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    private static Demande map( ResultSet resultSet ) throws SQLException {
		Demande demande = new Demande();
		 demande.setIdDemande( resultSet.getInt("idDemande"));
		 demande.setDateDemande( resultSet.getDate( "dateDemande" ) );
		 demande.setIdBenef_demande( resultSet.getInt( "idBenef_demande" ) );
		 demande.setIdProd_Demande( resultSet.getInt( "idProd_Demande" ) );
		 demande.setEtatDemande( resultSet.getInt( "etatDemande" ) );

		
		return demande;
		}
    
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public void addDemande( String dateDemande, int idBenef_demande, int idProd_Demande)
			throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Insert = "insert into demande values(?,?,?,?,?);";
		  Connection connexion = null;
		  PreparedStatement preparedStatement= null;
		   
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		    	connexion = daoFactory.getConnection();
			    preparedStatement = initRequestPrepare( connexion, SQL_Insert, null,dateDemande, idBenef_demande, idProd_Demande, 1);
			    preparedStatement.executeUpdate(); 
		       
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
		
	}

	@Override
	public List getAllDemandeByDate(int idProd_Demande,int idAsso_Prod) throws DAOException {
		// TODO Auto-generated method stub
		List listallDemandeByAsso_Prod_Benef = new LinkedList ();

	    final String SQL_SELECT = "SELECT Beneficiaire.idBeneficiaire, Beneficiaire.nomBenefi, Beneficiaire.prenomBenefi, Beneficiaire.numTel , Beneficiaire.adresse , "
	    						+" demande.*, produit.* FROM demande,produit,Beneficiaire WHERE "
	    						+" idProd_Demande=? AND demande.idProd_Demande = produit.idProduit AND "
	    						+" produit.idAsso_Prod=? and demande.idBenef_demande=Beneficiaire.idBeneficiaire order by dateDemande;";
	                               
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;



	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT, idProd_Demande,idAsso_Prod);
	        resultSet = preparedStatement.executeQuery();
	  
		    if (resultSet.next() ) {
	        
		     ProdADonnerBean prodADonnerBean= new ProdADonnerBean();
	         prodADonnerBean.setIdProduit(resultSet.getInt("idProduit"));
	         prodADonnerBean.setLib_Prod( resultSet.getString( "lib_Prod" ) );
			 prodADonnerBean.setDescProd( resultSet.getString( "descProd" ) );
			 prodADonnerBean.setImage( resultSet.getString( "image" ) );
			 prodADonnerBean.setIdAsso_Prod( resultSet.getInt("idAsso_Prod"));
			 prodADonnerBean.setDateAjout( resultSet.getDate( "dateAjout" ) );
			 
   		     listallDemandeByAsso_Prod_Benef.add(prodADonnerBean);
		    
		    do{
	      
	        	
	        	 Demande demande = new Demande();	        	 
	        	 demande.setIdDemande( resultSet.getInt("idDemande"));
	    		 demande.setDateDemande( resultSet.getDate( "dateDemande" ) );
	    		 demande.setIdBenef_demande( resultSet.getInt( "idBenef_demande" ) );
	    		 demande.setIdProd_Demande( resultSet.getInt( "idProd_Demande" ) );
	    		 demande.setEtatDemande( resultSet.getInt( "etatDemande" ) );
	        	
	    		 listallDemandeByAsso_Prod_Benef.add(demande);

	    		 Beneficiaire beneficiaire = new Beneficiaire();
	    		 beneficiaire.setIdBeneficiaire( resultSet.getInt("idBeneficiaire"));
	    		 beneficiaire.setNomBenefi( resultSet.getString( "nomBenefi" ) );
	    		 beneficiaire.setPrenomBenefi( resultSet.getString( "prenomBenefi" ) );
	    		 beneficiaire.setNumTel( resultSet.getInt("numTel"));
	    		 beneficiaire.setAdresse( resultSet.getString( "adresse" ) );
	    		 
	    		 listallDemandeByAsso_Prod_Benef.add(beneficiaire);
	    		 System.out.println("bouuuuuucle");
//			System.out.println(((Beneficiaire) listallDemandeByAsso_Prod_Benef.get(2)).getNomBenefi());
//			System.out.println(((Demande)listallDemandeByAsso_Prod_Benef.get(2)).getIdProd_Demande());
//	        
		    }while (resultSet.next());
		    }
//	        System.out.println("pas de bouuuuuucleeeeee");
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }


	    return listallDemandeByAsso_Prod_Benef;
	}

	@Override
	public void accepterDemande(int idDemande) throws DAOException {
		
		  final String SQL_Update = "update demande set  etatDemande=2 where idDemande=? ;";
		  Connection connexion = null;
		  PreparedStatement preparedStatement= null;
		  ResultSet resultSet = null;
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		    	connexion = daoFactory.getConnection();
			    preparedStatement = initRequestPrepare( connexion, SQL_Update, idDemande);
			    preparedStatement.executeUpdate(); 
			    
			    final String SQL_Select = "select idBenef_demande, idProd_Demande from demande where idDemande=? ;";
			    preparedStatement = initRequestPrepare( connexion, SQL_Select, idDemande);
			    resultSet = preparedStatement.executeQuery();
			   if (  resultSet.next() ) {
			    int idBenef_demande=resultSet.getInt("idBenef_demande");
			    int idProd_Demande=resultSet.getInt("idProd_Demande");
			    
			    final String SQL_Update2 = "update demande set  etatDemande=3 where idProd_Demande=? and idBenef_demande != ?;";
			    preparedStatement = initRequestPrepare( connexion, SQL_Update2, idProd_Demande, idBenef_demande);
			    preparedStatement.executeUpdate(); 
			    
//			    final String SQL_delete1=" DELETE FROM demande WHERE idDemande = ?;";
//			    preparedStatement = initRequestPrepare( connexion, SQL_delete1, idDemande);
//			    preparedStatement.executeUpdate(); 
//			    
//			    final String SQL_delete2= "DELETE FROM produit WHERE idProduit IN (SELECT idProd_Demande FROM demande WHERE idDemande = ?) ;";
//			    preparedStatement = initRequestPrepare( connexion, SQL_delete2, idProd_Demande);
//			    preparedStatement.executeUpdate(); 
//			    
			    }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
	}

}
