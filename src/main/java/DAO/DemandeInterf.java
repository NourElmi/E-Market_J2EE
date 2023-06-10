package DAO;

import java.util.Date;
import java.util.List;

import Beans.Demande;

import DAO_properties.DAOException;

public interface DemandeInterf {
	
	void addDemande( String dateDemande, int  idBenef_demande,int  idProd_Demande) throws DAOException;
	 List getAllDemandeByDate(int idProd_Demande,int idAsso_Prod) throws DAOException ;

	 void accepterDemande(int idDemande) throws DAOException ;
}
