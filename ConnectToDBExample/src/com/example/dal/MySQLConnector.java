/**
 * 
 */
package com.example.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author MAAG
 *
 */
public class MySQLConnector implements IDBConnector {

	private String hostname;
	private String user;
	private String password;
	private Connection connection;
	
	public MySQLConnector(String hostname, String user, String password) throws Exception{
		this.hostname = hostname;
		this.user = user;
		this.password = password;
		connect();
	}
	
	@Override
	public void connect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		setConnection( DriverManager.getConnection("jdbc:mysql://"+this.hostname,this.user,this.password) );
	}

	@Override
	public boolean saveData(String query) throws Exception{
		int rs = getConnection().createStatement().executeUpdate(query);
		return rs != 0;
	}

	@Override
	public ResultSet getData(String query) throws Exception{
		return getConnection().createStatement().executeQuery(query);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

}
