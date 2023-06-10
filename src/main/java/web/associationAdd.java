package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.AssociationInterf;
import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class associationAdd
 */
public class associationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public static final int TAILLE_TAMPON = 10240;
	 public static final String CHEMIN_FICHIERS = "/Users/nour-elmi/Desktop/S3/Proj_JEE/AssoMarketImages";
	
	private DAOFactory daoFactory ;

	private AssociationInterf associationInterf;
      
  
   public associationAdd() {
       super();
       // TODO Auto-generated constructor stub
   }

   /**
    * Cette method est appele au moment du chargement de la servlet avant meme la method doGet ou la method doPost 
    * cette meth va creer un objet DAOFactory qui sera connecter BD
    */ 
   public void init() throws ServletException 
   {
   	this.daoFactory = DAOFactory.getInstance();
   	this.associationInterf= daoFactory.getAssociationInterf();
   }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String nomAsso =request.getParameter( "nomAsso" ) ;
		String secteur = request.getParameter( "secteur" ) ;
		String nomRespo = request.getParameter( "nomRespo" );
		String prenomRespo = request.getParameter( "prenomRespo" );
		String email =request.getParameter( "email" ) ;
		String password = request.getParameter( "password" ) ;
		String telephoneAsso = request.getParameter( "telephoneAsso" );
		String ville = request.getParameter( "ville" );
		String localisation =request.getParameter( "localisation" ) ;
		int nbrJourRecuProd = Integer.parseInt(request.getParameter( "nbrJourRecuProd" )) ;
		out.println("dcfvrgyjuki");	
		associationInterf.insertAssociation(nomAsso,secteur,nomRespo, prenomRespo,email, password, telephoneAsso, ville, localisation,nbrJourRecuProd );
		out.println(nomAsso +"     "+ secteur+"     "+nomRespo+"     "+ prenomRespo+"     "+email+"     "+password+"     "+ telephoneAsso+"     "+ ville+"     "+ localisation+"     "+nbrJourRecuProd);	
//		response.sendRedirect("/AssociationMarket/associationDashboard");
		
		
		
			
		
		
		
		
		
//		this.getServletContext().getRequestDispatcher("/allProdADonner").forward( request, response );
		
	}
	
//	private static String getNomFichier( Part part ) {
//       for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
//           if ( contentDisposition.trim().startsWith( "filename" ) ) {
//               return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
//           }
//       }
//       return null;
//   }   


}
