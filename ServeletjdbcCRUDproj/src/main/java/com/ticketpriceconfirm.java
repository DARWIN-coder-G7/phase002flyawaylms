package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ticketpriceconfirm
 */
public class ticketpriceconfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);
		 PrintWriter out = response.getWriter();
			String full = (String)session.getAttribute("amount");
			System.out.println(full);
			 response.setContentType("text/html");
				out.println("<html><head>\r\n"
						+ "<style>\r\n"
						+ "body {\r\n"
						+ "  background-image: url('https://c4.wallpaperflare.com/wallpaper/727/731/781/flight-fiction-movie-the-film-wallpaper-preview.jpg');\r\n"
						+ "  background-repeat: no-repeat;\r\n"
						+ "  background-attachment: fixed; \r\n"
						+ "  background-size: 100% 100%;\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "</head><body>");
				out.println("<center>\r\n"
						+ "  AMOUNT YOU NEED TO PAY TO BOOK TICKET</BR></BR></BR>&#36;"+full +"</BR></BR></BR>\r\n"
						+ "<a href = \"paymentgateway.html\">BOOK TICKET</a>\r\n"
						+ "</center>");
				out.print("<center><h4>MONEY MAKES MANY THINGS ONLY WHEN YOU SPEND IT FOR A VALID ONE,EXPLORE ALL AROUND THE WORLD.</h4>\r\n"
						+ "<H4>STAY HAPPY, HAPPINESS IS THE KEY OF HEALTHY LIFE.</H4></center>");
				out.println("</html></body>");
				session.invalidate();
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
