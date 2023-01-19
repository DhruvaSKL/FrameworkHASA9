package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase 
{
public static void main(String[] args) throws SQLException 
{
//Step 1:Create an instance for Driver
	//Driver should be imported from com.mysql.cj.jdbc.Driver
	//new Driver() throws SQLException 
	Driver dbDriver = new Driver();
	
	//Step 2:Register to the dbDriver
	//DriverManager is in java.sql package
	DriverManager.registerDriver(dbDriver);
	
	//Step 3:Establish Database connection
	//Statement should be imported from java.sql package
	Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhruva","root","root");
	
	//Step 4: Create Statement
	//Statement should be imported from java.sql package
	Statement statement=connect.createStatement();
	
	//Step 5:Create Execute query to fetch data
	 int result = statement.executeUpdate("insert into students(id,name,address) values(104,'Def','Bangalore');");
	ResultSet result1 = statement.executeQuery("select * from students;");
	if(result==1)
	{
		System.out.println("DB Updated Successfully");
	}
	else
	{
		System.out.println("DB Not Updated");
	}
	
	while(result1.next())
	{
		System.out.println(result1.getInt("id")+"\t"+result1.getString("name")+"\t"+result1.getString("address"));
	}
	
	//Step 6:Close database
	connect.close();
}
}
