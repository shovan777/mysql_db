package mysql_db;

import java.util.ArrayList;

public interface UserDao {
	ArrayList<User> getUserByLNameWIndex(String lastName);
	ArrayList<User> getUserByLNameWOIndex(String lastName);
}
