package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Beans.ProdADonnerBean;
import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class add
 */
public class findProdADonner extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;
	private ProdADonnerDAO ProdADonnerDAo;
       
    public findProdADonner() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.ProdADonnerDAo= daoFactory.getProdADonnerDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idProduit =Integer.parseInt(request.getParameter("idProduit"));
		
		ProdADonnerBean ProdADonner = ProdADonnerDAo.find(idProduit);
		request.setAttribute("ProdADonner", ProdADonner);
//		PrintWriter out = response.getWriter();
//		out.println(CIN);
		this.getServletContext().getRequestDispatcher("/ProdADonner/modifierProdADonner.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}
	
	

}
