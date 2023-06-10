package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Beans.ProduitVente;

import DAO.ProduitVenteInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class produitVenteFind
 */
public class produitVenteFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private DAOFactory daoFactory ;
	private ProduitVenteInterf produitVenteInterf;
       
    public produitVenteFind() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.produitVenteInterf= daoFactory.getProduitVenteInterf();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int referenceProd =Integer.parseInt(request.getParameter("referenceProd"));
//		PrintWriter out = response.getWriter();
//		out.println(referenceProd);
		List<ProduitVente> listProduitVenteByRef = produitVenteInterf.findProdVentByRef(referenceProd);
		request.setAttribute("listProduitVenteByRef", listProduitVenteByRef);
		
		this.getServletContext().getRequestDispatcher("/ProduitVente/produitVenteDetails.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}
}
