package DAO;

import java.util.List;

import Beans.Client;
import DAO_properties.DAOException;

public interface ClientInterf {
	
	 public void insertClient(String nomAsso,String secteur,String nomRespo,String prenomRespo,String email,String password,String telephoneAsso,String ville,String localisation,int nbrJourRecuProd);
	  public boolean Check_login_Client(String email, String password);
	  boolean updateClient(ClientInterf ass);
	  Client getClientByEmail(String email);
	  ClientInterf getClientById(int id);

	void addClient(String  nomBenefi, String prenomBenefi, String login,String password, int numTel,String adresse,String genre,String dateNaissance) throws DAOException;
	List<Client> getAllClient() throws DAOException ;
}
