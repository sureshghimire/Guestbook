package guestBook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestBook.model.GuestBookEntry;


@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddComment() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Generate some html
				response.setContentType("text/html");
				PrintWriter out= response.getWriter();
				
				out.println("<html><title>Add Comment</title><body>");
				
				//create html form
				out.println("<form action = 'AddComment' method = 'post'>");
				out.println("Name: <input type ='text' name = 'name' ><br>");
				out.println("<textarea name='message' rows = '6' cols = '40'></textarea></br>");
				out.println("<button>Add Comment</button>");
				out.println("</form>");
				
				out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String message = request.getParameter("message");
		GuestBookEntry entry = new GuestBookEntry(name, message);
		
		
		List<GuestBookEntry>entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		entries.add(entry);
		
		response.sendRedirect("GuestBook");
		
	}

}
