import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeleteServlet extends HttpServlet {
	ResultSet rs=null;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","root");
	    PreparedStatement stmt = con.prepareStatement("select * from student where id="+id);
            rs=stmt.executeQuery();
	    if((rs.next()==true)){
           	 PreparedStatement stmt1 = con.prepareStatement("delete from student where id="+id);
            	 stmt1.executeUpdate();
	    	 response.sendRedirect("delete_msg_true.html");
	    }
	    else{
		    response.sendRedirect("delete_msg_false.html");
	    }
            con.close();
        }
	catch(Exception e){
            response.sendRedirect("delete_msg_false.html");
        }
	}
}
