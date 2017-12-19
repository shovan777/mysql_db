package mysql_db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataExtractor implements UserDao {

	@Override
	public ArrayList<User> getUserByLNameWOIndex(String lastName) {
		Connection connection = ConnectionFactory.getConnection();
		String sqlQuery = "select * from student_info where last_name = " + lastName;
		try {
			Statement stmt = connection.createStatement();
			long start = System.currentTimeMillis();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			long stop = System.currentTimeMillis();
			long queryTime = stop - start;
			System.out.println("the query took " + queryTime + " ms");
			return extractUserFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<User> getUserByLNameWIndex(String lastName) {
		Connection connection = ConnectionFactory.getConnection();
		String createIndex = "ALTER TABLE `student_info` ADD INDEX(`last_name`)";
		String sqlQuery = "select * from student_info where last_name = " + lastName;
		String deleteIndex = "ALTER TABLE student_info DROP INDEX last_name";
		try {
			Statement stmt = connection.createStatement();

			// creating index
			stmt.executeUpdate(createIndex);
			
			// measure time
			long start = System.currentTimeMillis();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			long stop = System.currentTimeMillis();
			long queryTime = stop - start;
			System.out.println("the query took " + queryTime + " ms");
			
			ArrayList<User> temp = extractUserFromResultSet(rs);
			// delete index
			stmt.executeUpdate(deleteIndex);
			return temp;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ArrayList<User> extractUserFromResultSet(ResultSet rs) throws SQLException {
		ArrayList<User> temp = new ArrayList<User>();
		while (rs.next()) {
			// Retrieve by column name
			User user = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("address"), rs.getInt("class"));

			// Display values
			System.out.println(user.toString());
			temp.add(user);
		}
		return temp;
	}
}
