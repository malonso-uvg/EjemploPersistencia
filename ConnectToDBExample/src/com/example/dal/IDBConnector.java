/**
 * 
 */
package com.example.dal;

import java.sql.ResultSet;

/**
 * @author MAAG
 *
 */
public interface IDBConnector {

	public void connect() throws Exception;
	
	public boolean saveData(String query) throws Exception;
	
	public ResultSet getData(String query) throws Exception; 
}
