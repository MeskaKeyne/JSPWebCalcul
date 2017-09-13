package be.steformations.af.javaweb.calcul.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.steformations.af.javaweb.calcul.model.Calcul;
import be.steformations.af.javaweb.calcul.model.GestionnaireCalcul;

public class Controleur extends javax.servlet.http.HttpServlet{
	

	private GestionnaireCalcul gestionnaire;

	
	// appelée 1 seule fois , juste après l'instantiation
	
	public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException{
		super.init(config);
		int niveau = Integer.parseInt(config.getInitParameter("niveau"));
		this.gestionnaire = new GestionnaireCalcul(niveau);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*¨faire travailler le model
		 */
		
		Calcul c = this.gestionnaire.genererCalcul();
		System.out.println("Controleur.doGet() ==> " + c );
		//insérer le calcul dans le contexte
		
		req.setAttribute("nouveauCalcul", c); // dans l'objet request pour le jsp
		req.getSession().setAttribute("sessionCalcul", c); // en session pour l'uitilisateur
		
		
		// invoquer une page JSP
		
		req.getRequestDispatcher("/nouveau.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("controleur.doPost()");
		
		/*analyse de la validation de la requete */
		
		String parametre = req.getParameter("proposition"); //nom de l'input dans le formulaire 
		int proposition =  -1;
		
		try{
			proposition = Integer.parseInt(parametre);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*¨faire travailler le model*/
		Calcul c = (Calcul) req.getSession().getAttribute("sessionCalcul");
		if (c != null) {
		this.gestionnaire.verifierSolution(c, proposition);
		req.setAttribute("nouveauCalcul", c);
		req.getRequestDispatcher("/resultat.jsp").forward(req, resp);
		}else{
			this.doGet(req, resp);
		}
	}
}
