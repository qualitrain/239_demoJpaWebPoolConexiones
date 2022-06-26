package qtx.web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qtx.jpa.dominio.Persona;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory fabrica = null; 
	private EntityManager em = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	this.fabrica = Persistence.createEntityManagerFactory("bdPuntoDeVenta");
		this.em = this.fabrica.createEntityManager();
    	
    }
    @Override
    public void destroy() {
    	if(this.em != null)
    		this.em.close();
    	super.destroy();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		sesion.removeAttribute("mensaje");
		sesion.removeAttribute("persona");
		
		if(request.getParameterMap().isEmpty()) {
			response.sendRedirect("getId.jsp");
			return;
		}
		
		
		String cadId = request.getParameter("idPersona");
		if(cadId.trim().isEmpty()) {
			sesion.setAttribute("mensaje", "El id de la persona es necesario!");
			response.sendRedirect("getId.jsp");
			return;
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(cadId);
		}
		catch (NumberFormatException ex) {
			sesion.setAttribute("mensaje", "El id de la persona debe ser num&eacute;rico");
			response.sendRedirect("getId.jsp");
			return;
		}
	    Persona unaPersona = em.find(Persona.class, id);
	    if(unaPersona != null) {
			sesion.setAttribute("persona", unaPersona);
			response.sendRedirect("Persona.jsp");
			return;	    	
	    }
	    else {
			sesion.setAttribute("mensaje", "No existe una persona con ese Id en la base de datos");
			response.sendRedirect("getId.jsp");
			return;	    	
	    }
		
	}

}
