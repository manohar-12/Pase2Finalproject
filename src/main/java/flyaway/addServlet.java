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


@WebServlet("/add")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties props= new Properties();
		PrintWriter out=response.getWriter();
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		Connection conn=flyaway.config.getConnection(props);
		String s=request.getParameter("name");
		String s1=request.getParameter("from");
		String s2=request.getParameter("to");
		String s3=request.getParameter("date");
		
		
							
			String sql=" insert into display(airline,source,Destination,date)values(?,?,?,?);";
			PreparedStatement p;
			
			try {
				p = conn.prepareStatement(sql);
				
				p.setString(1,s);
				p.setString(2,s1);
				p.setString(3,s2);
				p.setString(4,s3);
				int i=p.executeUpdate();
				if(i>0) {
					out.print("<title>success</title>");
					out.print("<style type=\"text/css\">\r\n"
							+ "body {\r\n"
							+ "	background-image: url(aeroplane.jpg);\r\n"
							+ "	background-size: cover;\r\n"
							+ "	background-position: fixed;\r\n"
							+ "}\r\n"
							+ "</style>");
					out.print("added suceesfully");
					p.close();
					conn.close();
				}else
				{
					out.print("<title>error</title>");
					out.print("<style type=\"text/css\">\r\n"
							+ "body {\r\n"
							+ "	background-image: url(aeroplane.jpg);\r\n"
							+ "	background-size: cover;\r\n"
							+ "	background-position: fixed;\r\n"
							+ "}\r\n"
							+ "</style>");
					out.print("failed to add");
					p.close();
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.sendRedirect("add.jsp");
			}
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
