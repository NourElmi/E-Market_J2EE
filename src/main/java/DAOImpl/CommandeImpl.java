package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Commande;
import Beans.LigneCommande;
import Beans.ProdADonnerBean;
import Beans.ProduitVente;
import DAO.CommandeInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;

public class CommandeImpl implements CommandeInterf{
	
	private DAOFactory          daoFactory;

    public CommandeImpl ( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	private static Commande map( ResultSet resultSet ) throws SQLException {
		Commande commande = new Commande();
		commande.setIdCommande( resultSet.getInt("IdCommande"));
		commande.setMontantCommande( resultSet.getInt( "MontantCommande" ) );
		commande.setModePaiement( resultSet.getString( "ModePaiement" ) );
		commande.setCommantaire( resultSet.getString("Commantaire"));
		commande.setDateCommande( resultSet.getDate( "dateCommande" ) );
		commande.setIdClient_Com( resultSet.getInt( "idClient_Com" ) );
		commande.setEtatCommande( resultSet.getInt( "etatCommande" ) );
	
		return commande;
		}
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}


	@Override
		public int createCommande(int montantCommande, String modePaiement, String commantaire, String dateCommande, int idClient_Com, int etatCommande) throws DAOException {
			
				int idcommandeNonValidee ;
		
				final String SQL_Insert = "insert into Commande values(?,?,?,?,?,?,?);";
			  	Connection connexion = null;
			    PreparedStatement preparedStatement= null;
			    System.out.println("asdfghjkl;kijuytr");
			    System.out.println(montantCommande+" "+ modePaiement);
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			    	
			    	connexion = daoFactory.getConnection();
				    preparedStatement = initRequestPrepare( connexion, SQL_Insert, null,montantCommande, modePaiement, commantaire, dateCommande, idClient_Com, etatCommande);
				    preparedStatement.executeUpdate();

			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    }
			    
			    idcommandeNonValidee = this.findCommande(idClient_Com);
			    
			    return idcommandeNonValidee;
		}
		
	@Override
	public int findCommande(int idClient) throws DAOException {
		
		int idcommandeNonValidee = 0;
		
		final String SQL_SELECT = "SELECT idCommande FROM Commande WHERE idClient_Com=? and etatCommande= ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Commande commande = new Commande();
	    
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT, idClient, 0 );
	        resultSet = preparedStatement.executeQuery();
	        
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        // Si on trouve une commande alors il faut retourner son Id
	        if ( resultSet.next() ) {
	        	
	        	commande.setIdCommande( resultSet.getInt("idCommande"));
	        	idcommandeNonValidee = commande.getIdCommande();
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	    System.out.println("lksajnhdbgvfhvbjn");
	    System.out.println(idcommandeNonValidee);

	    return idcommandeNonValidee;
	}
	@Override
	public Commande updateCommande(int idCommandeNonValide, int montantCommande, String modePaiement, String commantaire,
			String dateCommande, int idClient_Com) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_Update = "UPDATE commande SET montantCommande=?, modePaiement=?, commantaire=?, dateCommande=?,idClient_Com=?,etatCommande=? WHERE idCommande=? ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	    Commande commandeValidee=new Commande();
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_Update, montantCommande, modePaiement, commantaire, dateCommande,idClient_Com ,1, idCommandeNonValide);
	        preparedStatement.executeUpdate();
	        
			final String SQL_Select = "select *from commande where idCommande=? ;";
			preparedStatement = initRequestPrepare( connexion, SQL_Select, idCommandeNonValide);
			resultSet= preparedStatement.executeQuery();
		    
		  
		   if(resultSet.next()) {
			   commandeValidee = map( resultSet );
		   }

	       
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	
	    return commandeValidee;
		
	}


	@Override
	public List<Commande> getAllMesCommandes(int idClientTem) throws DAOException {
		
		List<Commande> listallCommande = new ArrayList<Commande>();
	    final String SQL_SELECT_All = "select * from commande WHERE idClient_Com=? and etatCommande=1 ;";
	    Connection connexion = null;
	    PreparedStatement preparedStatement= null;
	    ResultSet resultSet = null;
	    Commande commande= null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_All, idClientTem);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	        while(resultSet.next()) {
	        	//.next() pour aller a la ligne suivante
	        	commande = map( resultSet );
	        	listallCommande.add(commande);
			}

	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return listallCommande;
	}

	@Override
	public void addCommande(String quantite) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppCommande(int idLigneCom) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifCommande(String quantite, int idLigneCom) throws DAOException {
		// TODO Auto-generated method stub
		
	}


}
