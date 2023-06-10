package DAO;

import Beans.Admin;
import Beans.Beneficiaire;
import DAO_properties.DAOException;

public interface AdminInterf {
	
	public void create(Admin admin) throws DAOException;
	 
	
	public boolean Check_login_Admin(String login, String password);
	 Admin getAdminByLogin(String login);

	 void suppAdmin(int idAdmin) throws DAOException ;
	 void modifAdmin(String  nomBenefi, String prenomBenefi, String login,String password,int  numTel,String adresse,String genre,String dateNaissance ,int idAsso_benef,int idAdmin) throws DAOException ;
	

}
