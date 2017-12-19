package mysql_db;

public class App {
	public static void main(String[] args) {
		// instantiate DAO
		UserDao dataAccess = new DataExtractor();
		String lastName = "'miller'";
		System.out.println("Selection without indexing");
		dataAccess.getUserByLNameWOIndex(lastName);
		System.out.println("\n\n\n*******************\n");
		dataAccess.getUserByLNameWIndex(lastName);

	}

}
