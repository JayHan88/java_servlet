package tutorials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JoinOk extends HttpServlet {

    private Connection connection;
    private Statement stmt;
    private String name, id, pw, phone1, phone2, phone3, gender;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        actionDo(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        actionDo(request,response);
    }

    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        name = request.getParameter("name");
        id  = request.getParameter("id");
        pw = request.getParameter("pw");
        phone1 = request.getParameter("phone1");
        phone2 = request.getParameter("phone2");
        phone3 = request.getParameter("phone3");
        gender = request.getParameter("gender");

        String query = "insert into member values('"+name+"','"+id+"','"+pw+"','"+phone1+"','"+phone2+"','"+phone3+"','"+gender+"')";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "han5517", "ehfkdpahd92");
            stmt = connection.createStatement();
            int i = stmt.executeUpdate(query);
            if (i == 1){
                System.out.println("insert success!");
                response.sendRedirect("/Test/JointResult.jsp");
            }
            else {
                System.out.println("insert fail!");
                response.sendRedirect("/Test/join.html");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) stmt.close();
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
