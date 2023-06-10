package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Beans.Association;
import DAO.AssociationInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class assocaiationAll
 */
public class allMesAsso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssociationInterf associationInterf;
	private DAOFactory daoFactory ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public allMesAsso() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.associationInterf= daoFactory.getAssociationInterf();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Association> listAllAssociation=associationInterf.getAllAssociation();
		request.setAttribute("listAllAssociation", listAllAssociation);

		//0n transmet l'objet requete et l'objet reponce a la JSP
		this.getServletContext().getRequestDispatcher("/AssociationMarket/Admin/associationAll.jsp").forward( request, response );
//		response.sendRedirect(" /allProdADonner.jsp ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
