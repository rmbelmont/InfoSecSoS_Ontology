package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

/**
 * Servlet implementation class infosecsos_main
 */
@WebServlet("/infosecsos_main")
public class infosecsos_main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Principal principal = new Principal();
	
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		List<String> resposta = new ArrayList<String>();
   		List<String> resposta1 = new ArrayList<String>();
   		List<String> resposta2 = new ArrayList<String>();
   		String Cryptography = "Cryptography_PrivateKey_RSA";
   		String Algorithm = "Carlo";
   		String r = null;
   		try {
			resposta = principal.Criptografia();
			resposta1 = Principal.buscarCriptografiaPorNome(resposta, Cryptography);
			//resposta1 = Principal.buscarCriptografiaPorNome(resposta, Algorithm);
			for (String s : resposta1) {
				 r = s;
			}
		} catch (OWLOntologyCreationException e) {
			
			e.printStackTrace();
		}
   		
   		response.getWriter().print(r);
	}



}
