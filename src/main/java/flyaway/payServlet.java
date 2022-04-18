package flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/payment")
public class payServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<title>payment succcesful</title>");
		String s=request.getParameter("name");
		String p=request.getParameter("amount");
	
		out.print("<style type=\"text/css\">\r\n"
				+ "body {\r\n"
				+ "	background-image: url(aeroplane.jpg);\r\n"
				+ "	background-size: cover;\r\n"
				+ "	background-position: fixed;\r\n"
				+ "}\r\n"
				+ "</style>");
		out.print("Name:"+s+"<br>"+"<br>"+"AmountPaid:"+p+"<br>"+"paymet:"+"payment successful"+"<br>"+"Booking Id:"+(int)Math.random()*(10000-1000+1)+1000);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
