package Beans;

import java.util.Date;

public class Demande {
	
	private int  idDemande;
	private Date dateDemande;
	private int  idBenef_demande;
	private int  idProd_Demande;
    private int etatDemande=0;
	
	
	public int getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public int getIdBenef_demande() {
		return idBenef_demande;
	}
	public void setIdBenef_demande(int idBenef_demande) {
		this.idBenef_demande = idBenef_demande;
	}
	public int getIdProd_Demande() {
		return idProd_Demande;
	}
	public void setIdProd_Demande(int idProd_Demande) {
		this.idProd_Demande = idProd_Demande;
	}
	public int getEtatDemande() {
		return etatDemande;
	}
	public void setEtatDemande(int etatDemande) {
		this.etatDemande = etatDemande;
	}
}

