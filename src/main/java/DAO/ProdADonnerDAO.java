package DAO;

//import java.io.File;
//import java.io.FileInputStream;
//import java.util.Date;
import java.util.List;

import DAO_properties.DAOException;
import Beans.ProdADonnerBean;
//
// c'est l'interface qui va etre implementer par la classe ClientDaoimpl
//

public interface ProdADonnerDAO 
	{
	
	 ProdADonnerBean find(int idProduit) throws DAOException;	 
	 List getAllProdADonner(int idAssociation) throws DAOException ;	 
	 
	 List<ProdADonnerBean> getAllProdADonner() throws DAOException ;	 
	 
	 List getProdADonnerDemanderByBenef(int idBeneficiaire) throws DAOException ;	 
	 
	 void addProdADonner(String lib_Prod, String descProd, String image,String dateAjout, int idAsso_Prod) throws DAOException;
	 void suppProdADonner(int idProduit) throws DAOException ;
	 void modifProdADonner(String lib_Prod ,String descProd, String image,String dateAjout, int idProduit, int idAsso_Prod) throws DAOException ;
	

	}