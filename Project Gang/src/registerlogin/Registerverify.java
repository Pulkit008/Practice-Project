package registerlogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import database.User;

@WebServlet("/Registerverify")
public class Registerverify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		Database obj=new Database();
		if( obj.checkuser(uname))
		{
			request.setAttribute("msg", "Username Already Exist !");
			request.setAttribute("link", "register.html");
			request.setAttribute("bname", "Try Again");
			request.setAttribute("color", "red");
		
			RequestDispatcher rd=request.getRequestDispatcher("msg.jsp");
			rd.forward(request, response);
		}
		else
		{
			User u=new User();
			u.setName(name);
			u.setUsername(uname);
			u.setPassword(pass);
			if(obj.insert(u))
			{
				request.setAttribute("msg", "Registration Successful !");
				request.setAttribute("link", "index.html");
				request.setAttribute("bname", "Continue");
				request.setAttribute("color", "green");
			
				RequestDispatcher rd=request.getRequestDispatcher("msg.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Database Error !");
				request.setAttribute("link", "index.html");
				request.setAttribute("bname", "Home Page");
				request.setAttribute("color", "red");
			
				RequestDispatcher rd=request.getRequestDispatcher("msg.jsp");
				rd.forward(request, response);
			}
		}
	}
}
