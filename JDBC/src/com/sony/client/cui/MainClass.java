/**
 * 
 */
package com.sony.client.cui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author arafath
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@ARAFATH-LAPTOP:1521:XE","arafath","dbpass");


				preparedStatement = connection.prepareStatement("SELECT * FROM LOGIN ");

				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()){
					
					System.out.println(resultSet.getString(1)+","+resultSet.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					if(resultSet!=null && !resultSet.isClosed()){
						resultSet.close();
					}
					if(preparedStatement!=null && !preparedStatement.isClosed()){
						preparedStatement.close();
					}
					if(connection!=null && !connection.isClosed()){
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		


	}

}
