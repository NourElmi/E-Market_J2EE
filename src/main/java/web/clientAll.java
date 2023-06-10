package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Beans.Categorie;
import Beans.Client;
import DAO.CategorieInterf;
import DAO.ClientInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class clientAll
 */
public class clientAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private DAOFactory daoFactory ;

	private ClientInterf clientInterf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientAll() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.clientInterf= daoFactory.getClientInterf();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Client> listallClient=clientInterf.getAllClient();
		request.setAttribute("listallClient", listallClient);

		//0n transmet l'objet requete et l'objet reponce a la JSP
		this.getServletContext().getRequestDispatcher("/Admin/clientAll.jsp").forward( request, response );
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
