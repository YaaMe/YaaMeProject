package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.*;
import divhtml.LoginType;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		LoginType divlogin=new LoginType();
		String div=divlogin.unlogin();
		UserDAO udao=new UserDAO();
		User user=udao.findById(name);
		if(user!=null){
		if(user.getUPassword().equals(password)&&user.getUId().equals("20010010")){
			div=divlogin.loginHtml("admin");
			request.getSession().setAttribute("id",name);
			request.getSession().setAttribute("usertype", "admin");
		}else if(user.getUPassword().equals(password)){
			div=divlogin.loginHtml(user.getUName());
			request.getSession().setAttribute("id",name);
			request.getSession().setAttribute("usertype", "user");
		}
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.print(div);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
