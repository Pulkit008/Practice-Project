package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private Connection con=null;
	private PreparedStatement pt;
	private ResultSet rs;
	
	public Database()
	{
			try 
			{
				if(con==null)
				{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registerlogin","root","");
					if(con!=null)
						System.out.println("Connection Established");
				}
				else
				{
					System.out.println("Connection already Established");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public boolean insert(User u)
	{
		try 
		{			
			pt=con.prepareStatement("insert into records values(?, ?, ?)");
			
			pt.setString(1, u.getName());
			pt.setString(2, u.getUsername());
			pt.setString(3, u.getPassword());
			
			pt.executeUpdate();
			System.out.println("Data Entered");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean checkuser(String u) {
		try 
		{			
			pt=con.prepareStatement("select * from records where username=?");
			
			pt.setString(1, u);
			rs=pt.executeQuery();
			
			if (rs.next())
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
}