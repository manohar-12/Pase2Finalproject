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

@WebServlet("/adminlogin")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			boolean status=false;
			Properties props= new Properties();
			InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
			props.load(in);
			Connection conn=flyaway.config.getConnection(props);
			out.print("<title>register</title>");
			String s=request.getParameter("email");
			String s1=request.getParameter("pass");
			try {
				String sql="select email,password from register where email=? and password =?;";
				PreparedStatement p=conn.prepareStatement(sql);
				p.setString(1, s);
				p.setString(2, s1);
				ResultSet rs=p.executeQuery();
				status=rs.next();
				if(status==true) {
					response.sendRedirect("features.jsp");
				}else
				{
					response.sendRedirect("admin.jsp");
					out.print("register first:");
				}
				p.close();
				conn.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				response.sendRedirect("admin.jsp");
			}
		}catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("admin.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
