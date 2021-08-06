package guestBook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestBook.model.GuestBookEntry;

/**
 * Servlet implementation class DeleteEntry
 */
@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteEntry() {
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
	
		/*
		List<GuestBookEntry>entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = getEntry(id);
		entries.remove(entry);
		response.sendRedirect("GuestBook");
		*/
		
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = null;
		
		List<GuestBookEntry>entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		for(GuestBookEntry e : entries)
			if(e.getId()==id) {
				entry =e;
				break;
			}
		if(entry !=null)entries.remove(entry);
		response.sendRedirect("GuestBook");;
		
	}


}
