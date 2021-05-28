import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SearcingServlet extends HttpServlet {
	ResultSet rs = null;
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String i = request.getParameter("id");  
        System.out.println("pid   num "+i);
       	PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<!DOCTYPE html>\n" +
                           "<html>\n" +
                           "<head>\n" +
                           "    <title>SEARCH_FORM</title>\n" +
                           "    <style type=\"text/css\">\n" +
                           "        body,html{\n" +
                           "            margin: 0px;\n" +
                           "            box-sizing: border-box;\n" +
                           "            background-image: url('img.jpg');\n" +
                           "            background-size: cover;\n" +
                           "        }\n" +
                           "        .main{\n" +
                           "         width:800px;\n" +
                           "         height:600px;\n" +
                           "         line-height:20px;\n" +
                           "         border:0.3px solid rgba(246, 246, 246, 0.2);\n" +
                           "         border-radius:3%;\n" +
                           "         align-items:center;\n" +
                           "         position:absolute;\n" +
                           "         margin:9.4% 28%;\n" +
                           "         background-color:rgba(246, 246, 246, 0.4);\n" +
                           "       }\n" +
                           "       h1{\n" +
                           "         color:white;\n" +
                           "         font-size:50px;\n" +
                           "         font-weight: bold;\n" +
                           "         padding:20px;\n" +
                           "         text-align:center;\n" +
                           "       }\n" +
                           "        input[type=button] {\n" +
                           "          width: 18%;\n" +
                           "          font-size:22px;\n" +
                           "          margin-left: 0px;\n" +
                           "          border: 0px;\n" +
                           "          font-weight: bold;\n" +
                           "          padding: 15px;\n" +
                           "          background-color: #3eb8fa;\n" +
                           "          color: white;\n" +
                           "          cursor: pointer;\n" +
                           "        }\n" +
                           "\n" +
                           "        input[type=button]:hover {\n" +
                           "          background-color: #f2f8f3;\n" +
                           "          color: #3eb8fa;\n" +
                           "        }\n" +
                           "        .btn{\n" +
                           "            margin-top: 50px;\n" +
                           "            text-align: right;\n" +
                           "            margin-right: 90px;\n" +
                           "        }\n" +
                           "        #table{\n" +
                           "\n" +
                           "        }\n" +
                           "\n" +
                           "        table,th,td {\n" +
                           "            margin: auto;\n" +
                           "            margin-top: 10px;\n" +
                           "            border-collapse: collapse;\n" +
                           "            font-size: 25px;\n" +
                           "        }\n" +
                           "        th,td{\n" +
                           "            padding: 5px;\n" +
                           "            height: 60px;\n" +
                           "            background-color: rgba(255, 255, 255, 0.7);\n" +
                           "            text-align: left;\n" +
                           "            color: rgb(34, 35, 73);\n" +
                           "            padding-left:20px;\n" +
                           "            width: 250px; \n" +
                           "        } \n" +
                           "             \n" +
                           "    </style>\n" +
                           "</head>\n" +
                           "<body>\n" +
                           "    <div class=\"main\">\n" +
                           "    <form >\n" +
                           "        <h1>STUDENT DETAILS</h1><br>\n" +
                           "        <div id=\"table\">\n" +
                           "            <table>\n" +
                           "                <tr>\n" +
                           "                    <th> Person Id </th>\n" +
                           "                    <td id=\"pid\">  - </td>\n" +
                           "                </tr>\n" +
                           "                <tr>\n" +
                           "                    <th> Name </th>\n" +
                           "                    <td id=\"nme\">  - </td>\n" +
                           "                </tr>\n" +
                           "                <tr>\n" +
                           "                    <th> Gender </th>\n" +
                           "                    <td id=\"gender\">  - </td>\n" +
                           "                </tr>\n" +
                           "                <tr>\n" +
                           "                    <th> DOB </th>\n" +
                           "                    <td id=\"dob\">  - </td>\n" +
                           "                </tr>\n" +
                           "            </table>\n" +
                           "        </div>\n" +
                           "        <div class=\"btn\">\n" +
                           "            <a href=\"Main_Form.html\"><input type=\"button\" name=\"cancel\" value=\"OK\" /></a>\n" +
                           "        </div>\n" +
                           "\n" +
                           "    </form>\n" +
                           "  </div>\n" +
                           "\n" +
                           "</body>\n" +
                           "</html>"
                );
        try{
	    System.out.println("Try block entered");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","root");
            PreparedStatement stmt = con.prepareStatement("select * from student where id="+i);
            rs = stmt.executeQuery();
	    if((rs.next()==true)){
		    System.out.println("if blck enter");
	            //while(rs.next()){
		    	System.out.println("Rs --> "+rs);
			System.out.println("while entered");
                	int id = rs.getInt(1);
                	String pn = rs.getString(2);
			System.out.println("Name--->"+pn);
                	String pg = rs.getString(3);
                	Date pdob = rs.getDate(4);
			out.println(
                        	"<script type='text/javascript'>\n" +
                       		 "\t\tfunction _(selector){\n" +
                        	"\t\t\treturn document.getElementById(selector);\n" +
                        	"\t\t}\n" +
                        	"\n" +
                        	"\t\tvar pidBox = _('pid');\n" +
                        	"\t\tvar nmeBox = _('nme');\n" +
                        	"\t\tvar genderBox = _('gender');\n" +
                        	"\t\tvar dobBox = _('dob');\n" +
                        	"\t\n" +
                        	"\t\tpidBox.innerText = '"+id+"';\n" +
                        	"\t\tnmeBox.innerText = '"+pn+"';\n" +
				"\n"+
                        	"\t\tgenderBox.innerText = '"+pg+"';\n" +
                        	"\t\tdobBox.innerText = '"+pdob+"';\n" +
                        	"\n" +
                        	"\t</script>\n" +
                        	"\t\n" +
                        	"</body>\n" +
                        	"</html>"
                    	);
                	con.close();
		    }
	    else{
		    response.sendRedirect("search_msg_true.html");
	    }
      }  catch(Exception e){
            response.sendRedirect("search_msg_true.html");
        }
	finally{

	}
    }
}
