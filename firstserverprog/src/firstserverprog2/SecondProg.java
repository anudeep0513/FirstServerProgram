package firstserverprog2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/SecondProg")
public class SecondProg extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String num=req.getParameter("m1");
		String num1=req.getParameter("m2");
		System.out.println("NAME :"+num);
		System.out.println("Age :"+num1);
		
	
	String url="jdbc:mysql://localhost:3307?user=root&password=12345";
	String query="insert into test.server values(?,?)";
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url);
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,num);
		ps.setString(2,num1);
		
		ps.executeUpdate();
		
		con.close();
	}
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
