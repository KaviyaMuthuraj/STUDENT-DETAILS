import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UpdateServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","root");
            PreparedStatement stmt = con.prepareStatement("update student set Name='"+name+"',Gender='"+gender+"',DOB='"+dob+"' where id="+id);
            stmt.executeUpdate();
	    response.sendRedirect("update_msg_true.html");
            con.close();

        }
	catch(Exception e){
           response.sendRedirect("update_msg_false.html");
        }
	}
}

