package ServletLogar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Modelo;


@WebServlet(urlPatterns= {"/ServletLogando", "/principal/ServletLogando"})
public class ServletLogando extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletLogando() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			Modelo modeloLogin = new Modelo();
			modeloLogin.setLogin(login);
			modeloLogin.setSenha(senha);
			
			
			
			if(modeloLogin.getLogin().equals("carlos") && modeloLogin.getSenha().equals("1234")) {
				
				request.setAttribute("usuario", modeloLogin.getLogin());
				
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/principal.jsp");
				request.setAttribute("msg", "oi "+ modeloLogin.getLogin());
				redirecionar.forward(request, response);
			}else {
				System.out.println("caindo aqui");
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "seu login ou senha estão errados");
				redirecionar.forward(request, response);
			}
			
			
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "Adicione seu usuario e senha");
			redirecionar.forward(request, response);
		}
		
	}

}
