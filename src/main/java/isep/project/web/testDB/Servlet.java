package isep.project.web.testDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by owner on 18-04-01.
 */
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //this is a test comment
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "bae4042645f34c";
        String password = "4be98dbc";

        String jdbcUrl = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net:3306/heroku_9efd0238a94d992?reconnect=true";
        String driver = "com.mysql.jdbc.Driver";

        PrintWriter out = response.getWriter();

        try {
            out.println("Connecting to database : " + jdbcUrl);
            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl, username, password);

            out.println("SUCCESS");

            myConn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
