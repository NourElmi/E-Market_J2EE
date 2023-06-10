package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Beans.Association;
import Beans.Don;
import DAO.AssociationInterf;
import DAO.DonInterf;
import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class donAdd
 */
public class donAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public static final int TAILLE_TAMPON = 10240;
	 
		private DAOFactory daoFactory ;

		private DonInterf donInterf;
		private AssociationInterf associationInterf;
		
		 		
    public donAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.donInterf= daoFactory.getDonInterf();
    	this.associationInterf= daoFactory.getAssociationInterf();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Association> listAllAssociation=associationInterf.getAllAssociation();
		request.setAttribute("listAllAssociation", listAllAssociation);

		//0n transmet l'objet requete et l'objet reponce a la JSP
		this.getServletContext().getRequestDispatcher("/Client/ajouterDon.jsp").forward( request, response );
//		response.sendRedirect(" /allProdADonner.jsp ");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);  		
		int idClient_don = (int) session.getAttribute("IdClient");
		
		PrintWriter out = response.getWriter();
		String typeDon =request.getParameter( "typeDon" ) ;
		String nbrProd =request.getParameter( "nbrProd" ) ;
		String categories =request.getParameter( "categories" ) ;
		String description =request.getParameter( "description" ) ;
		String dateDon =request.getParameter( "dateDon" ) ;
		int idAsso_don = Integer.parseInt(request.getParameter( "idAsso_don" ) );
		
//		int idAsso_don =Integer.parseInt(request.getParameter( "idAsso_don" ) );
		//out.println(typeDon+"   " +nbrProd+ "   " +categories+ "   " +description + "   " +dateDon);
		donInterf.addDon(typeDon, nbrProd, categories, description,dateDon,idClient_don, idAsso_don);
		
		
		
		response.sendRedirect("/AssociationMarket/donAllClient");
	
		
	}

}
