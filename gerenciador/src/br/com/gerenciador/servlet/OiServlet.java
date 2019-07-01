package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter resp = response.getWriter();
		resp.println("<html>");
		resp.println("<body>");
		resp.println("Olá mundo !");
		resp.println("</body>");
		resp.println("</html>");
	}

	
}
