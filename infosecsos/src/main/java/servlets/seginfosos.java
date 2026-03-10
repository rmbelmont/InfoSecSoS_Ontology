package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;



public class seginfosos extends HttpServlet {
	
 
	private static final long serialVersionUID = 1L;
	sosmb sosmb = new sosmb();
	Principal principal = new Principal();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> resposta = new ArrayList<String>();
		try {
			
		//	resposta = sosmb.FatoresEspecificos2();
			resposta = principal.FatoresEspecificos();
			//resposta = sosmb.retornarResposta();
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.getWriter().print(resposta );
	}
	}

	