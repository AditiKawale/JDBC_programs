/* JDBC program to accept company name from user and display data of that specified company */


import java.sql.*;

public class SearchProduct {

	 public static void main(String args[])
	 {
		 Connection con;
		 Statement st;
		 ResultSet rs;
		 String comp=args[0];
		 String query="select * from product where company= '"+comp+"'";
		 
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","rootpassword");
			 st=con.createStatement();
			 rs=st.executeQuery(query);
			 
			 while(rs.next())
			 {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			 }
			 rs.close();
			 st.close();
			 con.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
}
