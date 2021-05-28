import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AllServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
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
                           "         width:900px;\n" +
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
                           "\t\ttable,th,td {\n" +
                        "\t\t\tmargin: auto;\n" +
                        
                        "\t\t\tborder-collapse: collapse;\n" +
                        "\t\t\tfont-size: 20px;\n" +
                        "\t\t}\n" +
                        "\t\tth,td {\n" +
                        "\t\t\twidth: 200px;\n" +
                        "\t\t\tpadding: 10px;\n" +
                        "\t\t\theight: 45px;\n" +
			"\t\t\tmargin: 30px;\n" +
                        "\t\t\tbackground-color: rgba(255, 255, 255, 0.7);\n" +
			"\t\t\tcolor: rgb(34, 35, 73);\n" +
                        "\t\t}\n" +
                        "\t\tth{ \n" +
                        "\t\t\twidth: 200px;\n" +
                        "\t\t}\n" +
			"\t\ttd{ \n" +
			"\t\t\twidth: 300px;\n" +
			"\t\t\tmargin-left: 40px;\n" +
			"\t\t\ttext-align:center;\n"+
                        "\t\t}\n" +
			"\t\t.table {"+
   			"\t\theight: 300px;"+
    			"\t\toverflow-y: scroll;"+
			"\t\t}\n" +
			"::-webkit-scrollbar {"+
   			"width: 12px;"+
			"}"+

			"::-webkit-scrollbar-track {"+
    			"-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);"+
   			" border-radius: 5px;"+
			"}"+

			"::-webkit-scrollbar-thumb {"+
   			"border-radius: 5px;"+
    			"-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5);"+
			"}"+
                        "\t</style>\n" +
                        "\t\n" +
                        "</head>\n" +
                        "<body>\n" +
                            "    <div class=\"main\">\n" +
                            "    <form >\n" +
                            "        <h1>STUDENT DETAILS</h1><br>\n" +
                            "\t\t\t<div class=\"table\">\n" +
                        "\t\t\t\t <table id=\"output\">\n" +
                        "\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t<th> Person Id </th>\n" +
                        "\t\t\t\t\t\t<th> Name </th>\n" +
                        "\t\t\t\t\t\t<th> Gender </th>\n" +
                        "\t\t\t\t\t\t<th> DOB </th>\n" +
                        "\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t</table>\n" +
                        "\t\t\t</div>\n" +
                      "  <div class=\"btn\">" +
                        "<a href=\"Main_Form.html\"><input type=\"button\" name=\"cancel\" value=\"OK\" /></a>\n" +
                   "        </div>\n" +
                   "\n" +
                   "    </form>\n" +
                   "  </div>\n" +
                   "\n" +
                   "</body>\n" +
                   "</html>");
                   try{
            System.out.println("Try block entered");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","root");
            PreparedStatement stmt = con.prepareStatement("select * from student");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String pn = rs.getString(2);
                String pg = rs.getString(3);
                Date pdob = rs.getDate(4);
                out.println(
                        "<script type='text/javascript'>\n" +
                                "\t\tfunction _(selector){\n" +
                                "\t\t\treturn document.getElementById(selector);\n" +
                                "\t\t}\n" +
                                "\n" +
                                "\t\tvar outputBox = _('output');\n" +
                                "\n" +
                                "\t\toutputBox.innerHTML +="+'"' +"<tr> <td>"+id+"</td> <td>"+pn+"</td> <td>"+pg+"</td> <td>"+pdob+"</td> </tr>"+'"'+";" +
                                "\t\t\n" +
                                "\t</script>\n" +
                                "\t\n" +
                                "</body>\n" +
                                "</html>"
                );
            }
            con.close();

        }
        catch(Exception e){
            out.println("error");
        }
    }
}
