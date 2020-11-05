package com.wopiro.distri.tasks.migration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.User;

public class Migration {

	static Connection conn = null;
	static Statement stmt = null;

	static public void migrate() {
		loadData();
		//Test.test();
	}

	static private void loadData() {
		
		User user = new User();
		user.setName("admin");
		user = RepReference.getUserService().save(user);
		MemoryData.setUser(user);

		String table;
		String sql;

		Map<String, String> queries = new LinkedHashMap<>();
		Map<String, List<String>> dictionary = Dictionary.get();

		for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
			table = entry.getKey();
			sql = "SELECT ";
			for (String column : entry.getValue()) {
				sql += column + ", ";
			}
			sql = sql.substring(0, sql.length() - 2) + " ";
			sql += "FROM " + table;
			queries.put(table, sql);
		}
		try {
			conn = Connector.connection();
			stmt = conn.createStatement();
			ResultSet rs = null;
			for (Map.Entry<String, String> entry : queries.entrySet()) {
				table = entry.getKey();
				sql = entry.getValue();
				rs = stmt.executeQuery(sql);
				List<Map<String, Object>> map = resultSetToList(rs);
				SwitchMatch.match(table, map);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static List<Map<String, Object>> resultSetToList(ResultSet rs) {
		List<Map<String, Object>> list = null;
		try {
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			list = new ArrayList<>();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int i = 1; i <= columns; i++) {
					String columnName = md.getColumnName(i);
					if (columnName.equals("lista")) {
						row.put(columnName, rs.getShort(i));
					} else {
						row.put(columnName, rs.getObject(i));
					}
				}
				list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	static public Double roundMoney(Double value) {
		return round(value, 2);
	}

	static public Double roundWeight(Double value) {
		return round(value, 3);
	}

	static private Double round(Double value, int places) {
		if (places < 0)
			return Double.valueOf(0);

		BigDecimal bd = new BigDecimal(value.toString());
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
