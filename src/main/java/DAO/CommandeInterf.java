package DAO;

import java.util.List;

import Beans.Commande;
import DAO_properties.DAOException;

public interface CommandeInterf {
	
	// si client n'a aucune commande NonValide on va lui creer une commande
	// de plus on va meme retourner l'idCommande pur pouvoir creer ligneCommande
	int createCommande(int montantCommande, String modePaiement, String commantaire, String dateCommande, int idClient_Com, int etatCommande) throws DAOException ;
	
	// on cherche s'il existe une commande de ce client actuelle de plus
	//il faut que la commande soit non validee cad "etatCommande = 0"
	int findCommande(int idClient) throws DAOException;	 
	 
	Commande updateCommande(int idCommandeNonValide, int montantCommande , String modePaiement , String commantaire ,String dateCommande , int idClient_Com) throws DAOException; 
	
	
	
	
	List<Commande> getAllMesCommandes(int idClientTem) throws DAOException ;	 
	void addCommande(String quantite) throws DAOException; //, int idProdVente_ligneCom, int idCommande_ligneCom,idClientTem) throws DAOException; 
	void suppCommande(int idLigneCom) throws DAOException ;
	void modifCommande(String quantite  ,int idLigneCom) throws DAOException;  //, int idProdVente_ligneCom, int idCommande_ligneCom,idClientTem, int idLigneCom) throws DAOException ;
	
	
	
	
	
	


}
