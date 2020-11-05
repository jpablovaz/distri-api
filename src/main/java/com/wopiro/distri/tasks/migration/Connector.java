package com.wopiro.distri.tasks.migration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	// @No me acuerdo como se referencia un valor desde el "aplication.properties"
	static private String host = "";

	public static Connection connection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://" + host
					+ "/frigorifica?user=root&password=mysql&allowPublicKeyRetrieval=true&useSSL=false");			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}
}
