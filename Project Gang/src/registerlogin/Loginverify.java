package registerlogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import database.User;

/**
 * Servlet implementation class Loginverify
 */
@WebServlet("/Loginverify")
public class Loginverify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		Database obj=new Database();
		if( obj.userlogin(uname, pass) )
		{
			User uob=obj.Getdatail();
			HttpSession ts=request.getSession();
			ts.setAttribute("uob", uob);
			response.sendRedirect("useroption.jsp");
		}
		else
		{
			request.setAttribute("msg", "Username or Password not Match !");
			request.setAttribute("link", "login.html");
			request.setAttribute("bname", "Continue");
			request.setAttribute("color", "red");
		
			RequestDispatcher rd=request.getRequestDispatcher("msg.jsp");
			rd.forward(request, response);	
		}
	}

}
