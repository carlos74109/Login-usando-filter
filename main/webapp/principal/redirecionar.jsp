<%
	//response.sendRedirect("../index.jsp");
	RequestDispatcher redirecionar = request.getRequestDispatcher("../index.jsp");
	request.setAttribute("msg", "n�o tente acessar pela url");
	redirecionar.forward(request, response);
%>