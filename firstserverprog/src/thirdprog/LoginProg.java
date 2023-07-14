package thirdprog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/LoginProg")
public class LoginProg extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String num2=req.getParameter("name1");
		String num3=req.getParameter("phonenum");
		String num=req.getParameter("gmail");
		String num1=req.getParameter("pass");
		
		
		
		String url="jdbc:mysql://localhost:3307?user=root&password=12345";
		String query="insert into test.userinfo values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,num2);
			ps.setString(2, num3);
		    ps.setString(3,num1);
		    ps.setString(4,num);
		    
		    ps.executeUpdate();
		    PrintWriter pw=resp.getWriter();
		    pw.println("Registration was successful");
		//    if(rs.next())
		    {
		    //	PrintWriter pw=resp.getWriter();
		    //	pw.println("login was sucessful");
		   // 	String name=rs.getString("name");
		    //	pw.println("wellcome "+name);
		    //	System.out.println("login was sucessful");
		    }
		 //   else
		    {	
		    //	PrintWriter pw=resp.getWriter();
		    //	pw.println("login was unsucessful");
		    //	System.out.println("login was unsucessful");
		    }
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		
		
	}

	
	
	

}
