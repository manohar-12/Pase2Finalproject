package flyaway;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try {
			
			Properties props= new Properties();
			InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
			props.load(in);
			Connection conn=flyaway.config.getConnection(props);
			out.print("<title>update password</title>");
			String s=request.getParameter("email");
			String s1=request.getParameter("pass");
			try {
				String sql="update register set password =? where email=?;";
				PreparedStatement p=conn.prepareStatement(sql);
				p.setString(2, s);
				p.setString(1, s1);
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
					out.print("updated sucessfully");
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
					out.print("no such email found");
				}
				p.close();
				conn.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				out.print("<title>success</title>");
				out.print("<style type=\"text/css\">\r\n"
						+ "body {\r\n"
						+ "	background-image: url(aeroplane.jpg);\r\n"
						+ "	background-size: cover;\r\n"
						+ "	background-position: fixed;\r\n"
						+ "}\r\n"
						+ "</style>");
				out.print("error found");
			}
		}catch (Exception e) {
			// TODO: handle exception
			out.print("<title>success</title>");
			out.print("<style type=\"text/css\">\r\n"
					+ "body {\r\n"
					+ "	background-image: url(aeroplane.jpg);\r\n"
					+ "	background-size: cover;\r\n"
					+ "	background-position: fixed;\r\n"
					+ "}\r\n"
					+ "</style>");
			out.print("error found");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
