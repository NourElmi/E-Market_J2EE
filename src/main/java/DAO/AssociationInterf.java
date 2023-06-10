package DAO;

import java.util.List;

import Beans.Association;
import DAO_properties.DAOException;

public interface AssociationInterf 

{
	  public void insertAssociation(String nomAsso,String secteur,String nomRespo,String prenomRespo,String email,String password,String telephoneAsso,String ville,String localisation,int nbrJourRecuProd) throws DAOException;
	  public boolean Check_login_ass(String email, String password) throws DAOException;
	  boolean updateAssociation(AssociationInterf ass) throws DAOException;
	  Association getAssociationByEmail(String email) throws DAOException;
	  AssociationInterf getAssociationById(int id) throws DAOException;
	  List<Association> getAllAssociation() throws DAOException ;
	
	
}
