/*JDBC program to accept product id and amount from user and reduce the price of that product by specified amount*/

import java.sql.*;

public class SearchUpdateProduct {
   public static void main(String[] args)
   {
	   int pid=Integer.parseInt(args[0]);
	   int amt=Integer.parseInt(args[1]);
	   int flag=0;
	   
	  String sql="update product set price=price-"+amt+" where prodid="+pid;
	   
	   Connection con;
	   Statement st;
	   
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","rootpassword");
		   st=con.createStatement();
		   
		   flag=st.executeUpdate(sql);
		   
		   if(flag>0)
			   System.out.println("Price Updated Succesfully!!!");
		   else
			   System.out.println("Invalid Product ID..");
		   
	       st.close();
	       con.close();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
}
