package DatabasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcrudExample {

	static ResultSet r;
	public static void main(String[] args) throws SQLException {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productmgmt", "root", "root");
		Statement st=con.createStatement();
		
		System.out.println("***********SELECT QUERY*************");
		//Select Query
		String selquery="select firstname,lastname from Student";
		r=st.executeQuery(selquery);
		while(r.next())
		{
			System.out.println(r.getString("firstname"));
		}
		System.out.println("************INSERT QUERY***************");
		//Insert Query
				String inquery="Insert into Student values(7,\"Raghu7\",\"Trainer7\");\r\n"
						+ "";
				st.executeUpdate(inquery);
				r=st.executeQuery(selquery);
				while(r.next())
				{
					System.out.println(r.getString("firstname"));
				}
		
				System.out.println("***********DELETE QUERY************");
				
				//Delete Query
				String dequery="delete from Student where firstname='Raghu7'";
				st.executeUpdate(dequery);
				r=st.executeQuery(selquery);
				while(r.next())
				{
					System.out.println(r.getString("firstname"));
				}
				
				System.out.println("***********UPDATE QUERY************");
				
				//Delete Query
				String upquery="Update Student SET firstname='Raghu14' where firstname='Raghu4'";
				st.executeUpdate(upquery);
				r=st.executeQuery(selquery);
				while(r.next())
				{
					System.out.println(r.getString("firstname"));
				}

		
		
	

	}

}
