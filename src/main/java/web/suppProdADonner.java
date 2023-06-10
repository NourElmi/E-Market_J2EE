package web;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import beans.ProdADonnerBean;

import java.io.IOException;

import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;


/**
 * Servlet implementation class suppFreelanceer
 */
public class suppProdADonner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;
	private ProdADonnerDAO ProdADonnerDAo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suppProdADonner() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.ProdADonnerDAo= daoFactory.getProdADonnerDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		ProdADonnerDAo.suppProdADonner(idProduit);
//		request.getRequestDispatcher("allProdADonner").forward( request, response );
		response.sendRedirect("/AssociationMarket/allProdADonner");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
