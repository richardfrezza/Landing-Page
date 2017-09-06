package com.frezza.richard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/contatos")
public class ContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ContatoDao dao = new ContatoDao();
    
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contato contato = new Contato();
        contato.parse(Utils.parseMap(req));
        dao.insert(contato);
    }
  
}
