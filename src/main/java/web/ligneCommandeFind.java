package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Beans.LigneCommande;
import DAO.LigneCommandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class ligneCommandeFind
 */
public class ligneCommandeFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private DAOFactory daoFactory;

	  private LigneCommandeInterf ligneCommandeInterf;
	  
    public ligneCommandeFind() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
       	this.daoFactory = DAOFactory.getInstance();
    	this.ligneCommandeInterf= daoFactory.getLigneCommandeInterf();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int idLigneCom =Integer.parseInt(request.getParameter("idLigneCom"));
		int idLigneCom=1;
		LigneCommande ligneCommande = ligneCommandeInterf.find(idLigneCom);
		request.setAttribute("ligneCommande", ligneCommande);
	PrintWriter out = response.getWriter();
	out.println(ligneCommande.getQuantite());
		//this.getServletContext().getRequestDispatcher("/ligneCommandeModif.jsp").forward( request, response );
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
