<%
	//response.sendRedirect("../index.jsp");
	RequestDispatcher redirecionar = request.getRequestDispatcher("../index.jsp");
	request.setAttribute("msg", "não tente acessar pela url");
	redirecionar.forward(request, response);
%>