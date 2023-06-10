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

import Beans.Demande;
import Beans.ProduitVente;
import DAO.DemandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class demandeByAsso
 */
public class demandeByAsso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private DemandeInterf demandeInterf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demandeByAsso() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.demandeInterf= daoFactory.getDemandeInterf();
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idProd_Demande =Integer.parseInt(request.getParameter( "idProd_Demande" )) ;
		
		HttpSession session = request.getSession(false);  		
		int idAsso_Prod = (int) session.getAttribute("IdAsso");


		
//	out.println(idCategorie_ProdVen);	
		List listallDemandeByAsso_Prod_Benef=demandeInterf.getAllDemandeByDate(idProd_Demande, idAsso_Prod );
		request.setAttribute("listallDemandeByAsso_Prod_Benef", listallDemandeByAsso_Prod_Benef);
		
		//Demande demande = new Demande();
		//PrintWriter out = response.getWriter();
		//out.println(idProd_Demande);	

		//0n transmet l'objet requete et l'objet reponce a la JSP		
		this.getServletContext().getRequestDispatcher("/Association/demandeByAsso.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
