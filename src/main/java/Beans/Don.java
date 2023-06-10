package Beans;

import java.util.Date;

public class Don {
	private int idDon;
	private String typeDon;
	private String nbrProd;
	private String categories;
	private String description;
	private Date dateDon;
	private int idClient_don;
	private int idAsso_don;
	
	
	
	public int getIdDon() {
		return idDon;
	}
	public void setIdDon(int idDon) {
		this.idDon = idDon;
	}
	public String getTypeDon() {
		return typeDon;
	}
	public void setTypeDon(String typeDon) {
		this.typeDon = typeDon;
	}
	
	public String getNbrProd() {
		return nbrProd;
	}
	public void setNbrProd(String nbrProd) {
		this.nbrProd = nbrProd;
	}
	
	
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDon() {
		return dateDon;
	}
	public void setDateDon(Date dateDon) {
		this.dateDon = dateDon;
	}
	public int getIdClient_don() {
		return idClient_don;
	}
	public void setIdClient_don(int idClient_don) {
		this.idClient_don = idClient_don;
	}
	public int getIdAsso_don() {
		return idAsso_don;
	}
	public void setIdAsso_don(int idAsso_don) {
		this.idAsso_don = idAsso_don;
	}

}
