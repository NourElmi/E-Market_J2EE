package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Beans.Beneficiaire;
import Beans.Categorie;
import DAO.BeneficiaireInterf;
import DAO.CategorieInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class CategorieAll
 */
public class CategorieAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private CategorieInterf categorieInterf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieAll() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.categorieInterf= daoFactory.getCategorieInterf();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Categorie> listallCategorie=categorieInterf.getAllCategorie();
		request.setAttribute("listallCategorie", listallCategorie);

		//0n transmet l'objet requete et l'objet reponce a la JSP
		this.getServletContext().getRequestDispatcher("/Admin/categoriAll.jsp").forward( request, response );
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
