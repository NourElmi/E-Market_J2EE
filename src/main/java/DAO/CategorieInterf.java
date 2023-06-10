package DAO;

import java.util.List;


import Beans.Categorie;
import DAO_properties.DAOException;

public interface CategorieInterf {
	
	void create( Categorie categorie) throws DAOException;
	 Categorie find(int idCategorie) throws DAOException;	 
	 List<Categorie> getAllCategorie() throws DAOException ;	
	void addCategorie(String lib_Categorie) throws DAOException;
	 
	 void suppCategorie(int idCategorie) throws DAOException ;
	 void modifCategorie(String lib_Categorie,int idCategorie) throws DAOException ;

	

}
