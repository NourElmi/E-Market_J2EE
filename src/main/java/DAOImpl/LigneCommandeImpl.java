package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Beans.LigneCommande;
import Beans.ProduitVente;
import DAO.LigneCommandeInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class LigneCommandeImpl implements LigneCommandeInterf {
	
	  private DAOFactory daoFactory;

	public LigneCommandeImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
	
	private static LigneCommande map( ResultSet resultSet ) throws SQLException {
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setIdLigneCom( resultSet.getInt("idLigneCom"));
		ligneCommande.setQuantite( resultSet.getInt( "quantite" ) );
		ligneCommande.setIdProdVente_ligneCom( resultSet.getInt( "idProdVente_ligneCom" ) );
		ligneCommande.setIdCommande_ligneCom( resultSet.getInt( "idCommande_ligneCom" ) );
		
		return ligneCommande;
		}
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}


	@Override
	public LigneCommande find(int idClientTem) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT idLigneCom,quantite,idProdVente_ligneCom,idCommande_ligneCom FROM lignecommande WHERE idClientTem=?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    LigneCommande ligneCommande = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idClientTem );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	ligneCommande = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return ligneCommande;
	}


	@Override
	public List<LigneCommande> getAllLigneCommande(int idClientTem) throws DAOException {
		// TODO Auto-generated method stub
		List<LigneCommande> listallLigneCommande = new ArrayList<LigneCommande>();
	    final String SQL_SELECT_All = "select * from lignecommande WHERE idClientTem=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	//ProdADonnerBean ProdADonnerBean= null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idClientTem);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	        while(resultSet.next()) {
	        	//.next() pour aller a la ligne suivante
	        	LigneCommande ligneCommande = new LigneCommande();
	        	ligneCommande.setIdLigneCom( resultSet.getInt("idLigneCom"));
	    		ligneCommande.setQuantite( resultSet.getInt( "quantite" ) );
	    		ligneCommande.setIdProdVente_ligneCom( resultSet.getInt( "idProdVente_ligneCom" ) );
	    		ligneCommande.setIdCommande_ligneCom( resultSet.getInt( "idCommande_ligneCom" ) );
				listallLigneCommande.add(ligneCommande);
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

	    return listallLigneCommande;
	}
	@Override
	public List showPanier_AllLigneCommande(int idClientSession) throws DAOException {
		// TODO Auto-generated method stub
		        
				List listallLigneCommande_ProdVente_Total = new LinkedList ();
				int TotalePrixPanier=0;
				
			    final String SQL_SELECT_All = "select produitVente.*, ligneCommande.* from produitVente, ligneCommande, Commande "
			    							+ "where Commande.idClient_Com=? and Commande.etatCommande=? and "
			    							+ "Commande.idCommande=ligneCommande.idCommande_ligneCom and "
			    							+ "ligneCommande.idProdVente_ligneCom=ProduitVente.idProdVente ;";
			    Connection connexion = null;
			    PreparedStatement preparedStatement= null;
			    ResultSet resultSet = null;

			    try {
			        /* Récupération d'une connexion depuis la Factory */
			    	
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idClientSession, 0);
			        resultSet = preparedStatement.executeQuery();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        if(resultSet==null) {
			        	listallLigneCommande_ProdVente_Total.add(" Panier Vide");
			      
			        }
			        
			        while(resultSet.next()) {
			        	//.next() pour aller a la ligne suivante
			        	LigneCommande ligneCommande = new LigneCommande();			        	
			        	
			        	ligneCommande.setIdLigneCom( resultSet.getInt("idLigneCom"));
			    		ligneCommande.setQuantite( resultSet.getInt( "quantite" ) );
			    		ligneCommande.setIdProdVente_ligneCom( resultSet.getInt( "idProdVente_ligneCom" ) );
			    		ligneCommande.setIdCommande_ligneCom( resultSet.getInt( "idCommande_ligneCom" ) );
			    		
			    		listallLigneCommande_ProdVente_Total.add(ligneCommande);
			    		
			    		ProduitVente produitVente= new ProduitVente();
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
				   		 
				   		TotalePrixPanier+=( resultSet.getInt("prix") * resultSet.getInt("quantite"));
				   		
				   		listallLigneCommande_ProdVente_Total.add(produitVente);
					}
			        
			       

			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        //ClosingAll( resultSet, preparedStatement, connexion );
			    }
			    listallLigneCommande_ProdVente_Total.add(TotalePrixPanier);

			    return listallLigneCommande_ProdVente_Total;
			    
	}


	@Override
	public void addLigneCommande(int quantite, int idProdVente_ligneCom, int idCommande_ligneCom, int IdClient) throws DAOException {
		  
		  final String SQL_Select = "select lignecommande.idLigneCom, lignecommande.quantite from lignecommande, commande where lignecommande.idProdVente_ligneCom=?  and lignecommande.idCommande_ligneCom=commande.idCommande and commande.idClient_Com=? and commande.etatCommande=0;";
		  
		  Connection connexion = null;
		  PreparedStatement preparedStatement= null;
		  ResultSet resultSet = null;
		  try {
		        /* Récupération d'une connexion depuis la Factory */
		    	connexion = daoFactory.getConnection();
			    preparedStatement = initRequestPrepare( connexion, SQL_Select,idProdVente_ligneCom,IdClient);
			    resultSet= preparedStatement.executeQuery(); 
			    if(resultSet.next()) 
				   {
		        	LigneCommande ligneCommande = new LigneCommande();			        	
		        	ligneCommande.setIdLigneCom(resultSet.getInt("idLigneCom"));
		        	ligneCommande.setQuantite(resultSet.getInt("quantite"));
		        	int idLigneCom= ligneCommande.getIdLigneCom();
		        	int quantiteAncienne= ligneCommande.getQuantite();
		        	int quantiteTotal= (quantiteAncienne+quantite);
		        	
		        	final String SQL_Update = "update lignecommande set quantite=? where idLigneCom=?";
		        	preparedStatement = initRequestPrepare( connexion, SQL_Update, quantiteTotal, idLigneCom);
					preparedStatement.executeUpdate(); 

				   }
				   else {
					   final String SQL_Insert = "insert into lignecommande values(?,?,?,?);";
					   preparedStatement = initRequestPrepare( connexion, SQL_Insert, null,quantite, idProdVente_ligneCom, idCommande_ligneCom);
					   preparedStatement.executeUpdate(); 

				   }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
		  
	}


	@Override
	public void suppLigneCommande(int idLigneCom) throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Delete = "DELETE FROM lignecommande WHERE idLigneCom=?;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Delete, idLigneCom);
	        preparedStatement.executeUpdate();
	        
	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
	}


	@Override
	public void modifLigneCommande(int quantite ,int idLigneCom) //, int idProdVente_ligneCom, int idCommande_ligneCom, int idLigneCom)
			throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_Update = "UPDATE lignecommande SET quantite=?, idProdVente_ligneCom=?, idCommande_ligneCom=?, idClientTem=? WHERE idLigneCom=? ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Update, quantite, 1,1,1,idLigneCom);
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
