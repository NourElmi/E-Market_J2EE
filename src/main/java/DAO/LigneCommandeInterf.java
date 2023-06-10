package DAO;

import java.util.List;


import Beans.LigneCommande;
import DAO_properties.DAOException;

public interface LigneCommandeInterf {
	
	
	void addLigneCommande(int quantite, int idProdVente_ligneCom, int idCommande_ligneCom, int IdClient) throws DAOException;

	
	
	LigneCommande find(int idClientTem) throws DAOException;	
	List<LigneCommande> getAllLigneCommande(int idClientTem) throws DAOException ;
	List showPanier_AllLigneCommande(int idClientSession) throws DAOException ; 
	void suppLigneCommande(int idLigneCom) throws DAOException ;
	void modifLigneCommande(int quantite  ,int idLigneCom) throws DAOException;  //, int idProdVente_ligneCom, int idCommande_ligneCom,idClientTem, int idLigneCom) throws DAOException ;

	


}
