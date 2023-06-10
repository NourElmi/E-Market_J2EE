package Beans;

import java.util.Date;

public class Beneficiaire {
	private int  idBeneficiaire;
	private String  nomBenefi;
	private String prenomBenefi;
	private String login;
	private String password;
	private int  numTel;
	private String adresse;
	private String genre;
	private Date dateNaissance;
	private int idAsso_benef;
	
	public int getIdBeneficiaire() {
		return idBeneficiaire;
	}
	public void setIdBeneficiaire(int idBeneficiaire) {
		this.idBeneficiaire = idBeneficiaire;
	}
	public String getNomBenefi() {
		return nomBenefi;
	}
	public void setNomBenefi(String nomBenefi) {
		this.nomBenefi = nomBenefi;
	}
	public String getPrenomBenefi() {
		return prenomBenefi;
	}
	public void setPrenomBenefi(String prenomBenefi) {
		this.prenomBenefi = prenomBenefi;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getIdAsso_benef() {
		return idAsso_benef;
	}
	public void setIdAsso_benef(int idAsso_benef) {
		this.idAsso_benef = idAsso_benef;
	}
	
	
	

}
