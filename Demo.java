import java.sql.*;

public class Demo {

	public static void main(String args[]) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/db";
		String uname="root";
		String pass="rootpassword";
		String query="Select * from product";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) 
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}		
		rs.close();
		st.close();
		con.close();
		
		
	}
}
