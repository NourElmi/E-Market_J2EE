package DAO;

import java.util.List;

import Beans.Association;
import Beans.Beneficiaire;
import DAO_properties.DAOException;

public interface BeneficiaireInterf {
	

	// Don: class  don: objet 
	Beneficiaire find(int idBeneficiaire) throws DAOException;	 
	List<Beneficiaire> getAllBeneficiaire() throws DAOException ;
	 List<Beneficiaire> getAllBeneficiaireAsso() throws DAOException ;	 
	 void addBeneficiaire(String  nomBenefi, String prenomBenefi, String login,String password, int numTel,String adresse,String genre,String dateNaissance) throws DAOException;
	 
	 void suppBeneficiaire(int idBeneficiaire) throws DAOException ;
	 void modifBeneficiaire(String  nomBenefi, String prenomBenefi, String login,String password,int  numTel,String adresse,String genre,String dateNaissance ,int idAsso_benef,int idBeneficiaire) throws DAOException ;
	  public boolean Check_login_benef(String login, String password);
	  Beneficiaire getBeneficiaireByLogin(String login);
	  
	  
}
