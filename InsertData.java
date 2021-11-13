/* JDBC program to insert product data into database*/
import java.sql.*;
import java.util.*;

public class InsertData {
  public static void main(String args[])
  {
	  Connection con;
	  Statement st;
	  int pid,pri;
	  String pnm,comp;
	  
	  Scanner sc=new Scanner(System.in);
	  
	  System.out.println("Enter Product id: ");
	  pid=sc.nextInt();
	  System.out.println("Enter Product name: ");
	  pnm=sc.next();
	  System.out.println("Enter Product Company: ");
	  comp=sc.next();
	  System.out.println("Enter Product price: ");
	  pri=sc.nextInt();
	  
	  String sql="insert into product values("+pid+",'"+pnm+"','"+comp+"',"+pri+")";
	  
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","rootpassword");
		  st=con.createStatement();
		  st.executeUpdate(sql);
		  
		  System.out.println("Product data inserted successfully!!!");
		   
	      st.close();
	      con.close();
	  }
	  catch(Exception e)
	   {
		   e.printStackTrace();
	   }
  }
}
