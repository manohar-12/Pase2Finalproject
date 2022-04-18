package flyaway;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerservlet")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		Properties props= new Properties();
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		Connection conn=flyaway.config.getConnection(props);
		String s=request.getParameter("fname");
		String s1=request.getParameter("lname");
		String s2=request.getParameter("email");
		String s3=request.getParameter("pass");
		out.print("<title>register</title>");
		
		try {
			String sql="insert into register(fname,lname,email,password)values(?,?,?,?);";
			PreparedStatement smt=conn.prepareStatement(sql);
			smt.setString(1, s);
			smt.setString(2, s1);
			smt.setString(3, s2);
			smt.setString(4, s3);
			
	
	
			int rs =smt.executeUpdate();
			if(rs>0) {
				out.print("<style type=\"text/css\">\r\n"
						+ "body {\r\n"
						+ "	background-image: url(aeroplane.jpg);\r\n"
						+ "	background-size: cover;\r\n"
						+ "	background-position: fixed;\r\n"
						+ "}\r\n"
						+ "</style>");
				out.print("<div align=\"center\">\r\n"
						+ "<font size=\"10\"\r\n"
						+ "face=\"verdana\"\r\n"
						+ "color=\"yellow\">Registration successful</font>\r\n"
						+ "<br>");
				response.sendRedirect("index.jsp");
				smt.close();
				conn.close();
			}
	}catch (SQLException e) {
		// TODO: handle exception
		out.print("<style type=\"text/css\">\r\n"
				+ "body {\r\n"
				+ "	background-image: url(aeroplane.jpg);\r\n"
				+ "	background-size: cover;\r\n"
				+ "	background-position: fixed;\r\n"
				+ "}\r\n"
				+ "</style>");
		out.print("<div align=\"center\">\r\n"
				+ "<font size=\"10\"\r\n"
				+ "face=\"verdana\"\r\n"
				+ "color=\"yellow\">invalid data</font>\r\n"
				+ "<br>");
		response.sendRedirect("register.jsp");
	}
		
		}catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("register.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
