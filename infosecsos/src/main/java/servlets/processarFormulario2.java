package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class processarFormulario2 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
    	 ArrayList<String> resposta = new ArrayList<>();
  	   //  String resposta1 = null;
  	      List<String> resposta1 = null;
        res.setContentType("text/html");
        String algoritmo = req.getParameter("algoritmo");
       if (algoritmo == "") {
            algoritmo = "vazio";
       }
       Principal principal = new Principal();
       
        
        try {
			resposta1 =  principal.FatoresEspecificos();
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        final PrintWriter printWriter = res.getWriter();
        printWriter.print("<html>");
        printWriter.print("<head>");
        printWriter.print("</head>");
        printWriter.print("<body>");
        printWriter.print("<table>");
        printWriter.print("<thead>");
        printWriter.print("<tr>");
        printWriter.print("<tr>");
        printWriter.print("</thead>");
        printWriter.print("<tbody>");
       // printWriter.print("<td><font face=arial color=red size=2>" + resposta + "</font>" + "<br>" + "</td>");
        printWriter.print("<td><font face=arial color=red size=2>" + resposta + "</font>" + "<br>" + "</td>");
        printWriter.print("</tbody>");
        printWriter.print("</table>");
        printWriter.print("</body>");
        printWriter.print("</html>");
      //  res.getWriter().print(resposta1);
        
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/greet.jsp");
        requestDispatcher.include((ServletRequest)req, (ServletResponse)res);
        printWriter.close();
    }
}



