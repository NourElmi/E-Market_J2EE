package Beans;

import java.util.Date;

public class ProduitVente extends ProdADonnerBean{
	
	private int idProdVente;
	private String lib_Prod;
    private String descProd;
    private int idAsso_ProdVente;
    private Date    dateAjout;
    private String    image;
	private int prix;
	private String couleur;	
	private String taille;
	private String nbrprodstock;
	private int idCategorie_ProdVen;
	private int referenceProd ;    
		
	public int getIdCategorie_ProdVen() {
		return idCategorie_ProdVen;
	}
	public void setIdCategorie_ProdVen(int idCategorie_ProdVen) {
		this.idCategorie_ProdVen = idCategorie_ProdVen;
	}
	public int getIdProdVente() {
		return idProdVente;
	}
	public void setIdProdVente(int idProdVente) {
		this.idProdVente = idProdVente;
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
	public int getIdAsso_ProdVente() {
		return idAsso_ProdVente;
	}
	public void setIdAsso_ProdVente(int idAsso_ProdVente) {
		this.idAsso_ProdVente = idAsso_ProdVente;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public String getNbrprodstock() {
		return nbrprodstock;
	}
	public void setNbrprodstock(String nbrprodstock) {
		this.nbrprodstock = nbrprodstock;
	}
	public int getReferenceProd() {
		return referenceProd;
	}
	public void setReferenceProd(int referenceProd) {
		this.referenceProd = referenceProd;
	}
		
		
		
	}



