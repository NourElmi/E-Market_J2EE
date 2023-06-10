package web;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Beans.ProdADonnerBean;
import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;


/**
 * Servlet implementation class modifierProdADonner
 */
public class modifierProdADonner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;
	private ProdADonnerDAO ProdADonnerDAo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public modifierProdADonner() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.ProdADonnerDAo= daoFactory.getProdADonnerDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);  		
		int idAsso_Prod = (int) session.getAttribute("IdAsso");
		int idProduit=Integer.parseInt(request.getParameter("idProduit"));
		String lib_Prod =request.getParameter( "lib_Prod" ) ;
		String descProd = request.getParameter( "descProd" ) ;
		String image = request.getParameter( "image" );
		String DateAjout = request.getParameter( "dateAjout" );

		ProdADonnerDAo.modifProdADonner(lib_Prod, descProd, image, DateAjout, idProduit, idAsso_Prod);
//		PrintWriter out = response.getWriter();
//		out.println(CIN+ prenom + job + ProdADonnerID);	
//		request.getRequestDispatcher("/allProdADonner").forward( request, response );
		response.sendRedirect("/AssociationMarket/allProdADonner");
		
	}

}
