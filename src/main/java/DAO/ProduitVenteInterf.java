package DAO;

import java.util.List;

//import Beans.Panier;
import DAO_properties.DAOException;
import Beans.ProduitVente;

public interface ProduitVenteInterf {

	
	
	 void create( ProduitVente prodVente) throws DAOException;
	 public List<ProduitVente>findProdVentByRef(int referenceProd) throws DAOException ;
	 public List<ProduitVente> getAllProduitVenteByAsso(int idAssociation) throws DAOException ;	
	 public List<ProduitVente> getAllProduitVenteByCat(int idCategorie_ProdVen) throws DAOException ;	 
	 void addProduitVente(String lib_Prod, String descProd, int idAsso_ProdVente ,String datetime,String image,int prix,String couleur,String taille,String nbrprodstock, int idCategorie_ProdVen, int referenceProd) throws DAOException;
	 void suppProduitVente(int idProdVente) throws DAOException ;
	 void modifProduitVente(String lib_Prod ,String descProd, String image,String dateAjout,String prix,String couleur,String taille,String nbrprodstock, int idProduit) throws DAOException ;
	

	//public void ajouterPanier(Panier pan);

}

