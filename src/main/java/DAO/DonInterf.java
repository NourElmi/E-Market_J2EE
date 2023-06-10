package DAO;

//import java.util.Date;
import java.util.List;

import Beans.Don;

import DAO_properties.DAOException;

public interface DonInterf {
	
	void create( Don don ) throws DAOException;
	// Don: class  don: objet 
	 Don find(int idDon) throws DAOException;	 
	 List<Don> getAllDon() throws DAOException ;	 
	 List<Don> getAllDonClient(int idClient_don) throws DAOException ;
	 List<Don> getAllDonAssociation(int idAsso_don) throws DAOException ;
	 void addDon(String typeDon, String nbrProd, String categories,String description,String dateDon, int idClient_don, int idAsso_don) throws DAOException;
	 
	 void suppDon(int idProduit) throws DAOException ;
	 void modifDon(String typeDon, String nbrProd, String categories,String description,String dateDon, int idDon) throws DAOException ;

	


}
