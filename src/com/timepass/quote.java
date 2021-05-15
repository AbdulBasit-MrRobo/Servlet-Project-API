package com.timepass;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class quote
 */
@WebServlet("/quote")
public class quote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpResponse<String> res = null;
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://quotejoy.p.rapidapi.com/random"))
				.header("x-rapidapi-key", "2ac0482d53msh1ebd4bcb1a9053cp14faaejsn381821dfdd79")
				.header("x-rapidapi-host", "quotejoy.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		PrintWriter out = response.getWriter();
		
		try {
			res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		String[] data = res.body().split("\"");
		out.println("<html><head><link rel=\"stylesheet\" href=\""+request.getContextPath().toString()+"/style.css\"></head>");
		out.println("<body><span class=\"background-container\"><div class=\"stars\"></div>\r\n"
				+ "<div class=\"twinkling\"></div></span>");
		out.println();
		out.println("<div class=\"container\"> \"<a href=\""+request.getContextPath().toString()+"/index.html\">Back</a><div class=\"quote\"><p>" + data[13]+"</p></div></div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
