
/* JDBC program to accept prodid from user and  delete product data from database*/
import java.sql.*;
import java.util.*;

public class DeleteData {
  public static void main(String args[])
  {
	  Connection con;
	  Statement st;
	  int pid,flag=0;
	  
	  Scanner sc=new Scanner(System.in);
	  
	  System.out.println("Enter Product id: ");
	  pid=sc.nextInt();
	  
	  
	  String sql="delete from product where prodid="+pid;
	  
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","rootpassword");
		  st=con.createStatement();
		  flag=st.executeUpdate(sql);
		  
		  if(flag > 0)
		  System.out.println("Product data deleted successfully!!!");
		  else
		   System.out.println("Invalid product ID...");
		  
	      st.close();
	      con.close();
	  }
	  catch(Exception e)
	   {
		   e.printStackTrace();
	   }
  }
}
