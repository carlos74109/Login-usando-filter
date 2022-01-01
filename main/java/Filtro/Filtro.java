package Filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/principal/*")
public class Filtro implements Filter {

    public Filtro() {  
    }

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String UsuarioLogado = (String) session.getAttribute("usuario");
		String urlPraAutenticar = req.getServletPath();
		
		System.out.println("cheguei");
		if(UsuarioLogado == null && !urlPraAutenticar.contains("/principal/ServletLogando")) {
			System.out.println("cheguei de novo");
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("redirecionar.jsp");
			redirecionar.forward(request, response);
			return;
		}else {
			chain.doFilter(request, response);
			
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
