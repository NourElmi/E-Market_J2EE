package Beans;

import java.util.Date;

public class ProdADonnerBean {
	private int idProduit;
	private String lib_Prod;
    private String descProd;
    private String    image;
    private int idAsso_Prod;
    private Date    dateAjout;
    
    
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getLib_Prod() {
		return lib_Prod;
	}
	public void setLib_Prod(String lib_Prod) {
		this.lib_Prod = lib_Prod;
	}
	public String getDescProd() {
		return descProd;
	}
	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getIdAsso_Prod() {
		return idAsso_Prod;
	}
	public void setIdAsso_Prod(int idAsso_Prod) {
		this.idAsso_Prod = idAsso_Prod;
	}
	
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
    
    
   
    
    

}
