package edu.cal.cice.remote;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Obtenerpesona
 */
@WebServlet("/Obtenerpesona")
public class Obtenerpesona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Obtenerpesona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = null;
		
		
		    Persona p = new Persona("Carlos", 23);
		    
		   Gson gson = new Gson();
		   
		   String persona_json = gson.toJson(p);
		   
		   System.out.println("Persona en formato json = "+ persona_json);
		  
		
			response.setContentType("applcation/json");//seteo la respuesta
			response.setStatus(HttpURLConnection.HTTP_OK);//seteo el código http de que ha ido bien la cosa! OK = 200
			
			
			pw = response.getWriter();//obtengo acceso al body
			pw.print(persona_json);//y escribo la puntación
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
