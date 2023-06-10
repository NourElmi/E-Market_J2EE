package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import Beans.Don;
import DAO.DonInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class donAllClient
 */
public class donAllClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private DonInterf donInterf;
       
   
    public donAllClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.donInterf= daoFactory.getDonInterf();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);  		
		int idClient_don = (int) session.getAttribute("IdClient");
		
				List<Don> listallDonClient=donInterf.getAllDonClient(idClient_don);
				request.setAttribute("listallDonClient", listallDonClient);

				//0n transmet l'objet requete et l'objet reponce a la JSP
				this.getServletContext().getRequestDispatcher("/Client/allDonClient.jsp").forward( request, response );
//				response.sendRedirect(" /allProdADonner.jsp ");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
