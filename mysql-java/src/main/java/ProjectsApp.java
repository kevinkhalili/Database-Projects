import java.util.Date;

import projects.dao.DbConnection;

public class ProjectsApp {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		
		//calling for connectivity to database
		DbConnection.getConnection();

	}

}
