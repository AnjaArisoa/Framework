
package etu2007.framework.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import etu2007.framework;



public class FrontServlet extends HttpServlet{
    HashMap<String,Mapping> mappingsUrl;
	
	public HashMap<String, Mapping> getMappingsUrl() {
		return mappingsUrl;
	}

	public void setMappingsUrl(HashMap<String, Mapping> mappingsUrl) {
		this.mappingsUrl = mappingsUrl;
	}
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        PrintWriter out = resp.getWriter();
        String requete = req.getRequestURI();
        String valeur = req.getQueryString();
        String[] info = requete.split("/"); 
        out.println("Page: " + info[2]);
        out.println("Les donnees sont:");
        String[] valiny = valeur.split("&&");
        for (String rep : valiny) {
           out.println(rep); 
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}