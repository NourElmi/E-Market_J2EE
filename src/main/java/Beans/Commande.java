package Beans;

import java.util.Date;

public class Commande {
	
	private int idCommande;
	private int montantCommande;
	private String modePaiement;
	private String commantaire;
	private Date dateCommande;
	private int idClient_Com;
	private int etatCommande=0;
	
	
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getMontantCommande() {
		return montantCommande;
	}
	public void setMontantCommande(int montantCommande) {
		this.montantCommande = montantCommande;
	}
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public String getCommantaire() {
		return commantaire;
	}
	public void setCommantaire(String commantaire) {
		this.commantaire = commantaire;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public int getIdClient_Com() {
		return idClient_Com;
	}
	public void setIdClient_Com(int idClient_Com) {
		this.idClient_Com = idClient_Com;
	}
	public int getEtatCommande() {
		return etatCommande;
	}
	public void setEtatCommande(int etatCommande) {
		this.etatCommande = etatCommande;
	}
	
	

}
