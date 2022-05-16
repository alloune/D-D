package GameCore;

import java.sql.*;


public class Request {
    public Statement connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dungeonanddragon","root",""
        );
        Statement stmt=con.createStatement();

        return stmt;
    }

    public ResultSet request(String request, Statement connection) throws SQLException {
        ResultSet rs=connection.executeQuery(request);
      return rs;

    }




}
