package web;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;


/**
 * Servlet implementation class ajouterAbonn
 */
public class ajouterProdADonner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public static final int TAILLE_TAMPON = 10240;
	 public static final String CHEMIN_FICHIERS = "/Users/nour-elmi/Desktop/S3/Proj_JEE/AssoMarketImages";
	
	private DAOFactory daoFactory ;

	private ProdADonnerDAO ProdADonnerDAo;
       
   
    public ajouterProdADonner() {
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
    	this.ProdADonnerDAo= daoFactory.getProdADonnerDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);  		
		int idAsso_Prod = (int) session.getAttribute("IdAsso");
		
		PrintWriter out = response.getWriter();
		String lib_Prod =request.getParameter( "lib_Prod" ) ;
		String descProd = request.getParameter( "descProd" ) ;
		String image = request.getParameter( "image" );
		String DateAjout = request.getParameter( "dateAjout" );
//		File img = new File(request.getParameter( "image" ));
//		FileInputStream input = new FileInputStream(request.getParameter( "image" ));
		
//		out.println(lib_Prod + image );	
//		out.println(lib_Prod + DateAjout );	
		ProdADonnerDAo.addProdADonner(lib_Prod, descProd, image, DateAjout, idAsso_Prod);
			
			
			
			response.sendRedirect("/AssociationMarket/allProdADonner");
		
			
		
		
		
		
		
//		this.getServletContext().getRequestDispatcher("/allProdADonner").forward( request, response );
		
	}
	
//	private static String getNomFichier( Part part ) {
//        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
//            if ( contentDisposition.trim().startsWith( "filename" ) ) {
//                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
//            }
//        }
//        return null;
//    }   

}
