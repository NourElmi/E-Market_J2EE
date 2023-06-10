package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import DAO.ProdADonnerDAO;
import DAO.ProduitVenteInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class produitVenteAdd
 */
public class produitVenteAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
public static final int TAILLE_TAMPON = 10240;
			 
	
	private DAOFactory daoFactory ;

	private ProduitVenteInterf produitVenteInterf;
	
    public produitVenteAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.produitVenteInterf= daoFactory.getProduitVenteInterf();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//out.println(   );
		//out.println( "lib_Prod"+" "+lib_Prod+" "+"descProd"+" "+descProd+" "+"dateAjout"+" "+dateAjout+" "+"image"+" "+image+" "+"prix"+" "+prix+"couleur"+" "+couleur+" "+"taille"+" "+taille+" "+"nbrprodstock"+" "+nbrprodstock);	
		
		String lib_Prod =request.getParameter( "lib_Prod" ) ;
		String descProd = request.getParameter( "descProd" ) ;
		int idAsso_ProdVente = Integer.parseInt(request.getParameter("idAsso_ProdVente"));
		String dateAjout = request.getParameter( "dateAjout" );
		String image =request.getParameter( "image" ) ;		
		int prix =Integer.parseInt(request.getParameter( "prix" )) ;
		String couleur =request.getParameter( "couleur" ) ;
		String taille =request.getParameter( "taille" ) ;
		String nbrprodstock =request.getParameter( "nbrprodstock" ) ;
		int idCategorie_ProdVen = Integer.parseInt(request.getParameter("idCategorie_ProdVen"));
		int referenceProd= Integer.parseInt(request.getParameter("idCategorie_ProdVen"));
		String cheminProdVente = this.getServletConfig().getInitParameter("cheminProdVente");
		
		/**
	     * Les données reçues sont multipart, on doit donc utiliser la méthode
	     * getPart() pour traiter le champ d'envoi de fichiers.
	     */
		Part part = request.getPart("image");
		
		/**
		 * Il faut déterminer s'il s'agit d'un champ classique 
		 * ou d'un champ de type fichier : on délègue cette opération 
		 * à la méthode utilitaire getNomFichier().
		 */
		String nomFichier = getNomFichier( part );
		  if ( nomFichier == null ) 
		  {
			        /* La méthode a renvoyé null, il s'agit donc d'un champ classique ici (input type="text|radio|checkbox|etc", select, etc). */
			        String nomChamp = part.getName();
			        /* Récupération du contenu du champ à l'aide de notre nouvelle méthode */
			        String valeurChamp = getValeur( part );			        
			        request.setAttribute( nomChamp, valeurChamp );
			       
		  } else if ( !nomFichier.isEmpty() ) 
		  {
					/**
				     * Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ
				     * de type fichier (input type="file").
				     */
				    if ( nomFichier != null && !nomFichier.isEmpty() ) 
				    {
					        String nomChamp = part.getName();
					        String valeurChamp = getValeur( part );			
					        /*
					         * Antibug pour Internet Explorer, qui transmet pour une raison
					         * mystique le chemin du fichier local à la machine du client...
					         * 
					         * Ex : C:/dossier/sous-dossier/fichier.ext
					         * 
					         * On doit donc faire en sorte de ne sélectionner que le nom et
					         * l'extension du fichier, et de se débarrasser du superflu.
					         */
					        nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 ).substring( nomFichier.lastIndexOf( '\\' ) + 1 );			
					        /* Écriture du fichier sur le disque */
					        ecrireFichier( part, nomFichier, cheminProdVente );		
					        request.setAttribute( nomChamp, nomFichier );
					        
				    }
		   }
		produitVenteInterf.addProduitVente(lib_Prod, descProd,idAsso_ProdVente,image,dateAjout, prix, couleur,taille,nbrprodstock, idCategorie_ProdVen, referenceProd);	
		response.sendRedirect("/AssociationMarket/produitVenteAdd");
//		this.getServletContext().getRequestDispatcher("/allProdADonner").forward( request, response );
		
		
	
	}
	
	
	//****************** End of doPost() ******************

	

		/**
		 * Méthode utilitaire qui a pour unique but d'analyser l'en-tête "content-disposition",
		 * et de vérifier si le paramètre "filename"  y est présent. Si oui, alors le champ traité
		 * est de type File et la méthode retourne son nom, sinon il s'agit d'un champ de formulaire 
		 * classique et la méthode retourne null. 
		 */
		private static String getNomFichier( Part part ) 
		{
		    /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
		    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
		        /* Recherche de l'éventuelle présence du paramètre "filename". */
		        if ( contentDisposition.trim().startsWith("filename") ) 
		        {
		            /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier sans guillemets. */
	            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
		        }
		    }
		    /* Et pour terminer, si rien n'a été trouvé... */
		    return null;
		}
		
		/**
		 * Méthode utilitaire qui a pour unique but de lire l'InputStream contenu
		 * dans l'objet part, et de le convertir en une banale chaîne de caractères.
		 */
		private String getValeur( Part part ) throws IOException {
			
		    BufferedReader reader = new BufferedReader( new InputStreamReader( part.getInputStream(), "UTF-8" ) );
		    StringBuilder valeur = new StringBuilder();
		    char[] buffer = new char[1024];
		    int longueur = 0;
		    while ( ( longueur = reader.read( buffer ) ) > 0 ) {
		        valeur.append( buffer, 0, longueur );
		    }
		    
		    return valeur.toString();
		}
		
		
		/**
		 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
		 * sur le disque, dans le répertoire donné et avec le nom donné.
		 */
		private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
			/* Prépare les flux. */
		    BufferedInputStream entree = null;
		    BufferedOutputStream sortie = null;
		    try {
		        /* Ouvre les flux. */
		        entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
		        sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ), TAILLE_TAMPON );
		 
		        /*
		         * Lit le fichier reçu et écrit son contenu dans un fichier sur le
		         * disque.
		         */
		        byte[] tampon = new byte[TAILLE_TAMPON];
		        int longueur;
		        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
		            sortie.write( tampon, 0, longueur );
		        }
		    } finally {
		        if (sortie != null){
		            try {
		                sortie.close();
		            } catch ( IOException e ) {
		                 e.printStackTrace();
		            }
		        }
		        if(entree != null){
		            try {
		                entree.close();
		            } catch ( IOException e ) {
		             e.printStackTrace();
		           }
		        }
		    }
		}

	}
