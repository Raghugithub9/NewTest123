package DatabasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ValidateDB {
	static ResultSet r;
	public static void main(String[] args) throws SQLException {
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productmgmt", "root", "root");

		Statement st=con.createStatement();
		
		//Select Query
		String selquery="select name,price from product";
		r=st.executeQuery(selquery);
		while(r.next())
		{
			System.out.println(r.getString("name"));
		}
		
		//Update Query
		String upquery = "delete * from product where name='Laptop'";
		st.execute(upquery);
		r=st.executeQuery(selquery);
		while(r.next())
		{
			System.out.println(r.getString("name"));
		}
		//Delete Query
		
		//Insert Query
		
	}
	

}
