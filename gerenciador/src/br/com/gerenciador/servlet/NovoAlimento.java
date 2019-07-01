package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovoAlimento
 */
@WebServlet(urlPatterns = "/novoalimento")
public class NovoAlimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter resp = response.getWriter();
		String nomeAlimento = request.getParameter("nome");
		

		resp.println("<html>");
		resp.println("<body>");
		resp.println("Olá alimento !");
		resp.println("</body>");
		resp.println("</html>");
		
		System.out.println("Alimento a ser gravado: "+ nomeAlimento);
		
		
	}

}
