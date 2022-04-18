package flyaway;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class displayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try {
			
			
			Properties props= new Properties();
			InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
			props.load(in);
			Connection conn=flyaway.config.getConnection(props);
			String s=request.getParameter("from");
			String s1=request.getParameter("to");
			boolean i=false;
								
				String sql="select *from display where source=? and Destination=?;";
				PreparedStatement p=conn.prepareStatement(sql);
				p.setString(1, s);
				p.setString(2,s1);
				ResultSet rs=p.executeQuery();
				i=rs.next();
				out.print("<h1 color='red'>Available flights</h1><br>");
				if(i==true) {
					out.print("<title>Book tickets</title>");
					out.print("<style type=\"text/css\">\r\n"
							+ "body {\r\n"
							+ "	background-image: url(aeroplane.jpg);\r\n"
							+ "	background-size: cover;\r\n"
							+ "	background-position: fixed;\r\n"
							+ "}\r\n"
							+ "</style>");
					out.print("<table><tr><th>Id</th><th>Airline</th><th>Source</th><th>Destination</th><th>Date</th><th>Book</th></tr></table>");
					
					while(rs.next()) {
						out.print("<table><tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>"
								+ "<td>"+rs.getString(5)+"</td><td><form action='book.jsp'><input type='submit' value='book'></form></td></tr></table>");
						
					}
					
									
					p.close();
					conn.close();
					}
			
				else {
					out.print("<title>Book tickets</title>");
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
							+ "color=\"yellow\">sorry no flights available</font>\r\n"
							+ "<br>");
					p.close();
					conn.close();
				}
				
			
		}catch (Exception e) {
			// TODO: handle exception
			out.print("<title>Book tickets</title>");
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
					+ "color=\"yellow\">sorry no flights available</font>\r\n"
					+ "<br>");
			response.sendRedirect("search.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
