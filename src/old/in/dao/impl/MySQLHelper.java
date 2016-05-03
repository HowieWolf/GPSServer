package old.in.dao.impl;

import java.sql.Connection;

import old.in.dao.DBHelper;

public class MySQLHelper implements DBHelper{

	public static final String url = "jdbc:mysql://127.0.0.1/xiaoxing";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root"; 
	
	@Override
	public Connection connectToDatabase() {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

}
