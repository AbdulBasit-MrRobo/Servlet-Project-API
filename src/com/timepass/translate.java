package com.timepass;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class translate
 */
@WebServlet("/translate")
public class translate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public translate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpResponse<String> res = null;
		
		
		String language=request.getParameter("translateApi");
		String message=request.getParameter("message");
		message = message.replace(" ", "%20");
		PrintWriter out = response.getWriter();
		if(language.equals("Mandalorian")) {
			HttpRequest req = HttpRequest.newBuilder()
					.uri(URI.create("https://api.funtranslations.com/translate/mandalorian.json?text="+message.toString()))
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			try {
				res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}else if(language.equals("Sith")) {
			HttpRequest req = HttpRequest.newBuilder()
					.uri(URI.create("https://api.funtranslations.com/translate/sith.json?text="+message))
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			try {
				res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}else if(language.equals("Yoda")) {
			HttpRequest req = HttpRequest.newBuilder()
					.uri(URI.create("https://api.funtranslations.com/translate/yoda.json?text="+message))
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			try {
				res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}else if(language.equals("Minion")) {
			HttpRequest req = HttpRequest.newBuilder()
					.uri(URI.create("https://api.funtranslations.com/translate/minion.json?text="+message))
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			try {
				res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}else if(language.equals("Shakespeare")) {
			HttpRequest req = HttpRequest.newBuilder()
					.uri(URI.create("https://api.funtranslations.com/translate/shakespeare.json?text="+message))
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			try {
				res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}else if(language.equals("Groot")) {
			HttpRequest req = HttpRequest.newBuilder()
					.uri(URI.create("https://api.funtranslations.com/translate/groot.json?text="+message))
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			try {
				res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		String[] data = res.body().split("\"");
		out.println("<html><head><link rel=\"stylesheet\" href=\""+request.getContextPath().toString()+"/style.css\"></head>");
		out.println("<body><span class=\"background-container\"><div class=\"stars\"></div>\r\n"
				+ "<div class=\"twinkling\"></div></span>");
		out.println();
		out.println("<div class=\"container\"> \"<a href=\""+request.getContextPath().toString()+"/index.html\">Back</a><div class=\"quote\"><p>" + data[9]+"</p></div></div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
