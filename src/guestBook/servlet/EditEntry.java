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

/**
 * Servlet implementation class EditEntry
 */
@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

    private GuestBookEntry getEntry(int id) {
    	List<GuestBookEntry>entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
    	for(GuestBookEntry entry: entries)
    		if(entry.getId()==id) return entry;
    	return null;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookEntry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		
		//Generate some html
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		out.println("<html><title>Edit Comment</title><body>");
		
		//create html form
		out.println("<form method = 'post'>");
		out.println("Name: <input type ='text' name = 'name' value = '"+entry.getName()+"'><br>");
		out.println("<textarea name='message' rows = '6' cols = '40'>"+entry.getMessage()+"</textarea></br>");
		out.println("<button>Save</button>");
		out.println("</form>");
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookEntry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		entry.setName(request.getParameter("name"));
		entry.setMessage(request.getParameter("message"));
		response.sendRedirect("GuestBook");
	}

}
